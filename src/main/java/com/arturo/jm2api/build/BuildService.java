package com.arturo.jm2api.build;

import com.arturo.jm2api.build.dto.BuildSearchFormDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by Arturo on 12/03/2017.
 */
public interface BuildService {

    public Page<Build> findBuilds(BuildSearchFormDTO form, Pageable page);

    public Build findBuild(Long id);
    
    public Build updateBuild(Build build);
    
    public Build saveBuild(Build build);
    
    public void deleteBuild(Long id);

}
