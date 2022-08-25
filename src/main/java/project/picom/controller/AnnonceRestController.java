package project.picom.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import project.picom.business.Annonce;
import project.picom.service.AnnonceService;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
@Validated
@CrossOrigin(origins = "http://localhost:4200/", maxAge = 3600)
public class AnnonceRestController {
    
    private final AnnonceService annonceService;

    @GetMapping("/annonce/{id}")
    public ResponseEntity<List<Annonce>> getAnnonceByClient(@PathVariable Long id){
        List<Annonce> annonces = annonceService.getAnnonceByClient(id);

        if(annonces.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(annonces);
    }
}
