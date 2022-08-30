package project.picom.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import project.picom.business.Zone;
import project.picom.dao.ZoneDao;
import project.picom.service.ZoneService;

@Service
@AllArgsConstructor
public class ZoneServiceImpl implements ZoneService{
    
    private final ZoneDao zoneDao;

    @Override
    public void addZone(Zone z) {
        zoneDao.save(z);
        
    }

    @Override
    public Zone getZone(int i) {
        Long id = Long.valueOf(i);
        Optional<Zone> z = zoneDao.findById(id);
        if(z.isPresent()){
            return z.get();
        }else{
            return null;
        }
        
    }

    @Override
    public List<Zone> recupererZones() {
        return zoneDao.findAll();
    }

    @Override
    public Zone recupererZone(Long l) {
        Optional<Zone> z = zoneDao.findById(l);
        if(z.isPresent()) {
            return z.get();
        }
        return null;
    }
}
