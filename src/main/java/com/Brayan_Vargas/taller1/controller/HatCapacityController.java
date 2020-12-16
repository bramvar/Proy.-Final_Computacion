package com.Brayan_Vargas.taller1.controller;

import com.Brayan_Vargas.taller1.delegate.CampusDelegate;
import com.Brayan_Vargas.taller1.delegate.HatCapacityDelegate;
import com.Brayan_Vargas.taller1.delegate.PhysicalSpaceDelegate;
import com.Brayan_Vargas.taller1.delegate.PhysicalSpaceTypeDelegate;
import com.Brayan_Vargas.taller1.model.HatCapacitydetail;
import com.Brayan_Vargas.taller1.model.HatParameter;
import com.Brayan_Vargas.taller1.model.Physicalspace;
import com.Brayan_Vargas.taller1.validation.newPhysicalSpace;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/frontapi")
public class HatCapacityController {

    HatCapacityDelegate capacityDelegate;
    CampusDelegate campusDelegate;



    @Autowired
    public HatCapacityController(HatCapacityDelegate capacityDelegate, CampusDelegate campusDelegate) {
        this.capacityDelegate = capacityDelegate;
        this.campusDelegate = campusDelegate;

    }

    @GetMapping("/HatCapacitydetail")
    public String indexHatCapacitydetail(Model model){
        System.out.println("index");
        model.addAttribute("hatCapacitydetail", capacityDelegate.GET_HatCapacitydetails());
        return "HatCapacitydetail/index";
    }

    @GetMapping("/HatCapacitydetail/add")
    public String addHatCapacitydetail(Model model){
        model.addAttribute("hatCapacitydetail", new HatCapacitydetail());
        model.addAttribute("campus",campusDelegate.GET_Campuses());
        return "HatCapacitydetail/add-HatCapacitydetail";
    }

    @PostMapping("/HatCapacitydetail/add")
    public String saveHatCapacitydetail(@Validated HatCapacitydetail hatCapacitydetail, BindingResult bindingResult,
                                   @RequestParam(value = "action", required = true) String action, Model model) {

        if(action.equals("Cancel"))
            return "redirect:/frontapi/HatCapacitydetail";

        if (bindingResult.hasErrors()) {

            return "HatCapacitydetail/add-HatCapacitydetail";
        }

        else if (!action.equals("Cancel")) {
            //institutionService.saveInstitution(institution);
            capacityDelegate.POST_HatCapacitydetail(hatCapacitydetail);
        }

        return "redirect:/frontapi/HatCapacitydetail";
    }

    @GetMapping("/HatCapacitydetail/edit/{id}")
    public String showUpdateHatCapacitydetail(@PathVariable("id") long id, Model model) {
        HatCapacitydetail hatCapacitydetail = capacityDelegate.GET_HatCapacitydetail(id);
        System.out.println(hatCapacitydetail+"controll");
        if (hatCapacitydetail == null)
            throw new IllegalArgumentException("Invalid user Id:" + id);

        model.addAttribute("hatCapacitydetail", hatCapacitydetail);
        model.addAttribute("campus",campusDelegate.GET_Campuses());

        return "HatCapacitydetail/update-HatCapacitydetail";
    }

    @PostMapping("/HatCapacitydetail/edit/{id}")
    public String updateHatCapacitydetail(@PathVariable("id") long id,
                                     @RequestParam(value = "action", required = true) String action, @Validated HatCapacitydetail hatCapacitydetail,
                                     BindingResult bindingResult, Model model) {

        System.out.println("update1");
        if (action.equals("Cancel")) {
            return "redirect:/frontapi/HatCapacitydetail";
        }

        if (bindingResult.hasErrors()) {
            return "HatParameter/update-HatCapacitydetail";
        }

        if (action != null && !action.equals("Cancel")) {
            hatCapacitydetail.setCapId(id);
            System.out.println("update2");
            capacityDelegate.PUT_HatCapacitydetail(hatCapacitydetail);
        }

        return "redirect:/frontapi/HatCapacitydetail";
    }

}
