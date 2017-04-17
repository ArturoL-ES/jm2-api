package com.arturo.jm2api.build.image;

import com.arturo.jm2api.build.Build;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "build_images")
@Data //NOSONAR
public class Image implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idImage", nullable = false)
	private Integer idImage;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "build_id")
	private Build build;
	
	@Column(name = "path", nullable = false, length = 60)
	private String path;

}