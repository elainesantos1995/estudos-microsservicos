package com.meuexemplo.zuulservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

import com.meuexemplo.zuulservice.configuration.*;
import org.springframework.cloud.netflix.ribbon.*;
import org.springframework.cloud.netflix.ribbon.RibbonClientConfiguration;;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
@RibbonClient(name = "your-service-name", configuration = RibbonClientConfiguration.class)
public class ZuulServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulServiceApplication.class, args);
	}

}
