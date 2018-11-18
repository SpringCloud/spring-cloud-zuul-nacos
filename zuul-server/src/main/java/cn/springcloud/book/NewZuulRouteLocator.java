package cn.springcloud.book;

import java.util.LinkedHashMap;
import java.util.Map;

import cn.springcloud.book.dao.PropertiesAssemble;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.RefreshableRouteLocator;
import org.springframework.cloud.netflix.zuul.filters.SimpleRouteLocator;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties.ZuulRoute;
import org.springframework.util.StringUtils;

public class NewZuulRouteLocator extends SimpleRouteLocator implements RefreshableRouteLocator {

	@Autowired
	private ZuulProperties properties;
	
	@Autowired
	private PropertiesAssemble propertiesAssemble;

	public NewZuulRouteLocator(String servletPath, ZuulProperties properties) {
		super(servletPath, properties);
		this.properties = properties;
	}

	@Override
	public void refresh() {
		doRefresh();
	}

	@Override
	protected Map<String, ZuulRoute> locateRoutes() {
		LinkedHashMap<String, ZuulRoute> routesMap = new LinkedHashMap<String, ZuulRoute>();
		// 从application.properties中加载路由信息
		routesMap.putAll(super.locateRoutes());
		// 从Nacos中加载路由信息
		routesMap.putAll(propertiesAssemble.getProperties());
		// 优化一下配置
		LinkedHashMap<String, ZuulRoute> values = new LinkedHashMap<>();
		for (Map.Entry<String, ZuulRoute> entry : routesMap.entrySet()) {
			String path = entry.getKey();
			// Prepend with slash if not already present.
			if (!path.startsWith("/")) {
				path = "/" + path;
			}
			if (StringUtils.hasText(this.properties.getPrefix())) {
				path = this.properties.getPrefix() + path;
				if (!path.startsWith("/")) {
					path = "/" + path;
				}
			}
			values.put(path, entry.getValue());
		}
		return values;
	}
}
