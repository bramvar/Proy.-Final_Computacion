package com.Brayan_Vargas.taller1.rest;

import com.Brayan_Vargas.taller1.model.Institutioncampus;
import com.Brayan_Vargas.taller1.service.CampusService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/backapi")
public class CampusRest {

    private CampusService campusService;

    public CampusRest(CampusService campusService) {
        this.campusService = campusService;
    }

    @GetMapping("/campus")
    public Iterable<Institutioncampus> loadCampuses(){
        return campusService.findAll();
    }

    @PostMapping("/campus")
    public ResponseEntity saveInstitution(@RequestBody Institutioncampus institutioncampus){
        return ResponseEntity.ok(campusService.saveCampus(institutioncampus));
    }

    @GetMapping("/campus/{id}")
    public Institutioncampus findById(@PathVariable("id") long id){
        return campusService.findById(id);
    }

    @PutMapping("/campus")
    public ResponseEntity updateCampus(@RequestBody Institutioncampus institutioncampus){
        System.out.println("yesss"+institutioncampus.getInstcamId());
        return  ResponseEntity.ok(campusService.editCampus(institutioncampus));
    }
}
