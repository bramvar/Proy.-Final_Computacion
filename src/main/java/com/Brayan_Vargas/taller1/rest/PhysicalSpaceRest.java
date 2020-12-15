package com.Brayan_Vargas.taller1.rest;

import com.Brayan_Vargas.taller1.model.Institution;
import com.Brayan_Vargas.taller1.model.Physicalspace;
import com.Brayan_Vargas.taller1.service.InstitutionService;
import com.Brayan_Vargas.taller1.service.PhysicalspaceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/backapi")
public class PhysicalSpaceRest {

    private PhysicalspaceService spaceService;

    public PhysicalSpaceRest(PhysicalspaceService spaceService) {
        this.spaceService = spaceService;
    }

    @GetMapping("/physicalspace")
    public Iterable<Physicalspace> loadSpaces(){
        return spaceService.findAll();
    }

    @PostMapping("/physicalspace")
    public ResponseEntity saveSpace(@RequestBody Physicalspace space){
        return ResponseEntity.ok(spaceService.savePhysicalspace(space));
    }

    @GetMapping("/physicalspace/{id}")
    public Physicalspace findById(@PathVariable("id") long id ){
        return spaceService.findById(id);
    }

    @PutMapping("/physicalspace")
    public ResponseEntity updateSpace(@RequestBody Physicalspace space){
        return ResponseEntity.ok(spaceService.editPhysicalspace(space));
    }


}
