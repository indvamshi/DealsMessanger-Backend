package com.dealsmessanger.repository;

import java.util.List;

import org.springframework.data.mongodb.core.geo.Circle;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.dealsmessanger.model.Device;

public interface DeviceRepository extends MongoRepository<Device, String>{

	List<Device> findByLocationWithin(Circle c);
}
