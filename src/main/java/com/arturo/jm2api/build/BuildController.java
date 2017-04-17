package com.arturo.jm2api.build;

import com.arturo.jm2api.build.dto.BuildSearchFormDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Arturo on 12/03/2017.
 */
@RestController
@RequestMapping("/builds")
public class BuildController {

    @Autowired private BuildService buildService;
    
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Page<Build> list(
            @ModelAttribute BuildSearchFormDTO form,
            @PageableDefault(value = 10, page = 0) Pageable page) {
        return buildService.findBuilds(form, page);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Build get(@PathVariable Long id) {
        return buildService.findBuild(id);
    }
    
    @RequestMapping(value = "", method = RequestMethod.PUT)
    public ResponseEntity<Build> update(@ModelAttribute Build build) {
        return new ResponseEntity<>(buildService.updateBuild(build), HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<Build> save(@ModelAttribute Build build) {
        return new ResponseEntity<>(buildService.saveBuild(build), HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable Long id) {
    	buildService.deleteBuild(id);
    	return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
