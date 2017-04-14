package com.arturo.jm2api.build;

import com.arturo.jm2api.build.dto.BuildSearchFormDTO;
import com.arturo.jm2api.common.Profiles;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ActiveProfiles;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
@ActiveProfiles(Profiles.DEVELOPMENT)
public class BuildControllerTest {

    private Build build = new Build();
    private Pageable page = new PageRequest(0, 10);

    @InjectMocks private BuildController buildController;
    @Mock private BuildService buildService;

    @Test
    public void list() throws Exception {
        BuildSearchFormDTO form = new BuildSearchFormDTO();
        Page<Build> expected = new PageImpl<>(Arrays.asList(build));
        Mockito.when(buildService.findBuilds(form, page)).thenReturn(expected);

        assertEquals(expected, buildController.list(form, page));
    }

    @Test
    public void get() throws Exception {
        Mockito.when(buildService.findBuild(1L)).thenReturn(build);

        assertEquals(build, buildController.get(1L));
    }

    @Test
    public void update() throws Exception {
        Mockito.when(buildService.updateBuild(build)).thenReturn(build);

        assertEquals(build, buildController.update(build));
    }

    @Test
    public void save() throws Exception {
        Mockito.when(buildService.saveBuild(build)).thenReturn(build);

        assertEquals(build, buildController.save(build));
    }
    
    
    @Test
    public void delete() throws Exception {
    	buildController.delete(1L);
    }

}