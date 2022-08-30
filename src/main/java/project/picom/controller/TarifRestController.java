package project.picom.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import project.picom.business.Tarif;
import project.picom.service.TarifService;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
@Validated
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class TarifRestController {

    private final TarifService tarifService;

    @GetMapping("/tarifs")
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<List<Tarif>> getTarifs(){
        List<Tarif> tarifs = tarifService.recupererTarifs();

        if(tarifs.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(tarifs);
    }
    
}
