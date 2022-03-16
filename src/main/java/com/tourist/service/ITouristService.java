package com.tourist.service;

import java.util.List;

import com.tourist.entity.Tourist;
import com.tourist.exception.TouristNotFoundException;

public interface ITouristService {

	// 1.save operations
	public String registerTourist(Tourist tourist);

	// 2.Fetch all tourists
	public List<Tourist> fetchAllTourists();

	// 3.Fetch one tourist using id
	public Tourist findByTourist(Integer touristId) throws TouristNotFoundException;

	// 4.update operation
	public String updateTourist(Tourist tourist) throws TouristNotFoundException;
	
	//5.Delete Operation
	public String deleteTourit(Integer tid) throws TouristNotFoundException;

}
