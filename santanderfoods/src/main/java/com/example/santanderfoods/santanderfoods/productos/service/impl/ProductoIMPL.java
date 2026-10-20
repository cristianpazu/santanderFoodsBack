package com.example.santanderfoods.santanderfoods.productos.service.impl;

import com.example.santanderfoods.santanderfoods.Submenu.entidades.SubMenu;
import com.example.santanderfoods.santanderfoods.Submenu.repository.SubMenuRepository;
import com.example.santanderfoods.santanderfoods.productos.entidades.Productos;
import com.example.santanderfoods.santanderfoods.productos.entidades.dto.ProductoRequestDTO;
import com.example.santanderfoods.santanderfoods.productos.entidades.dto.ProductoResponseDTO;
import com.example.santanderfoods.santanderfoods.productos.repository.ProductosRepository;
import com.example.santanderfoods.santanderfoods.productos.service.ProductoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoIMPL implements ProductoService {



    ProductosRepository productosRepository;

    SubMenuRepository submenuRepository;

    public ProductoIMPL(ProductosRepository productosRepository,
                        SubMenuRepository submenuRepository) {
        this.productosRepository = productosRepository;
        this.submenuRepository = submenuRepository;
    }

    @Override
    public ProductoResponseDTO registrarProducto(ProductoRequestDTO productoRequestDTO) {
        try{
            Integer submenuId = productoRequestDTO.getIdSubMenu();

            SubMenu submenu = submenuRepository.findById(submenuId)
                    .orElseThrow(() -> new RuntimeException("Submenu no existe"));


            Productos productos = new Productos();

            productos.setNombre(productoRequestDTO.getNombre());
            productos.setDescripcion(productoRequestDTO.getDescripcion());
            productos.setPrecio(productoRequestDTO.getPrecio());
            productos.setActivo(productoRequestDTO.isActivo());
            productos.setSubmenu(submenu);

            Productos guardado =  productosRepository.save(productos);


            ProductoResponseDTO productoResponseDTO = new ProductoResponseDTO();
            productoResponseDTO.setId(guardado.getIdProductos());
            productoResponseDTO.setNombre(guardado.getNombre());
            productoResponseDTO.setDescripcion(guardado.getDescripcion());
            productoResponseDTO.setActivo(guardado.isActivo());
            productoResponseDTO.setIdSubmenu(guardado.getSubmenu().getIdSubmenu());

            /*
            * Restaurantes restaurante = new Restaurantes();

            restaurante.setNombre(restaurantesRequestDTO.getNombre());
            restaurante.setActivo(restaurantesRequestDTO.isActivo());
            restaurante.setDireccion(restaurantesRequestDTO.getDireccion());
            restaurante.setTelefono(restaurantesRequestDTO.getTelefono());

            Restaurantes guardado =  restauranteRepository.save(restaurante);

            RestaurantesResponseDTO response = new RestaurantesResponseDTO();

            response.setIdRestaurante(guardado.getIdRestaurante());
            response.setNombre(guardado.getNombre());
            response.setDireccion(guardado.getDireccion());
            response.setTelefono(guardado.getTelefono());
            response.setActivo(guardado.isActivo());*/



            return productoResponseDTO;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ProductoResponseDTO actualizarProducto(Integer id, ProductoRequestDTO productoRequestDTO) {
        return null;
    }

    @Override
    public ProductoResponseDTO inactivarProductos(Integer id, Boolean inactiva) {
        Productos productos = productosRepository.findById(id).orElseThrow(() -> new RuntimeException("Productos no encontrado"));

        productos.setActivo(inactiva);
        Productos productosInactivo =     productosRepository.save(productos);

        ProductoResponseDTO productoResponseDTO = new ProductoResponseDTO();
        productoResponseDTO.setId(productosInactivo.getIdProductos());
        productoResponseDTO.setNombre(productosInactivo.getNombre());
        productoResponseDTO.setActivo(productosInactivo.isActivo());

        /*
           Menu menu =  menuRepository.findById(id) .orElseThrow(() -> new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "El menu no existe"
            ));

            menu.setActivo(inactiva);

            Menu menuInactivado = menuRepository.save(menu);

            // Construir la respuesta
            MenuResponseDTO response = new MenuResponseDTO();
            response.setIdMenu(menuInactivado.getIdMenu());
            response.setNombreMenu(menuInactivado.getNombreMenu());
            response.setActivo(menuInactivado.isActivo());
            response.setIdRestaurante(
                    menuInactivado.getRestaurante().getIdRestaurante()
            );
        * */

        return productoResponseDTO;
    }

    @Override
    public List<ProductoResponseDTO> consultarProductos() {
        try{
            List<ProductoResponseDTO> productosList = productosRepository.findProductoResponseDtos();

            System.out.println("productosList = " + productosList);


            if (productosList.isEmpty()){
                throw new RuntimeException("La lista esta vacia");
            }

            return productosList;
        } catch (Exception e) {
            throw new RuntimeException(e);

        }
    }
}
