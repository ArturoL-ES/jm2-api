package com.arturo.jm2api.build.state;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "states")
@Data
public class State implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idState", nullable = false)
	private Integer idState;
	
	@Column(name = "valueState", nullable = false, length = 16)
	private String valueState;
	
}