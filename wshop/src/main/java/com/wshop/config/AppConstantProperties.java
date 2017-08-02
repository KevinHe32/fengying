package com.wshop.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 应用常量
 */
@Configuration
@ConfigurationProperties(prefix = "app.constant", ignoreUnknownFields = true)
public class AppConstantProperties {

	private String defaultPassword;

	private String uploadfileSavePath;

	private String system;

	private String uploadUrl;

	private String secretKey;

	public String getDefaultPassword() {
		return defaultPassword;
	}

	public void setDefaultPassword(String defaultPassword) {
		this.defaultPassword = defaultPassword;
	}

	public String getUploadfileSavePath() {
		return uploadfileSavePath;
	}

	public void setUploadfileSavePath(String uploadfileSavePath) {
		this.uploadfileSavePath = uploadfileSavePath;
	}

	public String getUploadUrl() {
		return uploadUrl;
	}

	public void setUploadUrl(String uploadUrl) {
		this.uploadUrl = uploadUrl;
	}

	public String getSystem() {
		return system;
	}

	public void setSystem(String system) {
		this.system = system;
	}

	public String getSecretKey() {
		return secretKey;
	}

	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}
}
