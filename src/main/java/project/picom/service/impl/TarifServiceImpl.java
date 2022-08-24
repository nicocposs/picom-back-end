package project.picom.service.impl;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import project.picom.dao.TarifDao;
import project.picom.service.TarifService;

@Service
@AllArgsConstructor
public class TarifServiceImpl implements TarifService {
    
    private final TarifDao tarifDao;
}
