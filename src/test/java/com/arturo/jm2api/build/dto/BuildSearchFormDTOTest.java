package com.arturo.jm2api.build.dto;

import com.arturo.jm2api.common.Profiles;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
@ActiveProfiles(Profiles.DEVELOPMENT)
public class BuildSearchFormDTOTest {

    private BuildSearchFormDTO dto;
    private Integer state = 1;
    private Integer type = 1;
    private String town = "TOWN";
    private String country = "COUNTRY";
    private Float priceMin = 1f;
    private Float priceMax = 2f;

    @Before
    public void setUp() throws Exception {
        dto = new BuildSearchFormDTO();
        dto.setState(state);
        dto.setType(type);
        dto.setTown(town);
        dto.setCountry(country);
        dto.setPriceMin(priceMin);
        dto.setPriceMax(priceMax);
    }

    @Test
    public void getType() throws Exception {
        assertEquals(type, dto.getType());
    }

    @Test
    public void setType() throws Exception {
        Integer type = 2;
        dto.setType(type);

        assertEquals(type, dto.getType());
    }

    @Test
    public void getState() throws Exception {
        assertEquals(state, dto.getState());
    }

    @Test
    public void setState() throws Exception {
        Integer state = 2;
        dto.setState(state);

        assertEquals(state, dto.getState());
    }

    @Test
    public void getTown() throws Exception {
        assertEquals(town, dto.getTown());
    }

    @Test
    public void setTown() throws Exception {
        String town = "NEW_TOWN";
        dto.setTown(town);

        assertEquals(town, dto.getTown());
    }

    @Test
    public void getCountry() throws Exception {
        assertEquals(country, dto.getCountry());
    }

    @Test
    public void setCountry() throws Exception {
        String country = "NEW_COUNTRY";
        dto.setCountry(country);

        assertEquals(country, dto.getCountry());
    }

    @Test
    public void getPriceMin() throws Exception {
        assertEquals(priceMin, dto.getPriceMin());
    }

    @Test
    public void setPriceMin() throws Exception {
        Float priceMin = 100f;
        dto.setPriceMin(priceMin);

        assertEquals(priceMin, dto.getPriceMin());
    }

    @Test
    public void getPriceMax() throws Exception {
        assertEquals(priceMax, dto.getPriceMax());
    }

    @Test
    public void setPriceMax() throws Exception {
        Float priceMax = 200f;
        dto.setPriceMax(priceMax);

        assertEquals(priceMax, dto.getPriceMax());
    }

}