package project.picom.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import project.picom.business.Diffusion;

public interface DiffusionDao extends JpaRepository<Diffusion,Long>{
    
}
