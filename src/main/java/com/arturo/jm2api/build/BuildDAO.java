package com.arturo.jm2api.build;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by Arturo on 12/03/2017.
 */
public interface BuildDAO extends JpaRepository<Build, Long> {

    @Query("SELECT build FROM Build build WHERE " +
            "build.type.id = :type " +
            "AND build.state.id = :state " +
            "AND build.address.town = :town " +
            "AND build.address.country = :country " +
            "AND build.price BETWEEN :priceMin AND :priceMax")
    Page<Build> findBySearchForm(Integer type,
                                 Integer state,
                                 String town,
                                 String country,
                                 Integer priceMin,
                                 Integer priceMax,
                                 Pageable page);

}
