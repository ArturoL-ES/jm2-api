package com.arturo.jm2api.build.feature;

import com.arturo.jm2api.build.Build;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "features")
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

	public Integer getIdFeature() {
		return idFeature;
	}

	public void setIdFeature(Integer idFeature) {
		this.idFeature = idFeature;
	}

	public String getValueFeature() {
		return valueFeature;
	}

	public void setValueFeature(String valueFeature) {
		this.valueFeature = valueFeature;
	}

	public Set<Build> getBuilds() {
		return builds;
	}

	public void setBuilds(Set<Build> builds) {
		this.builds = builds;
	}

}
