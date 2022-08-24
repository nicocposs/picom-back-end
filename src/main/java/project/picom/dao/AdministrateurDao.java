package project.picom.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import project.picom.business.Administrateur;

public interface AdministrateurDao extends JpaRepository<Administrateur, Long> {
    
}
