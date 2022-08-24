package project.picom.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import project.picom.service.DiffusionService;

@RestController
@AllArgsConstructor
@RequestMapping("/api/diffusion")
@Validated
@CrossOrigin(origins = "http://localhost:4200/", maxAge = 3600)
public class DiffusionRestController {
    private final DiffusionService diffusionService;
}
