package com.datamart.regioncases.repository;

import com.datamart.regioncases.entity.Region;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;



public interface RegionRepository extends JpaRepository<Region, Long> {
    
    @Override
    List<Region> findAll();

    Region findById(long id);
}