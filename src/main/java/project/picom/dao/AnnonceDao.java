package project.picom.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import project.picom.business.Annonce;

public interface AnnonceDao extends JpaRepository<Annonce,Long>{
    
}
