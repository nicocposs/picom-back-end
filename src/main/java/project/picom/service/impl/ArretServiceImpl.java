package project.picom.service.impl;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import project.picom.dao.ArretDao;
import project.picom.service.ArretService;

@Service
@AllArgsConstructor
public class ArretServiceImpl implements ArretService{
    
    private final ArretDao arretDao;
}
