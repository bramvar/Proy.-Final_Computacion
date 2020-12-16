package com.Brayan_Vargas.taller1.rest;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.Brayan_Vargas.taller1.model.Physicalspace;
import com.Brayan_Vargas.taller1.model.Physicalspacetype;
import com.Brayan_Vargas.taller1.service.PhysicalspaceService;
import com.Brayan_Vargas.taller1.service.PhysicalspaceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/backapi")
public class PhysicalSpaceTypeRest {

    private PhysicalspaceTypeService typeService;

    @Autowired
    public PhysicalSpaceTypeRest(PhysicalspaceTypeService typeService) {
        this.typeService = typeService;
    }

    @GetMapping("/physicalspacetype")
    public Iterable<Physicalspacetype> loadSpaces(){
        return typeService.findAll();
    }

    @PostMapping("/physicalspacetype")
    public ResponseEntity saveSpace(@RequestBody Physicalspacetype space){
        return ResponseEntity.ok(typeService.savePhysicalspaceTypeService(space));
    }

    @GetMapping("/physicalspacetype/{id}")
    public Physicalspacetype findById(@PathVariable("id") long id ){
        return typeService.findById(id);
    }

    @PutMapping("/physicalspacetype")
    public ResponseEntity updateSpace(@RequestBody Physicalspacetype space){
        System.out.println("rest");
        return ResponseEntity.ok(typeService.editPhysicalspaceTypeService(space));
    }

   @DeleteMapping("/physicalspacetype")
   public ResponseEntity deleteSpace(@RequestBody Physicalspacetype space){

       System.out.println("enterdelete");
       return ResponseEntity.ok(typeService.delete(space));
   }


}


