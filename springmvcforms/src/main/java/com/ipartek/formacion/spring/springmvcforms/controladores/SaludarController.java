package com.ipartek.formacion.spring.springmvcforms.controladores;

import com.ipartek.formacion.spring.springmvcforms.modelos.Saludo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/saludar")
public class SaludarController {
    @GetMapping
    public String saludarForm(Saludo saludo) {
        return "saludo";
    }

    @PostMapping
    public String saludarPost(Saludo saludo) {
        return "resultado";
    }
}
