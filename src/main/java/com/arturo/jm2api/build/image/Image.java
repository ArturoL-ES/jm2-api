package com.arturo.jm2api.build.image;

import com.arturo.jm2api.build.Build;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "build_images")
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

	public Integer getIdImage() {
		return idImage;
	}

	public void setIdImage(Integer idImage) {
		this.idImage = idImage;
	}

	public Build getBuild() {
		return build;
	}

	public void setBuild(Build build) {
		this.build = build;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}