package project.picom.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import project.picom.business.Arret;

public interface ArretDao extends JpaRepository<Arret,Long>{
    
}
