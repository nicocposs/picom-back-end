package project.picom.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import project.picom.business.Tarif;

public interface TarifDao extends JpaRepository<Tarif, Long>{
    
}
