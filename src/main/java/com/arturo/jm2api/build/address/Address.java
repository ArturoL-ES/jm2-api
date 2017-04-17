package com.arturo.jm2api.build.address;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "build_address")
@Data //NOSONAR
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Integer id;

    private String houseNumber;
    private String street;
    private String postalCode;
    private String town;
    private String country;

}
