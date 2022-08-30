package project.picom.service;

import java.util.List;

import project.picom.business.TrancheHoraire;

public interface TrancheHoraireService {

    void addTrancheHoraire(TrancheHoraire th);

    List<TrancheHoraire> recupererTranches();

    TrancheHoraire recupererTranche(Long l);
    
}
