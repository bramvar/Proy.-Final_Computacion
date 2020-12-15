package com.Brayan_Vargas.taller1.controller;

import com.Brayan_Vargas.taller1.delegate.HatParameterDelegate;
import com.Brayan_Vargas.taller1.delegate.InstitutionDelegate;
import com.Brayan_Vargas.taller1.model.Institutioncampus;
import com.Brayan_Vargas.taller1.model.HatParameter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/frontapi")
public class HatParameterController {

    private HatParameterDelegate hatParameterDelegate;
    private InstitutionDelegate institutionDelegate;

    public HatParameterController(HatParameterDelegate hatParameterDelegate, InstitutionDelegate institutionDelegate) {
        this.hatParameterDelegate = hatParameterDelegate;
        this.institutionDelegate = institutionDelegate;
    }

    @GetMapping("/HatParameter")
    public String indexHatParameter(Model model){
        model.addAttribute("hatParameters", hatParameterDelegate.GET_HatParameters());
        return "HatParameter/index";
    }

    @GetMapping("/HatParameter/add")
    public String addCampus(Model model){
        model.addAttribute("hatParameter", new HatParameter());
        model.addAttribute("institutions",institutionDelegate.GET_Institutions());
        return "HatParameter/add-hatParameter";
    }
}
