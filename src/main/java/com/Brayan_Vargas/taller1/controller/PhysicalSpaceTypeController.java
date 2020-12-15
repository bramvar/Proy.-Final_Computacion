package com.Brayan_Vargas.taller1.controller;


import com.Brayan_Vargas.taller1.delegate.InstitutionDelegate;
import com.Brayan_Vargas.taller1.delegate.PhysicalSpaceTypeDelegate;
import com.Brayan_Vargas.taller1.model.Institution;
import com.Brayan_Vargas.taller1.model.Physicalspacetype;
import com.Brayan_Vargas.taller1.service.InstitutionService;
import com.Brayan_Vargas.taller1.service.PhysicalspaceTypeService;
import com.Brayan_Vargas.taller1.validation.newPhysicalSpaceType;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;


@Controller
public class PhysicalSpaceTypeController {

    //PhysicalspaceTypeService physicalspaceTypeService;
    //InstitutionService institutionService;
    PhysicalSpaceTypeDelegate typeDelegate;
    InstitutionDelegate institutionDelegate;


    @Autowired
    public PhysicalSpaceTypeController(PhysicalSpaceTypeDelegate typeDelegate,InstitutionDelegate institutionDelegate) {
        this.typeDelegate = typeDelegate;
        this.institutionDelegate=institutionDelegate;
    }

    @GetMapping("/PhysicalSpaceType/")
    public String indexPhysicalSpaceType(Model model){
        model.addAttribute("physicalSpaceTypes", typeDelegate.GET_Types());
        return "PhysicalSpaceType/index";
    }

    @GetMapping("/PhysicalSpaceType/add")
    public String addPhysicalSpaceType(Model model){
        model.addAttribute("physicalspacetype", new Physicalspacetype());
        model.addAttribute("institutions",institutionDelegate.GET_Institutions());
        return "PhysicalSpaceType/add-physicalSpaceType";
    }

    @PostMapping("/PhysicalSpaceType/add")
    public String savePhysicalSpaceType(@Validated(newPhysicalSpaceType.class) Physicalspacetype physicalspacetype, BindingResult bindingResult,
                                        @RequestParam(value = "action", required = true) String action, Model model) {

        if(action.equals("Cancel"))
             return "redirect:/PhysicalSpaceType/";

        if (bindingResult.hasErrors()) {

            model.addAttribute("physpctypeName", physicalspacetype.getPhyspctypeName());
            model.addAttribute("physpctypeImpliescomm", physicalspacetype.getPhyspctypeImpliescomm());
            model.addAttribute("institutions", institutionDelegate.GET_Institutions());

            return "PhysicalSpaceType/add-physicalSpaceType";
        }
        else if (!action.equals("Cancel")) {
            typeDelegate.POST_Type(physicalspacetype);
        }

        return "redirect:/PhysicalSpaceType/";
    }

    @GetMapping("/PhysicalSpaceType/edit/{id}")
    public String showUpdatePhysicalSpaceType(@PathVariable("id") long id, Model model) {
        Physicalspacetype physicalspacetype = typeDelegate.GET_Type(id);

        if (physicalspacetype == null)
            throw new IllegalArgumentException("Invalid user Id:" + id);

        model.addAttribute("physicalspacetype", physicalspacetype);
        model.addAttribute("institutions",institutionDelegate.GET_Institutions());

        return "PhysicalSpaceType/update-physicalSpaceType";
    }


    @PostMapping("/PhysicalSpaceType/edit/{id}")
    public String updatePhysicalSpaceType(@PathVariable("id") long id,
                                    @RequestParam(value = "action", required = true) String action, @Valid Physicalspacetype physicalspacetype,
                                    BindingResult bindingResult, Model model) {

        if (action.equals("Cancel"))
            return "redirect:/PhysicalSpaceType/";


        if (bindingResult.hasErrors()) {

            model.addAttribute("physpctypeName", physicalspacetype.getPhyspctypeName());
            model.addAttribute("physpctypeImpliescomm", physicalspacetype.getPhyspctypeImpliescomm());
            model.addAttribute("institutions", institutionDelegate.GET_Institutions());

            return "PhysicalSpaceType/update-physicalSpaceType";
        }

        if (action != null && !action.equals("Cancel")) {
            typeDelegate.PUT_Type(physicalspacetype);
        }

        return "redirect:/PhysicalSpaceType/";
    }


    @GetMapping("/PhysicalSpaceType/consult")
    public String consultPhysicalSpaceType(Model model) {

        model.addAttribute("physicalspacetype", new Physicalspacetype());
        return "PhysicalSpaceType/consult-physicalSpaceType";
    }

    @PostMapping("/PhysicalSpaceType/consult")
    public String showConsultPhysicalSpaceType(@ModelAttribute Physicalspacetype physicalspacetype, Model model) throws NotFoundException {

        Physicalspacetype physpctype = typeDelegate.GET_Type(physicalspacetype.getPhyspctypeId());
        if (physpctype == null) {
            throw new NotFoundException(" NO ENCONTRADO");
        }

        model.addAttribute("physicalspacetype",physpctype);

        return "PhysicalSpaceType/update-physicalSpaceType";
    }
}
