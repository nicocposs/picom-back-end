package project.picom.service.impl;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import project.picom.dao.AnnonceDao;
import project.picom.service.AnnonceService;

@Service
@AllArgsConstructor
public class AnnonceServiceImpl implements AnnonceService{
    
    private final AnnonceDao annonceDao;
}
