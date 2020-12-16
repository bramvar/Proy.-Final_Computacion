package com.Brayan_Vargas.taller1.rest;

import com.Brayan_Vargas.taller1.model.HatCapacitydetail;
import com.Brayan_Vargas.taller1.model.HatParameter;
import com.Brayan_Vargas.taller1.service.HatCapacityService;
import com.Brayan_Vargas.taller1.service.HatParameterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/backapi")
public class HatCapacityRest {

    private HatCapacityService hatCapacityService;

    public HatCapacityRest(HatCapacityService hatCapacityService) {
        this.hatCapacityService = hatCapacityService;
    }

    @GetMapping("/hatCapacitydetail")
    public Iterable<HatCapacitydetail> loadHatParameters(){
        return hatCapacityService.findAll();
    }

    @GetMapping("/hatCapacitydetail/{id}")
    public HatCapacitydetail findById(@PathVariable("id") long id){
        return hatCapacityService.getHatCapacitydetail(id);
    }

    @PostMapping("/hatCapacitydetail")
    public ResponseEntity saveHatCapacity(@RequestBody HatCapacitydetail hatCapacitydetail){
        return ResponseEntity.ok(hatCapacityService.saveHatCapacitydetail(hatCapacitydetail));
    }

    @PutMapping("/hatCapacitydetail")
    public ResponseEntity updateHatCapacity(@RequestBody HatCapacitydetail hatCapacitydetail){
        return ResponseEntity.ok(hatCapacityService.editHatCapacitydetail(hatCapacitydetail));
    }

    @DeleteMapping("/hatCapacitydetail")
    public void deleteHatCapacity(@RequestBody HatCapacitydetail hatCapacitydetail){
         hatCapacityService.delete(hatCapacitydetail);
    }

}
