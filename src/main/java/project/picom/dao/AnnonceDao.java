package project.picom.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import project.picom.business.Annonce;

public interface AnnonceDao extends JpaRepository<Annonce,Long>{

    List<Annonce> findAllByClientId(Long id);
    
}
