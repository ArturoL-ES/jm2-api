package com.arturo.jm2api.build.type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {
    
    @Autowired private TypeDAO typeDAO;
    
    @Override
    @Cacheable("types")
    @Transactional(readOnly = true)
    public List<Type> findAll() {
        return typeDAO.findAll();
    }
    
}
