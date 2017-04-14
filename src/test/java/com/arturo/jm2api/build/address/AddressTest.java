package com.arturo.jm2api.build.address;

import com.arturo.jm2api.common.Profiles;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
@ActiveProfiles(Profiles.DEVELOPMENT)
public class AddressTest {

    private Address address;
    private Integer id = 1;
    private String houseNumber = "hn";
    private String street = "s";
    private String postalCode = "p";
    private String town = "t";
    private String country = "c";

    @Before
    public void setUp() throws Exception {
        address = new Address();
        address.setId(id);
        address.setHouseNumber(houseNumber);
        address.setStreet(street);
        address.setPostalCode(postalCode);
        address.setTown(town);
        address.setCountry(country);
    }

    @Test
    public void getId() throws Exception {
        assertEquals(id, address.getId());
    }

    @Test
    public void setId() throws Exception {
        Integer id = 2;
        address.setId(2);

        assertEquals(id, address.getId());
    }

    @Test
    public void getHouseNumber() throws Exception {
        assertEquals(houseNumber, address.getHouseNumber());
    }

    @Test
    public void setHouseNumber() throws Exception {
        String houseNumber = "NEW_HOUSE_NUMBER";
        address.setHouseNumber(houseNumber);

        assertEquals(houseNumber, address.getHouseNumber());
    }

    @Test
    public void getStreet() throws Exception {
        assertEquals(street, address.getStreet());
    }

    @Test
    public void setStreet() throws Exception {
        String street = "NEW_STREET";
        address.setStreet(street);

        assertEquals(street, address.getStreet());
    }

    @Test
    public void getPostalCode() throws Exception {
        assertEquals(postalCode, address.getPostalCode());
    }

    @Test
    public void setPostalCode() throws Exception {
        String postalCode = "NEW_POSTAL_CODE";
        address.setPostalCode(postalCode);

        assertEquals(postalCode, address.getPostalCode());
    }

    @Test
    public void getTown() throws Exception {
        assertEquals(town, address.getTown());
    }

    @Test
    public void setTown() throws Exception {
        String town = "NEW_TOWN";
        address.setTown(town);

        assertEquals(town, address.getTown());
    }

    @Test
    public void getCountry() throws Exception {
        assertEquals(country, address.getCountry());
    }

    @Test
    public void setCountry() throws Exception {
        String country = "NEW_COUNTRY";
        address.setCountry(country);

        assertEquals(country, address.getCountry());
    }

}