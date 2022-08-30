package project.picom.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import project.picom.business.Administrateur;
import project.picom.business.Client;
import project.picom.business.Utilisateur;
import project.picom.dao.AdministrateurDao;
import project.picom.dao.ClientDao;
import project.picom.dao.UtilisateurDao;
import project.picom.service.UtilisateurService;

@Service
@AllArgsConstructor
public class UtilisateurServiceImpl implements UtilisateurService{

    private final AdministrateurDao administrateurDao;
    private final UtilisateurDao utilisateurDao;
    private final ClientDao clientDao;

    @Override
    public void addClient(Client c) {
        clientDao.save(c);
    }

    @Override
    public void addAdministrateur(Administrateur a) {
        administrateurDao.save(a);
        
    }

    @Override
    public List<Utilisateur> getUtilisateurs() {
        return utilisateurDao.findAll();
    }

    @Override
    public Utilisateur getUtilisateur(String email, String motDePasse) {
        return utilisateurDao.findByEmailAndMotDePasse(email,motDePasse);
    }

    @Override
    public Client getClient(Long id) {
        Optional<Client> c = clientDao.findById(id);
        if(c.isPresent()){
            return c.get();
        }else{
            return null;
        }
    }
}
