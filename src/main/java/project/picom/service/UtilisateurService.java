package project.picom.service;

import project.picom.business.Administrateur;
import project.picom.business.Client;

public interface UtilisateurService {

    void addClient(Client c);

    void addAdministrateur(Administrateur a);
    
}
