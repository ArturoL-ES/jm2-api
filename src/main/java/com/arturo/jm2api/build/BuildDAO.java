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
            "(?1 IS NULL OR build.type.id = ?1) " +
            "AND (?2 IS NULL OR build.state.id = ?2) " +
            "AND (?3 IS NULL OR build.address.town = ?3) " +
            "AND (?4 IS NULL OR build.address.country = ?4) " +
            "AND (?5 IS NULL OR build.price >= ?5) " +
            "AND (?6 IS NULL OR build.price <= ?6)")
    Page<Build> findBySearchForm(Integer type,
                                 Integer state,
                                 String town,
                                 String country,
                                 Float priceMin,
                                 Float priceMax,
                                 Pageable page);

}
