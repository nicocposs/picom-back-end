package project.picom.service.impl;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import project.picom.business.Administrateur;
import project.picom.business.Client;
import project.picom.dao.AdministrateurDao;
import project.picom.dao.ClientDao;
//import project.picom.dao.UtilisateurDao;
import project.picom.service.UtilisateurService;

@Service
@AllArgsConstructor
public class UtilisateurServiceImpl implements UtilisateurService{

    private final AdministrateurDao administrateurDao;
    //private final UtilisateurDao utilisateurDao;
    private final ClientDao clientDao;

    @Override
    public void addClient(Client c) {
        clientDao.save(c);
    }

    @Override
    public void addAdministrateur(Administrateur a) {
        administrateurDao.save(a);
        
    }
    
}
