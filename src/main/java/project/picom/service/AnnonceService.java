package project.picom.service;

import java.util.List;

import project.picom.business.Annonce;

public interface AnnonceService {

    List<Annonce> getAnnonceByClient(Long id);

    void addAnnonce(Annonce a);
    
}
