package com.arturo.jm2api.build.feature;

import com.arturo.jm2api.build.Build;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "features")
@Data
public class Feature implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idFeature")
	private Integer idFeature;
	
	@Column(name = "valueFeature")
	private String valueFeature;
	
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "features")
    @JsonBackReference
	private Set<Build> builds;

}
