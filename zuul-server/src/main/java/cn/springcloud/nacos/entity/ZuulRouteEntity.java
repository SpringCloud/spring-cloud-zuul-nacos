package cn.springcloud.nacos.entity;

public class ZuulRouteEntity {
	/**
	 * The ID of the route (the same as its map key by default).
	 */
	private String id;
	/**
	 * The path (pattern) for the route, e.g. /foo/**.
	 */
	private String path;
	/**
	 * The service ID (if any) to map to this route. You can specify a
	 * physical URL or a service, but not both.
	 */
	private String serviceId;
	/**
	 * A full physical URL to map to the route. An alternative is to use a
	 * service ID and service discovery to find the physical address.
	 */
	private String url;
	/**
	 * Flag to determine whether the prefix for this route (the path, minus
	 * pattern patcher) should be stripped before forwarding.
	 */
	private boolean stripPrefix = true;
	/**
	 * Flag to indicate that this route should be retryable (if supported).
	 * Generally retry requires a service ID and ribbon.
	 */
	private Boolean retryable;

	private String apiName;

	private Boolean enabled;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public boolean isStripPrefix() {
		return stripPrefix;
	}

	public void setStripPrefix(boolean stripPrefix) {
		this.stripPrefix = stripPrefix;
	}

	public Boolean getRetryable() {
		return retryable;
	}

	public void setRetryable(Boolean retryable) {
		this.retryable = retryable;
	}

	public String getApiName() {
		return apiName;
	}

	public void setApiName(String apiName) {
		this.apiName = apiName;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
}
