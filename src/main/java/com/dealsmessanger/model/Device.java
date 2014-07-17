package com.dealsmessanger.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

@Document(collection="device")
public class Device implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String deviceId;
	
	private Integer version;
	
	private String platform;
	
	private String platformVersion;
	
	@Indexed
	private String uniqueDeviceId;
	
	private Date lastAccessed;
	
	private String brand;
	
	private String model;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd,HH:00", timezone="GMT+1")
	private Date created;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd,HH:00", timezone="GMT+1")
	private Date updated;
	
	@Indexed
	private double[] location;
	
	private String gcmRegId;
	
	private String imei;
	
	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public String getPlatformVersion() {
		return platformVersion;
	}

	public void setPlatformVersion(String platformVersion) {
		this.platformVersion = platformVersion;
	}

	public String getUniqueDeviceId() {
		return uniqueDeviceId;
	}

	public void setUniqueDeviceId(String uniqueDeviceId) {
		this.uniqueDeviceId = uniqueDeviceId;
	}

	public Date getLastAccessed() {
		return lastAccessed;
	}

	public void setLastAccessed(Date lastAccessed) {
		this.lastAccessed = lastAccessed;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public double[] getLocation() {
		return location;
	}

	public void setLocation(double[] location) {
		this.location = location;
	}
	
	public String getGcmRegId() {
		return gcmRegId;
	}

	public void setGcmRegId(String gcmRegId) {
		this.gcmRegId = gcmRegId;
	}

	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((deviceId == null) ? 0 : deviceId.hashCode());
		result = prime * result
				+ ((uniqueDeviceId == null) ? 0 : uniqueDeviceId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Device other = (Device) obj;
		if (deviceId == null) {
			if (other.deviceId != null)
				return false;
		} else if (!deviceId.equals(other.deviceId))
			return false;
		if (uniqueDeviceId == null) {
			if (other.uniqueDeviceId != null)
				return false;
		} else if (!uniqueDeviceId.equals(other.uniqueDeviceId))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Device [deviceId=" + deviceId + ", version=" + version
				+ ", platform=" + platform + ", platformVersion="
				+ platformVersion + ", uniqueDeviceId=" + uniqueDeviceId
				+ ", lastAccessed=" + lastAccessed + ", brand=" + brand
				+ ", model=" + model + ", created=" + created + ", updated="
				+ updated + ", location=" + Arrays.toString(location)
				+ ", gcmRegId=" + gcmRegId + ", imei=" + imei + "]";
	}
	
}
