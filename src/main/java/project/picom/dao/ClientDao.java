package project.picom.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import project.picom.business.Client;

public interface ClientDao extends JpaRepository<Client,Long>{
    
}
