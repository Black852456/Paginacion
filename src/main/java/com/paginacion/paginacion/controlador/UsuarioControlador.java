package com.paginacion.paginacion.controlador;

import com.paginacion.paginacion.entidad.Usuario;
import com.paginacion.paginacion.servicio.UsuarioServicioAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class UsuarioControlador {

    @Autowired
    private UsuarioServicioAPI usuarioServicioAPI;

    @GetMapping(value = "/")
    public String findAll(@RequestParam Map<String,Object> params, Model model){
        int page = params.get("page") != null ? Integer.parseInt(params.get("page").toString()) - 1 :0;
        PageRequest pageRequest = PageRequest.of(page,10);
        Page<Usuario> pageUsuario = usuarioServicioAPI.getAll(pageRequest);
        int totalPage = pageUsuario.getTotalPages();

        if(totalPage>0){
            List<Integer> pages = IntStream.rangeClosed(1,totalPage).boxed().collect(Collectors.toList());
            model.addAttribute("pages",pages);
        }
        model.addAttribute("list",pageUsuario.getContent());
        model.addAttribute("current",page+1);
        model.addAttribute("next",page+2);
        model.addAttribute("prev",page);
        model.addAttribute("last",totalPage);
        return "index";
    }

}
