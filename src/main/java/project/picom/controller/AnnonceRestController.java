package project.picom.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import lombok.AllArgsConstructor;
import project.picom.business.Annonce;
import project.picom.business.TrancheHoraire;
import project.picom.business.Zone;
import project.picom.dto.AnnonceDto;
import project.picom.service.AnnonceService;
import project.picom.service.TrancheHoraireService;
import project.picom.service.UtilisateurService;
import project.picom.service.ZoneService;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
@Validated
@CrossOrigin(origins = "http://localhost:4200/", maxAge = 3600)
public class AnnonceRestController {
    
    private final AnnonceService annonceService;
    private final UtilisateurService utilisateurService;
    private final TrancheHoraireService trancheHoraireService;
    private final ZoneService zoneService;

    @GetMapping("/annonces/{id}")
    public ResponseEntity<List<Annonce>> getAnnonceByClient(@PathVariable Long id){
        List<Annonce> annonces = annonceService.getAnnonceByClient(id);

        if(annonces.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(annonces);
    }

    @GetMapping("/annonces/annonce/{id}")
    public ResponseEntity<Annonce> getAnnonceById(@PathVariable Long id){
        Annonce annonce = annonceService.getAnnonceById(id);

        if(annonce == null) {
            return ResponseEntity.badRequest().body(null);
        }

        return ResponseEntity.ok(annonce);
    }

    @PostMapping("/annonces")
    @ResponseStatus(value = HttpStatus.CREATED)
    public ResponseEntity<Annonce> postAnnonce(@RequestBody AnnonceDto a){
        Annonce nAnnonce = new Annonce();
        nAnnonce.setAnneeExpiration(a.getAnneeExpiration());
        nAnnonce.setClient(utilisateurService.getClient(a.getClientId()));
        nAnnonce.setContenu(a.getContenu());
        nAnnonce.setCryptogramme(a.getCryptogramme());
        nAnnonce.setDateHeureCreation(LocalDateTime.now());
        nAnnonce.setDateHeureDebut(a.getDateHeureDebut());
        nAnnonce.setDateHeureFin(a.getDateHeureFin());
        nAnnonce.setMoisExpiration(a.getMoisExpiration());
        nAnnonce.setMontantRegleEnEuros(a.getMontantRegleEnEuros());
        nAnnonce.setNumeroCarte(a.getNumeroCarte());
        nAnnonce.setTitre(a.getTitre());
        List<Zone> zonesAjout = new ArrayList<>();
        List<TrancheHoraire> trancheHorairesAjout = new ArrayList<>();
        for(Long l : a.getTrancheHorairesIds()){
            trancheHorairesAjout.add(trancheHoraireService.recupererTranche(l));
        }
        for(Long l : a.getZonesIds()){
            zonesAjout.add(zoneService.recupererZone(l));
        }
        nAnnonce.setTrancheHoraires(trancheHorairesAjout);
        nAnnonce.setZones(zonesAjout);
		annonceService.addAnnonce(nAnnonce);
		return new ResponseEntity<>(nAnnonce, HttpStatus.CREATED);
    }

    
    

    @ExceptionHandler(javax.validation.ConstraintViolationException.class)
    @ResponseStatus(code=HttpStatus.UNPROCESSABLE_ENTITY)
    public Map<String, String> traiterDonneesInvalidesAvecDetails(ConstraintViolationException exception) {
		Map<String, String> exceptionMap = new HashMap<>();
        for (ConstraintViolation<?> cv : exception.getConstraintViolations()) {
			exceptionMap.put(
				cv.getPropertyPath().toString(),
				cv.getMessage());
		}
		return exceptionMap;
    }
}
