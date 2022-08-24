package project.picom.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import project.picom.business.Zone;

public interface ZoneDao extends JpaRepository<Zone,Long> {
    
}
