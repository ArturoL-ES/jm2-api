package com.arturo.jm2api.build;

import com.arturo.jm2api.build.address.Address;
import com.arturo.jm2api.build.equipment.Equipment;
import com.arturo.jm2api.build.feature.Feature;
import com.arturo.jm2api.build.image.Image;
import com.arturo.jm2api.build.state.State;
import com.arturo.jm2api.build.type.Type;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Cacheable
@Table(name = "builds")
public @Data class Build implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private Long id;
	
	@Column(name = "price", nullable = false, length = 10, precision = 2)
	private Float price;
	
	@Column(name = "currency", nullable = false, length = 6)
	private String currency;
	
	@Column(name = "description", nullable = false, length = 6000)
	private String description;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
	private State state;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
	private Type type;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Address address;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "build_features", joinColumns = 
		{ @JoinColumn(name = "build_id", nullable = false, updatable = false) },
		inverseJoinColumns = 
			{ @JoinColumn(name = "feature_id", nullable = false, updatable = false) }
	)
	@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
	private Set<Feature> features = new HashSet<>();
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "build_equipments", joinColumns = 
		{ @JoinColumn(name = "build_id", nullable = false, updatable = false) },
		inverseJoinColumns = 
			{ @JoinColumn(name = "equipment_id", nullable = false, updatable = false) }
	)
	@JsonManagedReference
	@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
	private Set<Equipment> equipments = new HashSet<>();
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "build")
	//@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
	private Set<Image> images = new HashSet<>();
	
	@Column(name = "identifier", nullable = false, length = 100)
	private String identifier;

}
