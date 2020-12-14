package com.Brayan_Vargas.taller1.rest;

import com.Brayan_Vargas.taller1.model.Institution;
import com.Brayan_Vargas.taller1.service.InstitutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
//@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RequestMapping("/backapi")
public class InstitutionRest {

    private InstitutionService institutionService;

    public InstitutionRest(InstitutionService institutionService) {
        this.institutionService = institutionService;
    }

    @GetMapping("/institution")
    public Iterable<Institution> loadInstitutions(){
        System.out.println("started");
        return institutionService.findAll();
    }

    @PostMapping("/institution")
    public ResponseEntity saveInstitution(@RequestBody Institution institution){
        return ResponseEntity.ok(institutionService.saveInstitution(institution));
    }

    @GetMapping("/institution/{id}")
    public Institution showUpdateForm(@PathVariable("id") long id ){
        return institutionService.getInstitution(id);
    }

    @PutMapping("/institution")
    public ResponseEntity updateInstitution(@RequestBody Institution institution){
        return ResponseEntity.ok(institutionService.editInstitution(institution));
    }

}
