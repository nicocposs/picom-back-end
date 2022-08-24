package project.picom.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import project.picom.business.TrancheHoraire;

public interface TrancheHoraireDao extends JpaRepository<TrancheHoraire, Long>{
    
}
