package project.picom.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.classic.pattern.Util;
import lombok.AllArgsConstructor;
import project.picom.business.Client;
import project.picom.business.Utilisateur;
import project.picom.dto.ClientDto;
import project.picom.service.UtilisateurService;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
@Validated
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class UtilisateurRestController {
    
    private final UtilisateurService utilisateurService;

    @GetMapping("utilisateurs")
	public List<Utilisateur> utilisateurGet() {
		return utilisateurService.getUtilisateurs();
	}

    @GetMapping("utilisateurs/{email}/{motDePasse}")
	public ResponseEntity<Utilisateur> utilisateurGet(@PathVariable String email, @PathVariable String motDePasse) {
		Utilisateur u = utilisateurService.getUtilisateur(email, motDePasse);

        if(u == null) {
            return ResponseEntity.badRequest().body(null);
        }

        return ResponseEntity.ok(u);
	}

	@PostMapping("utilisateur")
	@ResponseStatus(value = HttpStatus.CREATED)
	public Client utilisateurPost(@RequestBody ClientDto client) {
		Client c = new Client(client.getNom(), client.getPrenom(), client.getEmail(), client.getMotDePasse(), client.getNumeroDeTelephone());	
		utilisateurService.addClient(c);
		System.out.println(c);
		System.out.println(client);
		return c;
	}

}
