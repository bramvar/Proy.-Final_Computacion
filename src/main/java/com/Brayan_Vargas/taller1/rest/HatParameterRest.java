package com.Brayan_Vargas.taller1.rest;

import com.Brayan_Vargas.taller1.model.HatParameter;
import com.Brayan_Vargas.taller1.service.HatParameterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/backapi")
public class HatParameterRest {

    private HatParameterService hatParameterService;

    public HatParameterRest(HatParameterService hatParameterService) {
        this.hatParameterService = hatParameterService;
    }

    @GetMapping("/hatParameter")
    public Iterable<HatParameter> loadHatParameters(){
        return hatParameterService.findAll();
    }

    @GetMapping("/hatParameter/{id}")
    public HatParameter findById(@PathVariable("id") long id){
        return hatParameterService.getHatParameter(id);
    }

    @PostMapping("/hatParameter")
    public ResponseEntity saveHatParameter(@RequestBody HatParameter hatParameter){
        return ResponseEntity.ok(hatParameterService.saveHatParameter(hatParameter));
    }

    @PutMapping("/hatParameter")
    public ResponseEntity updateHatParameter(@RequestBody HatParameter hatParameter){
        return ResponseEntity.ok(hatParameterService.editHatParameter(hatParameter));
    }


}
