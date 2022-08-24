package project.picom.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import project.picom.service.ArretService;

@RestController
@AllArgsConstructor
@RequestMapping("/api/arret")
@Validated
@CrossOrigin(origins = "http://localhost:4200/", maxAge = 3600)
public class ArretRestController {
    private final ArretService arretService;
}
