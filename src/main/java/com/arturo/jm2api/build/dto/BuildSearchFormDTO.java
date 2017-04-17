package com.arturo.jm2api.build.dto;

import lombok.Data;

@Data
public class BuildSearchFormDTO {

    private Integer type;
    private Integer state;
    private String town;
    private String country;
    private Float priceMin;
    private Float priceMax;

}
