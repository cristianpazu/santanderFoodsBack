package com.example.santanderfoods.santanderfoods.Menu.service.impl;

import com.example.santanderfoods.santanderfoods.Menu.entidades.Menu;
import com.example.santanderfoods.santanderfoods.Menu.entidades.dto.MenuRequestDTO;
import com.example.santanderfoods.santanderfoods.Menu.entidades.dto.MenuResponseDTO;
import com.example.santanderfoods.santanderfoods.Menu.repository.MenuRepository;
import com.example.santanderfoods.santanderfoods.Menu.service.MenuService;
import com.example.santanderfoods.santanderfoods.Restaurantes.entidades.Restaurantes;
import com.example.santanderfoods.santanderfoods.Restaurantes.repositorty.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class MenuIMPL implements MenuService  {

    @Autowired
    RestauranteRepository restauranteRepository;

    @Autowired
    MenuRepository menuRepository;


    @Override
    public MenuResponseDTO registrarMenu(MenuRequestDTO menuRequestDTO) {
        try{

            Restaurantes restaurante = restauranteRepository
                    .findById(menuRequestDTO.getIdRestaurante())
                    .orElseThrow(() -> new ResponseStatusException(
                            HttpStatus.NOT_FOUND,
                            "El restaurante no existe"
                    ));

            Menu menu = new Menu();

            menu.setNombreMenu(menuRequestDTO.getNombreMenu());
            menu.setActivo(menuRequestDTO.isActivo());
            menu.setRestaurante(restaurante);

            Menu menuGuardado = menuRepository.save(menu);



            MenuResponseDTO response = new MenuResponseDTO();
            response.setIdMenu(menuGuardado.getIdMenu());
            response.setNombreMenu(menuGuardado.getNombreMenu());
            response.setActivo(menuGuardado.isActivo());
            response.setIdRestaurante(
                    menuGuardado.getRestaurante().getIdRestaurante()
            );



            return response;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public MenuResponseDTO actualizarMenu(Integer id, MenuRequestDTO menuRequestDTO) {

        try {
            Menu menu = menuRepository.findById(id).orElseThrow(() -> new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "El MENU con ID " + id + " no existe"
            ));

            Restaurantes restaurante = restauranteRepository
                    .findById(menuRequestDTO.getIdRestaurante())
                    .orElseThrow(() -> new ResponseStatusException(
                            HttpStatus.NOT_FOUND,
                            "El restaurante no existe"
                    ));

            menu.setNombreMenu(menuRequestDTO.getNombreMenu());
            menu.setActivo(menuRequestDTO.isActivo());
            menu.setRestaurante(restaurante);

            Menu menuActualizado = menuRepository.save(menu);

            // 5. Construir el DTO de respuesta
            MenuResponseDTO response = new MenuResponseDTO();

            response.setIdMenu(menuActualizado.getIdMenu());
            response.setNombreMenu(menuActualizado.getNombreMenu());
            response.setActivo(menuActualizado.isActivo());
            response.setIdRestaurante(
                    menuActualizado.getRestaurante().getIdRestaurante()
            );

            return response;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public MenuResponseDTO inactivarMenu(Integer id, Boolean inactiva) {
        try {

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




            return response;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public List<MenuResponseDTO> taerMenu() {
       try{

           List<MenuResponseDTO> menus = menuRepository.findAllMenu();

           if (menus.isEmpty()){
               throw new RuntimeException("La lista esta vacia");
           }

           return menus;

       } catch (Exception e) {
           throw new RuntimeException(e);
       }
    }
}
