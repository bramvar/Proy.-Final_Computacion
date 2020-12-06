package com.Brayan_Vargas.taller1.controller;

import com.Brayan_Vargas.taller1.model.Institution;
import com.Brayan_Vargas.taller1.model.Institutioncampus;
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
public class CampusController {

    CampusService campusService;
    InstitutionService institutionService;

    public CampusController(CampusService campusService, InstitutionService institutionService) {
        this.campusService = campusService;
        this.institutionService = institutionService;
    }

    @GetMapping("/Campus/")
    public String indexCampus(Model model){
        model.addAttribute("campuses", campusService.findAll());
        return "Campus/index";
    }

    @GetMapping("/Campus/add")
    public String addCampus(Model model){
        model.addAttribute("institutioncampus", new Institutioncampus());
        model.addAttribute("institutions",institutionService.findAll());
        return "Campus/add-campus";
    }

    @PostMapping("/Campus/add")
    public String saveCampus(@Validated(newCampus.class) Institutioncampus institutioncampus, BindingResult bindingResult,
                             @RequestParam(value = "action", required = true) String action, Model model) {

        if(action.equals("Cancel"))
            return "redirect:/Campus/";

        if (bindingResult.hasErrors()) {

            model.addAttribute("instcamName", institutioncampus.getInstcamName());
            model.addAttribute("instcamOccupation", institutioncampus.getInstcamOccupation());
            model.addAttribute("institutions", institutionService.findAll());

            return "Campus/add-campus";
        }

        else if (!action.equals("Cancel")) {
            campusService.saveCampus(institutioncampus);
        }

        return "redirect:/Campus/";
    }

        @GetMapping("/Campus/edit/{id}")
        public String showUpdateCampus(@PathVariable("id") long id, Model model) {
            Institutioncampus institutioncampus = campusService.findById(id);

            if (institutioncampus  == null)
                throw new IllegalArgumentException("Invalid user Id:" + id);

            model.addAttribute("institutioncampus", institutioncampus);
            model.addAttribute("institutions",institutionService.findAll());

            return "Campus/update-campus";
        }

    @PostMapping("/Campus/edit/{id}")
    public String updatePhysicalSpaceType(@PathVariable("id") long id,
                                          @RequestParam(value = "action", required = true) String action, @Validated(newCampus.class) Institutioncampus institutioncampus,
                                          BindingResult bindingResult, Model model) {

        if (action.equals("Cancel"))
            return "redirect:/Campus/";


        if (bindingResult.hasErrors()) {

            model.addAttribute("instcamName", institutioncampus.getInstcamName());
            model.addAttribute("instcamOccupation", institutioncampus.getInstcamOccupation());
            model.addAttribute("institutions", institutionService.findAll());

            return "Campus/update-campus";
        }

        if (action != null && !action.equals("Cancel")) {
            campusService.editCampus(institutioncampus);
        }

        return "redirect:/Campus/";
    }

    @GetMapping("/Campus/consult")
    public String consultPhysicalSpaceType(Model model) {

        model.addAttribute("institutioncampus", new Institutioncampus());
        return "Campus/consult-campus";
    }

    @PostMapping("/Campus/consult")
    public String showConsultInstitution(@ModelAttribute Institution institution, Model model) throws NotFoundException {

        Institution inst = institutionService.getInstitution(institution.getInstId());
        if (inst == null) {
            throw new NotFoundException("USU NO ENCONTRADO");
        }

        model.addAttribute("institution", inst);

        return "Institution/update-institution";
    }

}

