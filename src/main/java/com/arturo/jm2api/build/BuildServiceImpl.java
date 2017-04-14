package com.arturo.jm2api.build;

import com.arturo.jm2api.build.dto.BuildSearchFormDTO;
import com.arturo.jm2api.common.error.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Arturo on 12/03/2017.
 */
@Service
public class BuildServiceImpl implements BuildService {

    @Autowired private BuildDAO buildDAO;

    @Override
    @Transactional(readOnly = true)
    public Page<Build> findBuilds(BuildSearchFormDTO form, Pageable page) {
        return buildDAO.findBySearchForm(form.getType(),
                form.getState(),
                form.getTown(),
                form.getCountry(),
                form.getPriceMin(),
                form.getPriceMax(),
                page);
    }

    @Override
    @Transactional(readOnly = true)
    public Build findBuild(Long id) {
        return buildDAO.findOne(id);
    }
    
    @Override
    @Transactional
    public Build updateBuild(Build build) {
        if (build.getId() == null) {
            throw new CustomException(HttpStatus.BAD_REQUEST, "ErrorMessage.NotRequired.ID");
        }
        return buildDAO.save(build);
    }
    
    @Override
    @Transactional
    public Build saveBuild(Build build) {
        if (build.getId() != null) {
            throw new CustomException(HttpStatus.BAD_REQUEST, "ErrorMessage.Required.ID");
        }
        return buildDAO.save(build);
    }
    
    @Override
    @Transactional
    public void deleteBuild(Long id) {
    	if (buildDAO.findOne(id) == null) {
    		throw new CustomException(HttpStatus.NOT_FOUND, "ErrorMessage.BuildNotFound");
    	}
    	buildDAO.delete(id);
    }
}
