package cn.springcloud.nacos.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cn.springcloud.nacos.NewZuulRouteLocator;

@Configuration
public class NewZuulConfig {

	@Autowired
	private ZuulProperties zuulProperties;
	
	@Autowired
	private ServerProperties serverProperties;
	
	@Bean
	public NewZuulRouteLocator routeLocator() {
		NewZuulRouteLocator routeLocator = new NewZuulRouteLocator(
				this.serverProperties.getServlet().getServletPrefix(), this.zuulProperties);
		return routeLocator;
	}
}
