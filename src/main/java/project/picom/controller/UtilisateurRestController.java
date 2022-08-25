package project.picom.controller;

import java.util.List;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import project.picom.business.Utilisateur;
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
	public Utilisateur utilisateurGet(@PathVariable String email, @PathVariable String motDePasse) {
		return utilisateurService.getUtilisateur(email,motDePasse);
	}
}
