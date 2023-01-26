package com.meuexemplo.zuulservice.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerAutoConfiguration;
import org.springframework.cloud.netflix.ribbon.apache.RibbonLoadBalancingHttpClient;
import org.springframework.context.annotation.Bean;

import com.netflix.client.config.IClientConfig;

public class RibbonClientConfiguration extends LoadBalancerAutoConfiguration{
    
    @Autowired
    private IClientConfig config;

    RibbonClientConfiguration(){
        
    }
 
    @Bean
    public RibbonLoadBalancingHttpClient ribbonLoadBalancingHttpClient(IClientConfig config) {
        return new RibbonLoadBalancingHttpClient(config, null);
    }
}
