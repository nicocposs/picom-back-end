package project.picom.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import project.picom.business.Utilisateur;

public interface UtilisateurDao extends JpaRepository<Utilisateur, Long>{
    
}
