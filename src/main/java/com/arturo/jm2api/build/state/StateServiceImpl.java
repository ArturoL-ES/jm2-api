package com.arturo.jm2api.build.state;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StateServiceImpl implements StateService {
    
    @Autowired private StateDAO stateDAO;
    
    @Override
    @Cacheable("states")
    @Transactional(readOnly = true)
    public List<State> findAll() {
        return stateDAO.findAll();
    }
    
}
