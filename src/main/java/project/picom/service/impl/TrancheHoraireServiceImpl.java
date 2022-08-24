package project.picom.service.impl;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import project.picom.dao.TrancheHoraireDao;
import project.picom.service.TrancheHoraireService;

@Service
@AllArgsConstructor
public class TrancheHoraireServiceImpl implements TrancheHoraireService {

    private final TrancheHoraireDao trancheHoraireDao;
    
}
