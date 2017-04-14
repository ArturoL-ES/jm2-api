package com.arturo;

import com.arturo.jm2api.build.Build;
import com.arturo.jm2api.build.BuildDAO;
import com.arturo.jm2api.build.state.State;
import com.arturo.jm2api.build.state.StateDAO;
import com.arturo.jm2api.build.type.Type;
import com.arturo.jm2api.build.type.TypeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableAutoConfiguration
public class Jm2ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(Jm2ApiApplication.class, args);
	}

}
