package com.arturo.jm2api.build.equipment;

import com.arturo.jm2api.build.Build;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "equipments")
@Data
public class Equipment implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idEquipment")
	private Integer idEquipment;
	
	@Column(name = "valueEquiment")
	private String valueEquiment;
	
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "equipments")
    @JsonBackReference
	private Set<Build> builds = new HashSet<>();
	
}
