package com.broadenway.ureasolution;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class StoreGasStationInfoMain {

	public static void main(String[] args){
		new SpringApplicationBuilder(StoreGasStationInfoMain.class).web(WebApplicationType.NONE).run(args);
	}
}
