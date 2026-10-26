package com.example.santanderfoods.santanderfoods.Restaurantes.service.impl;

import com.example.santanderfoods.santanderfoods.Menu.entidades.dto.MenuCompletoResponseDTO;
import com.example.santanderfoods.santanderfoods.Restaurantes.entidades.Restaurantes;
import com.example.santanderfoods.santanderfoods.Restaurantes.entidades.dto.RestauranteCompletoResponseDTO;
import com.example.santanderfoods.santanderfoods.Restaurantes.entidades.dto.RestaurantesRequestDTO;
import com.example.santanderfoods.santanderfoods.Restaurantes.entidades.dto.RestaurantesResponseDTO;
import com.example.santanderfoods.santanderfoods.Restaurantes.repositorty.RestauranteRepository;
import com.example.santanderfoods.santanderfoods.Restaurantes.service.RestaurateService;
import com.example.santanderfoods.santanderfoods.Submenu.entidades.dto.SubMenuCompletoResponseDTO;
import com.example.santanderfoods.santanderfoods.productos.entidades.dto.ProductoCompletoResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@Service
public class RestaurantesIMPL implements RestaurateService {


    @Autowired
    RestauranteRepository restauranteRepository;

    @Override
    public RestaurantesResponseDTO registrarRestaurantes(RestaurantesRequestDTO restaurantesRequestDTO) {
        try {



            Restaurantes restaurante = new Restaurantes();

            restaurante.setNombre(restaurantesRequestDTO.getNombre());
            restaurante.setActivo(restaurantesRequestDTO.isActivo());
            restaurante.setDireccion(restaurantesRequestDTO.getDireccion());
            restaurante.setTelefono(restaurantesRequestDTO.getTelefono());
            restaurante.setDescripcion(restaurantesRequestDTO.getDescripcion());

            Restaurantes guardado =  restauranteRepository.save(restaurante);

            RestaurantesResponseDTO response = new RestaurantesResponseDTO();

            response.setIdRestaurante(guardado.getIdRestaurante());
            response.setNombre(guardado.getNombre());
            response.setDireccion(guardado.getDireccion());
            response.setTelefono(guardado.getTelefono());
            response.setDescripcion(guardado.getDescripcion());
            response.setActivo(guardado.isActivo());



            return response;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public RestaurantesResponseDTO actualizarRestaurantes(Integer id, RestaurantesRequestDTO restaurantesRequestDTO) {

try {

    Restaurantes restaurantesRequestDTO1 = restauranteRepository.findById(id).orElseThrow(() -> new ResponseStatusException(
            HttpStatus.NOT_FOUND,
            "El restaurante con ID " + id + " no existe"
    ));

    restaurantesRequestDTO1.setNombre(restaurantesRequestDTO.getNombre());
    restaurantesRequestDTO1.setDireccion(restaurantesRequestDTO.getDireccion());
    restaurantesRequestDTO1.setDescripcion(restaurantesRequestDTO.getDescripcion());
    restaurantesRequestDTO1.setTelefono(restaurantesRequestDTO.getTelefono());

    Restaurantes restauranteActualizado = restauranteRepository.save(restaurantesRequestDTO1);

    RestaurantesResponseDTO responseDTO = new RestaurantesResponseDTO();

    responseDTO.setIdRestaurante(restauranteActualizado.getIdRestaurante());
    responseDTO.setNombre(restauranteActualizado.getNombre());
    responseDTO.setDireccion(restauranteActualizado.getDireccion());
    responseDTO.setDescripcion(restauranteActualizado.getDescripcion());
    responseDTO.setTelefono(restauranteActualizado.getTelefono());

    return responseDTO;

} catch (Exception e) {
    throw new RuntimeException(e);
}


    }

    @Override
    public List<RestaurantesResponseDTO> listarRestaurantes() {
        try{


            List<RestaurantesResponseDTO> restaurante = restauranteRepository.listarTodosRestaurantes();

            if (restaurante.isEmpty()){
                throw new RuntimeException("La lista esta vacia");
            }

            return restaurante;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public RestauranteCompletoResponseDTO traerRestauratesId(Integer id) {
        try{
            Restaurantes restaurantesRequestDTO = restauranteRepository.findById(id).orElseThrow(() -> new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "El restaurante con ID " + id + " no existe"
            ));

            RestauranteCompletoResponseDTO restaurantesResponseDTO = new RestauranteCompletoResponseDTO();
            restaurantesResponseDTO.setIdRestaurante(restaurantesRequestDTO.getIdRestaurante());
            restaurantesResponseDTO.setNombre(restaurantesRequestDTO.getNombre());
            restaurantesResponseDTO.setDireccion(restaurantesRequestDTO.getDireccion());
            restaurantesResponseDTO.setTelefono(restaurantesRequestDTO.getTelefono());
            restaurantesResponseDTO.setActivo(restaurantesRequestDTO.isActivo());

            if (restaurantesRequestDTO.getMenus().isEmpty()) {
                throw new RuntimeException("No tiene menus");
            }


            List<MenuCompletoResponseDTO> menusDTO = restaurantesRequestDTO.getMenus().stream()
                    .filter(Menus ->Menus.isActivo())
                    .map(menu -> {

                        MenuCompletoResponseDTO menuDTO = new MenuCompletoResponseDTO();
                        menuDTO.setIdMenu(menu.getIdMenu());
                        menuDTO.setNombreMenu(menu.getNombreMenu());
                        menuDTO.setActivo(menu.isActivo());

                        List<SubMenuCompletoResponseDTO> submenus = menu.getSubmenus().stream()
                                .filter(SubMenu ->SubMenu.isActivo())
                                .map(sm -> {

                                    SubMenuCompletoResponseDTO smDTO = new SubMenuCompletoResponseDTO();
                                    smDTO.setIdSubmenu(sm.getIdSubmenu());
                                    smDTO.setNombre(sm.getNombre());
                                    smDTO.setActivo(sm.isActivo());

                                    List<ProductoCompletoResponseDTO> productos = sm.getProductos().stream()
                                            .filter(p -> p.isActivo())
                                            .map(p -> new ProductoCompletoResponseDTO(
                                                    p.getIdProductos(),
                                                    p.getNombre(),
                                                    p.getDescripcion(),
                                                    p.getPrecio(),
                                                    p.isActivo()
                                            )).toList();

                                    smDTO.setProductos(productos);
                                    return smDTO;

                                }).toList();

                        menuDTO.setSubmenus(submenus);
                        return menuDTO;

                    }).toList();

            restaurantesResponseDTO.setMenus(menusDTO);

            return restaurantesResponseDTO;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
