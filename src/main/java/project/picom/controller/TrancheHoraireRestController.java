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
import project.picom.business.TrancheHoraire;
import project.picom.service.TrancheHoraireService;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
@Validated
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class TrancheHoraireRestController {

    private final TrancheHoraireService trancheHoraireService;

    @GetMapping("/tranchehoraires")
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<List<TrancheHoraire>> getTranchesHoraires(){
        List<TrancheHoraire> tranches = trancheHoraireService.recupererTranches();

        if(tranches.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(tranches);
    }
    
}
