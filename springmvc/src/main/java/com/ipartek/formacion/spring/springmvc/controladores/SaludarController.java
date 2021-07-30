package com.ipartek.formacion.spring.springmvc.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SaludarController {
    @RequestMapping("/saludar")
    public String saludar(@RequestParam(defaultValue = "Mundo") String nombre, Model modelo) {
        modelo.addAttribute("nombre", nombre + " lalaralalaa");
        return "saludo";
    }
}
