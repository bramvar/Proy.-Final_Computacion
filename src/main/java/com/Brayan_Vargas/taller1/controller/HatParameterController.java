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
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/HatParameter/edit/{id}")
    public String showUpdateHatParameter(@PathVariable("id") long id, Model model) {
        HatParameter hatParameter = hatParameterDelegate.GET_HatParameter(id);

        if (hatParameter == null)
            throw new IllegalArgumentException("Invalid user Id:" + id);

        model.addAttribute("hatParameter", hatParameter);
        model.addAttribute("institutions",institutionDelegate.GET_Institutions());

        return "HatParameter/update-hatParameter";
    }

    @PostMapping("/HatParameter/edit/{id}")
    public String updateHatParameter(@PathVariable("id") long id,
                                    @RequestParam(value = "action", required = true) String action, @Validated HatParameter hatParameter,
                                    BindingResult bindingResult, Model model) {

        if (action.equals("Cancel")) {
            return "redirect:/frontapi/HatParameter";
        }

        if (bindingResult.hasErrors()) {
            return "HatParameter/update-hatParameter";
        }

        if (action != null && !action.equals("Cancel")) {
            hatParameter.setParamId(id);
            hatParameterDelegate.PUT_HatParameter(hatParameter);
        }

        return "redirect:/frontapi/HatParameter";
    }
}
