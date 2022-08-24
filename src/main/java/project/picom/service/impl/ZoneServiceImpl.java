package project.picom.service.impl;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import project.picom.dao.ZoneDao;
import project.picom.service.ZoneService;

@Service
@AllArgsConstructor
public class ZoneServiceImpl implements ZoneService{
    
    private final ZoneDao zoneDao;
}
