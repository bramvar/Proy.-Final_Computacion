package com.Brayan_Vargas.taller1.controller;

import com.Brayan_Vargas.taller1.model.Institution;
import com.Brayan_Vargas.taller1.model.Physicalspace;
import com.Brayan_Vargas.taller1.model.Physicalspacetype;
import com.Brayan_Vargas.taller1.service.CampusService;
import com.Brayan_Vargas.taller1.service.InstitutionService;
import com.Brayan_Vargas.taller1.service.PhysicalspaceService;
import com.Brayan_Vargas.taller1.service.PhysicalspaceTypeService;
import com.Brayan_Vargas.taller1.validation.newPhysicalSpace;
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
public class PhysicalSpaceController {

    PhysicalspaceService physicalspaceService;
    CampusService campusService;
    PhysicalspaceTypeService physicalspaceTypeService;

    @Autowired
    public PhysicalSpaceController(PhysicalspaceService physicalspaceService, CampusService campusService, PhysicalspaceTypeService physicalspaceTypeService) {
        this.physicalspaceService = physicalspaceService;
        this.campusService = campusService;
        this.physicalspaceTypeService = physicalspaceTypeService;
    }

    @GetMapping("/PhysicalSpace/")
    public String indexPhysicalSpace(Model model){
        model.addAttribute("physicalSpaces", physicalspaceService.findAll());
        return "PhysicalSpace/index";
    }

    @GetMapping("/PhysicalSpace/add")
    public String addPhysicalSpace(Model model){
        model.addAttribute("physicalspace", new Physicalspace());
        model.addAttribute("physicalSpaceTypes", physicalspaceTypeService.findAll());
        model.addAttribute("campuses", campusService.findAll());
        return "PhysicalSpace/add-physicalSpace";
    }

    @PostMapping("/PhysicalSpace/add")
    public String savePhysicalSpace(@Validated(newPhysicalSpace.class) Physicalspace physicalspace, BindingResult bindingResult,
                                    @RequestParam(value = "action", required = true) String action, Model model) {

        if(action.equals("Cancel"))
            return "redirect:/PhysicalSpace/";

        if (bindingResult.hasErrors()) {

            model.addAttribute("physpcName", physicalspace.getPhyspcName());
            model.addAttribute("PhyspcExtid", physicalspace.getPhyspcExtid());
            model.addAttribute("campuses", campusService.findAll());
            model.addAttribute("physicalSpaceTypes", physicalspaceTypeService.findAll());

            return "PhysicalSpace/add-physicalSpace";
        }

        else if (!action.equals("Cancel")) {
            physicalspaceService.savePhysicalspace(physicalspace);
        }

        return "redirect:/PhysicalSpace/";
    }

    @GetMapping("/PhysicalSpace/edit/{id}")
    public String showUpdatePhysicalSpace(@PathVariable("id") long id, Model model) {
        Physicalspace physicalspace = physicalspaceService.findById(id);

        if (physicalspace == null)
            throw new IllegalArgumentException("Invalid user Id:" + id);

        model.addAttribute("physicalspace", physicalspace);
        model.addAttribute("physicalSpaceTypes", physicalspaceTypeService.findAll());
        model.addAttribute("campuses", campusService.findAll());

        return "PhysicalSpace/update-physicalSpace";
    }

    @PostMapping("/PhysicalSpace/edit/{id}")
    public String updatePhysicalSpaceType(@PathVariable("id") long id,
                                          @RequestParam(value = "action", required = true) String action,@Validated(newPhysicalSpace.class)  Physicalspace physicalspace,
                                          BindingResult bindingResult, Model model) {

        if (action.equals("Cancel"))
            return "redirect:/PhysicalSpace/";


        if (bindingResult.hasErrors()) {

            model.addAttribute("physpcName", physicalspace.getPhyspcName());
            model.addAttribute("PhyspcExtid", physicalspace.getPhyspcExtid());
            model.addAttribute("campuses", campusService.findAll());
            model.addAttribute("physicalSpaceTypes", physicalspaceTypeService.findAll());

            return "PhysicalSpace/update-physicalSpace";
        }

        if (action != null && !action.equals("Cancel")) {
            physicalspaceService.editPhysicalspace(physicalspace);
        }
        return "redirect:/PhysicalSpaceType/";
    }

    @GetMapping("/PhysicalSpace/consult")
    public String consultPhysicalSpace(Model model) {

        model.addAttribute("physicalspace", new Physicalspace());
        return "PhysicalSpace/consult-physicalSpace";
    }

    @PostMapping("/PhysicalSpace/consult")
    public String showConsultPhysicalSpace(@ModelAttribute Physicalspace physicalspace, Model model) throws NotFoundException {

        Physicalspace physpc = physicalspaceService.findById(physicalspace.getPhyspcId());
        if (physpc == null) {
            throw new NotFoundException(" NO ENCONTRADO");
        }

        model.addAttribute("physicalspace",physpc);

        return "PhysicalSpace/update-physicalSpace";
    }
}
