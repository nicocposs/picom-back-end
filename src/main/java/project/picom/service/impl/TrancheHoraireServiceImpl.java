package project.picom.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import project.picom.business.TrancheHoraire;
import project.picom.dao.TrancheHoraireDao;
import project.picom.service.TrancheHoraireService;

@Service
@AllArgsConstructor
public class TrancheHoraireServiceImpl implements TrancheHoraireService {

    private final TrancheHoraireDao trancheHoraireDao;

    @Override
    public void addTrancheHoraire(TrancheHoraire th) {
        trancheHoraireDao.save(th);
    }

    @Override
    public List<TrancheHoraire> recupererTranches() {
        return trancheHoraireDao.findAll();
    }

    @Override
    public TrancheHoraire recupererTranche(Long l) {
        Optional<TrancheHoraire> th = trancheHoraireDao.findById(l);
        if(th.isPresent()) {
            return th.get();
        }
        return null;
    }
    
    
}
