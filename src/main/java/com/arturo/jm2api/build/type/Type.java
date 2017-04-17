package com.arturo.jm2api.build.type;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "types")
@Data
public class Type implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idType", nullable = false)
	private Integer idType;
	
	@Column(name = "valueType", nullable = false, length = 16)
	private String valueType;

}