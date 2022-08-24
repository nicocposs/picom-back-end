package project.picom.service.impl;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import project.picom.dao.DiffusionDao;
import project.picom.service.DiffusionService;

@Service
@AllArgsConstructor
public class DiffusionServiceImpl implements DiffusionService {
    
    private final DiffusionDao diffusionDao;
}
