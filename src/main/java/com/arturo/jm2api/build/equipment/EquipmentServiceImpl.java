package com.arturo.jm2api.build.equipment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EquipmentServiceImpl implements EquipmentService {
    
    @Autowired private EquipmentDAO equipmentDAO;
    
    @Override
    @Cacheable
    @Transactional(readOnly = true)
    public List<Equipment> findAll() {
        return equipmentDAO.findAll();
    }
    
}
