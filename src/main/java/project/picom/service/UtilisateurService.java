package project.picom.service;

import java.util.List;

import project.picom.business.Administrateur;
import project.picom.business.Client;
import project.picom.business.Utilisateur;

public interface UtilisateurService {

    void addClient(Client c);

    void addAdministrateur(Administrateur a);

    List<Utilisateur> getUtilisateurs();
    
}
