package com.Brayan_Vargas.taller1.controller;

import com.Brayan_Vargas.taller1.delegate.HatParameterDelegate;
import com.Brayan_Vargas.taller1.delegate.InstitutionDelegate;
import com.Brayan_Vargas.taller1.model.Institution;
import com.Brayan_Vargas.taller1.model.HatParameter;
import com.Brayan_Vargas.taller1.validation.newInstitution;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String addHatParameter(Model model){
        model.addAttribute("hatParameter", new HatParameter());
        model.addAttribute("institutions",institutionDelegate.GET_Institutions());
        return "HatParameter/add-hatParameter";
    }

    @PostMapping("/HatParameter/add")
    public String saveHatParameter(@Validated HatParameter hatParameter, BindingResult bindingResult,
                                  @RequestParam(value = "action", required = true) String action, Model model) {

        if(action.equals("Cancel"))
            return "redirect:/frontapi/HatParameter";

        if (bindingResult.hasErrors()) {

            return "HatParameter/add-hatParameter";
        }

        else if (!action.equals("Cancel")) {
            //institutionService.saveInstitution(institution);
            hatParameterDelegate.POST_HatParameter(hatParameter);
        }

        return "redirect:/frontapi/HatParameter";
    }
}
