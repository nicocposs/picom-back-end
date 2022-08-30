package project.picom.service;

import java.util.List;

import project.picom.business.Zone;

public interface ZoneService {

    void addZone(Zone z);

    Zone getZone(int i);

    List<Zone> recupererZones();

    Zone recupererZone(Long l);
    
}
