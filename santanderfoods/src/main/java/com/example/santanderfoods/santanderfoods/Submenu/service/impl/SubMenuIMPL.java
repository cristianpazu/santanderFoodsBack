package com.example.santanderfoods.santanderfoods.Submenu.service.impl;

import com.example.santanderfoods.santanderfoods.Menu.entidades.Menu;
import com.example.santanderfoods.santanderfoods.Menu.entidades.dto.MenuResponseDTO;
import com.example.santanderfoods.santanderfoods.Menu.repository.MenuRepository;
import com.example.santanderfoods.santanderfoods.Submenu.entidades.SubMenu;
import com.example.santanderfoods.santanderfoods.Submenu.entidades.dto.SubMenuRequestDTO;
import com.example.santanderfoods.santanderfoods.Submenu.entidades.dto.SubMenuResponseDTO;
import com.example.santanderfoods.santanderfoods.Submenu.repository.SubMenuRepository;
import com.example.santanderfoods.santanderfoods.Submenu.service.SubMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class SubMenuIMPL implements SubMenuService {
    @Autowired
    SubMenuRepository subMenuRepository;

    @Autowired
    MenuRepository menuRepository;


    @Override
    public SubMenuResponseDTO registrarSubmenu(SubMenuRequestDTO subMenuRequestDTO) {
        try{
   Menu menu = menuRepository
                .findById(subMenuRequestDTO.getMenuId())
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "El menu no existe"
                ));
              SubMenu subMenu = new SubMenu();

               subMenu.setNombre(subMenuRequestDTO.getNombre());
               subMenu.setActivo(subMenuRequestDTO.isActivo());
               subMenu.setMenu(menu);

               SubMenu guardado =  subMenuRepository.save(subMenu);

               SubMenuResponseDTO response = new SubMenuResponseDTO();

               response.setIdSubmen(guardado.getIdSubmenu());
               response.setNombre(guardado.getNombre());
               response.setMenuId(guardado.getMenu().getIdMenu());
               response.setActivo(guardado.isActivo());

               return  response;
            }catch (Exception e) {
           throw new RuntimeException(e);

       }
    }

    @Override
    public SubMenuResponseDTO actualizarSubmenu(Integer id, SubMenuRequestDTO subMenuRequestDTO) {
        return null;
    }

    @Override
    public List<SubMenuResponseDTO> traerSubmenu() {
      return  null;
    }

    @Override
    public SubMenuResponseDTO inactivarSubmenu(Integer id, Boolean inactivarSubmenu) {
      try{


          SubMenu subMenu = subMenuRepository.findById(id).orElseThrow(() ->  new ResponseStatusException(
                  HttpStatus.NOT_FOUND,
                  "El menu no existe"
          ));
          subMenu.setActivo(inactivarSubmenu);

          SubMenu subMenuInactivo =  subMenuRepository.save(subMenu);


          SubMenuResponseDTO response = new SubMenuResponseDTO();

        response.setIdSubmen(subMenuInactivo.getIdSubmenu());
        response.setNombre(subMenuInactivo.getNombre());
        response.setActivo(subMenuInactivo.isActivo());
        response.setMenuId(
                subMenuInactivo.getMenu().getIdMenu()
        );

        return  response;
      } catch (Exception e) {
          throw new RuntimeException(e);
      }
    }

    @Override
    public List<SubMenuResponseDTO> consultarSubmenu() {
        try{


            List<SubMenuResponseDTO> subMenuList = subMenuRepository.findSubMenuResponseDtoList();

            System.out.println("subMenuList = " + subMenuList);

            if (subMenuList.isEmpty()){
                throw new RuntimeException("La lista esta vacia");
            }

            return subMenuList;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
