package com.arturo.jm2api.build;

import com.arturo.jm2api.build.address.Address;
import com.arturo.jm2api.build.equipment.Equipment;
import com.arturo.jm2api.build.feature.Feature;
import com.arturo.jm2api.build.image.Image;
import com.arturo.jm2api.build.state.State;
import com.arturo.jm2api.build.type.Type;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Cacheable
@Table(name = "builds")
public class Build implements Serializable {
	
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Set<Feature> getFeatures() {
		return features;
	}

	public void setFeatures(Set<Feature> features) {
		this.features = features;
	}

	public Set<Equipment> getEquipments() {
		return equipments;
	}

	public void setEquipments(Set<Equipment> equipments) {
		this.equipments = equipments;
	}

	public Set<Image> getImages() {
		return images;
	}

	public void setImages(Set<Image> images) {
		this.images = images;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
