package com.datamart.regioncases.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.datamart.regioncases.entity.Region;
import com.datamart.regioncases.repository.RegionRepository;

@Service
public class RegionService {
    @Autowired
    private RegionRepository regionRepository;

    public void save(Region region) {
        this.regionRepository.save(region);
    }

    public List<Region> findAll(){
        return this.regionRepository.findAll();
    }

    public Region findById(Long id){
        return this.regionRepository.findById(id).get();
    }

    public void delete(Long id){
        this.regionRepository.deleteById(id);
    }
}
