package com.tourist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tourist.entity.Tourist;

public interface ITouristRepo extends JpaRepository<Tourist, Integer> {

}
