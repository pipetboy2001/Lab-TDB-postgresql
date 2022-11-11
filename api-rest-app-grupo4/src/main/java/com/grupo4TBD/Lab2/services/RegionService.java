package com.grupo4TBD.Lab2.services;


import com.grupo4TBD.Lab2.models.Region;
import com.grupo4TBD.Lab2.repositories.RegionRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/")

public class RegionService {
    private final RegionRepository regionRepository;

    public RegionService(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    @PostMapping("/region")
    public void createRegion(@RequestBody Region region){
        regionRepository.createRegion(region);
    }
    @GetMapping("/region/{id}")
    public Region getRegionById(@PathVariable Integer id){
        return regionRepository.getRegionById(id);
    }
    @GetMapping("/region")
    public List<Region> getAllRegion(){
        return regionRepository.getAllRegions();
    }


    @DeleteMapping
    public void deleteRegionById(@PathVariable Integer id){
        regionRepository.deleteRegionById(id);
    }

    @PutMapping("/region")
    public void updateRegion(@RequestBody Region region){
        regionRepository.updateRegion(region);
    }

    @GetMapping("/region/count")
    public int countRegion(){
        return regionRepository.countRegion();
    }


}
