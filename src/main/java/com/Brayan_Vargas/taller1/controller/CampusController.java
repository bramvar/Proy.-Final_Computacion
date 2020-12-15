package com.Brayan_Vargas.taller1.controller;

import com.Brayan_Vargas.taller1.delegate.CampusDelegate;
import com.Brayan_Vargas.taller1.delegate.InstitutionDelegate;
import com.Brayan_Vargas.taller1.delegate.PhysicalSpaceDelegate;
import com.Brayan_Vargas.taller1.model.Institution;
import com.Brayan_Vargas.taller1.model.Institutioncampus;
import com.Brayan_Vargas.taller1.model.Physicalspace;
import com.Brayan_Vargas.taller1.model.Physicalspacetype;
import com.Brayan_Vargas.taller1.service.CampusService;
import com.Brayan_Vargas.taller1.service.InstitutionService;
import com.Brayan_Vargas.taller1.validation.newCampus;
import javassist.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/frontapi")
public class CampusController {

    //CampusService campusService;
    //InstitutionService institutionService;

    private CampusDelegate campusDelegate;
    private InstitutionDelegate institutionDelegate;
    private PhysicalSpaceDelegate spaceDelegate;

    public CampusController(CampusDelegate campusDelegate, InstitutionDelegate institutionDelegate,PhysicalSpaceDelegate spaceDelegate) {
        this.campusDelegate = campusDelegate;
        this.institutionDelegate = institutionDelegate;
        this.spaceDelegate=spaceDelegate;
    }

    @GetMapping("/Campus/")
    public String indexCampus(Model model){
        model.addAttribute("campuses", campusDelegate.GET_Campuses());
        return "Campus/index";
    }

    @GetMapping("/Campus/add")
    public String addCampus(Model model){
        model.addAttribute("institutioncampus", new Institutioncampus());
        model.addAttribute("institutions",institutionDelegate.GET_Institutions());
        return "Campus/add-campus";
    }

    @PostMapping("/Campus/add")
    public String saveCampus(@Validated(newCampus.class) Institutioncampus institutioncampus, BindingResult bindingResult,
                             @RequestParam(value = "action", required = true) String action, Model model) {

        if(action.equals("Cancel"))
            return "redirect:/frontapi/Campus/";

        if (bindingResult.hasErrors()) {

            model.addAttribute("instcamName", institutioncampus.getInstcamName());
            model.addAttribute("instcamOccupation", institutioncampus.getInstcamOccupation());
            model.addAttribute("institutions", institutionDelegate.GET_Institutions());

            return "Campus/add-campus";
        }

        else if (!action.equals("Cancel")) {
            campusDelegate.POST_Campus(institutioncampus);
        }

        return "redirect:/frontapi/Campus/";
    }

        @GetMapping("/Campus/edit/{id}")
        public String showUpdateCampus(@PathVariable("id") long id, Model model) {
            Institutioncampus institutioncampus = campusDelegate.GET_Campus(id);

            if (institutioncampus  == null)
                throw new IllegalArgumentException("Invalid user Id:" + id);

            model.addAttribute("institutioncampus", institutioncampus);
            model.addAttribute("institutions",institutionDelegate.GET_Institutions());

            return "Campus/update-campus";
        }

    @PostMapping("/Campus/edit/{id}")
    public String updateCampus(@PathVariable("id") long id,
                                          @RequestParam(value = "action", required = true) String action, @Validated(newCampus.class) Institutioncampus institutioncampus,
                                          BindingResult bindingResult, Model model) {

        if (action.equals("Cancel"))
            return "redirect:/frontapi/Campus/";


        if (bindingResult.hasErrors()) {
/*
            model.addAttribute("instcamName", institutioncampus.getInstcamName());
            model.addAttribute("instcamOccupation", institutioncampus.getInstcamOccupation());
            model.addAttribute("institutions", institutionDelegate.GET_Institutions());*/

            return "Campus/update-campus";
        }

        if (action != null && !action.equals("Cancel")) {
            institutioncampus.setInstcamId(id);
            System.out.println("yesss");
            campusDelegate.PUT_Campus(institutioncampus);
        }

        return "redirect:/frontapi/Campus/";
    }

    @GetMapping("/Campus/consult")
    public String consultCampus(Model model) {

        model.addAttribute("institutioncampus", new Institutioncampus());
        return "Campus/consult-campus";
    }

    @PostMapping("/Campus/consult")
    public String showConsultCampus(@ModelAttribute Institution institution, Model model) throws NotFoundException {

        Institution inst = institutionDelegate.GET_Institution(institution.getInstId());
        if (inst == null) {
            throw new NotFoundException("USU NO ENCONTRADO");
        }

        model.addAttribute("institution", inst);

        return "Institution/update-institution";
    }

    @GetMapping("/Campus/del/{id}")
    public String deleteCampus(@PathVariable("id") long id) {
        Institutioncampus campus = campusDelegate.GET_Campus(id);

        Iterable<Physicalspace> spaces =spaceDelegate.GET_Spaces();

        for (Physicalspace physicalspace : spaces) {
            if (physicalspace.getInstitutioncampus().getInstcamId()==id) {
                spaceDelegate.DELETE_Space(physicalspace);
            }
        }



        campus.setInstitution(null);
        campusDelegate.DELETE_Campus(campus);
        return "redirect:/frontapi/Campus/";
    }

}

