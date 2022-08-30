package project.picom.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import project.picom.business.Tarif;
import project.picom.dao.TarifDao;
import project.picom.service.TarifService;

@Service
@AllArgsConstructor
public class TarifServiceImpl implements TarifService {
    
    private final TarifDao tarifDao;

    @Override
    public List<Tarif> recupererTarifs() {
        // TODO Auto-generated method stub
        return tarifDao.findAll();
    }
}
