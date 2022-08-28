package project.picom.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

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

	@PostMapping("utilisateurs")
	@ResponseStatus(value = HttpStatus.CREATED)
	public ResponseEntity<Client> utilisateurPost(@RequestBody ClientDto client) {
		Client c = new Client(client.getNom(), client.getPrenom(), client.getEmail(), client.getMotDePasse(), client.getNumeroDeTelephone());	
		utilisateurService.addClient(c);
		System.out.println(client);
		return new ResponseEntity<>(c, HttpStatus.CREATED);
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
