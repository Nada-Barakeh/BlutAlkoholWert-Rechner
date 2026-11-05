package de.hhu.pp2.blutalkoholwert;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AlkoholController {
// hier sollte 2 methoden sein ein get: gibt den formuler leer
// & ein post: macht validation , rechnen & gibt den seite mit resultat aus

    @GetMapping("/")
    public String showFormuler(AlkoholForm alkohol, Model model){
      model.addAttribute("Getränke", new AlkoholForm()) ;
      return "form";
    }

    @PostMapping("/")
    public String result(@Valid AlkoholForm alkohol, BindingResult result, Model model){

        if(result.hasErrors()){
            return "form";
        }
        double blutAlkoholwert = AlkoholRechner.blutAlkoholWert(alkohol);
        model.addAttribute("blutAlkoholwert" , blutAlkoholwert);
        return "form";
    }

    }
