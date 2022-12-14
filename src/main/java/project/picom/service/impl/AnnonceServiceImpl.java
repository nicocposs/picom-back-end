package project.picom.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import project.picom.business.Annonce;
import project.picom.dao.AnnonceDao;
import project.picom.service.AnnonceService;

@Service
@AllArgsConstructor
public class AnnonceServiceImpl implements AnnonceService{
    
    private final AnnonceDao annonceDao;

    @Override
    public List<Annonce> getAnnonceByClient(Long id) {
        return annonceDao.findAllByClientId(id);
    }

    @Override
    public void addAnnonce(Annonce a) {
        annonceDao.save(a);
    }

    @Override
    public Annonce getAnnonceById(Long id) {
        Optional<Annonce> optA = annonceDao.findById(id);
        if(optA.isPresent()){
            return optA.get();
        }else{
            return null;
        }
    }
}
