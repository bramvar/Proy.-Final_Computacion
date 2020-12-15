package com.Brayan_Vargas.taller1.controller;

import com.Brayan_Vargas.taller1.delegate.CampusDelegate;
import com.Brayan_Vargas.taller1.delegate.PhysicalSpaceDelegate;
import com.Brayan_Vargas.taller1.delegate.PhysicalSpaceTypeDelegate;
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
@RequestMapping("/frontapi")
public class PhysicalSpaceController {

    //PhysicalspaceService physicalspaceService;
    //CampusService campusService;
    //PhysicalspaceTypeService physicalspaceTypeService;

    PhysicalSpaceDelegate spaceDelegate;
    CampusDelegate campusDelegate;
    PhysicalSpaceTypeDelegate typeDelegate;


    @Autowired
    public PhysicalSpaceController(PhysicalSpaceDelegate spaceDelegate, CampusDelegate campusDelegate, PhysicalSpaceTypeDelegate typeDelegate) {
        this.spaceDelegate = spaceDelegate;
        this.campusDelegate = campusDelegate;
        this.typeDelegate = typeDelegate;
    }

    @GetMapping("/PhysicalSpace/")
    public String indexPhysicalSpace(Model model){
        model.addAttribute("physicalSpaces", spaceDelegate.GET_Spaces());
        return "PhysicalSpace/index";
    }

    @GetMapping("/PhysicalSpace/add")
    public String addPhysicalSpace(Model model){
        model.addAttribute("physicalspace", new Physicalspace());
        model.addAttribute("physicalSpaceTypes", typeDelegate.GET_Types());
        model.addAttribute("campuses", campusDelegate.GET_Campuses());
        return "PhysicalSpace/add-physicalSpace";
    }

    @PostMapping("/PhysicalSpace/add")
    public String savePhysicalSpace(@Validated(newPhysicalSpace.class) Physicalspace physicalspace, BindingResult bindingResult,
                                    @RequestParam(value = "action", required = true) String action, Model model) {

        if(action.equals("Cancel"))
            return "redirect:/frontapi/PhysicalSpace/";

        if (bindingResult.hasErrors()) {

            model.addAttribute("physpcName", physicalspace.getPhyspcName());
            model.addAttribute("PhyspcExtid", physicalspace.getPhyspcExtid());
            model.addAttribute("campuses", campusDelegate.GET_Campuses());
            model.addAttribute("physicalSpaceTypes", typeDelegate.GET_Types());

            return "PhysicalSpace/add-physicalSpace";
        }

        else if (!action.equals("Cancel")) {
            spaceDelegate.POST_Space(physicalspace);
        }

        return "redirect:/frontapi/PhysicalSpace/";
    }

    @GetMapping("/PhysicalSpace/edit/{id}")
    public String showUpdatePhysicalSpace(@PathVariable("id") long id, Model model) {
        Physicalspace physicalspace = spaceDelegate.GET_Space(id);

        if (physicalspace == null)
            throw new IllegalArgumentException("Invalid user Id:" + id);

        model.addAttribute("physicalspace", physicalspace);
        model.addAttribute("physicalSpaceTypes", typeDelegate.GET_Types());
        model.addAttribute("campuses", campusDelegate.GET_Campuses());

        return "PhysicalSpace/update-physicalSpace";
    }

    @PostMapping("/PhysicalSpace/edit/{id}")
    public String updatePhysicalSpaceType(@PathVariable("id") long id,
                                          @RequestParam(value = "action", required = true) String action,@Validated(newPhysicalSpace.class)  Physicalspace physicalspace,
                                          BindingResult bindingResult, Model model) {

        if (action.equals("Cancel"))
            return "redirect:/frontapi/PhysicalSpace/";


        if (bindingResult.hasErrors()) {

            model.addAttribute("physpcName", physicalspace.getPhyspcName());
            model.addAttribute("PhyspcExtid", physicalspace.getPhyspcExtid());
            model.addAttribute("campuses", campusDelegate.GET_Campuses());
            model.addAttribute("physicalSpaceTypes", typeDelegate.GET_Types());

            return "PhysicalSpace/update-physicalSpace";
        }

        if (action != null && !action.equals("Cancel")) {
            spaceDelegate.PUT_Space(physicalspace);
        }
        return "redirect:/frontapi/PhysicalSpaceType/";
    }

    @GetMapping("/PhysicalSpace/consult")
    public String consultPhysicalSpace(Model model) {

        model.addAttribute("physicalspace", new Physicalspace());
        return "PhysicalSpace/consult-physicalSpace";
    }

    @PostMapping("/PhysicalSpace/consult")
    public String showConsultPhysicalSpace(@ModelAttribute Physicalspace physicalspace, Model model) throws NotFoundException {

        Physicalspace physpc = spaceDelegate.GET_Space(physicalspace.getPhyspcId());
        if (physpc == null) {
            throw new NotFoundException(" NO ENCONTRADO");
        }

        model.addAttribute("physicalspace",physpc);

        return "PhysicalSpace/update-physicalSpace";
    }
}
