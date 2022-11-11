package com.grupo4TBD.Lab2.repositories;

import com.grupo4TBD.Lab2.models.Region;

import java.util.List;

public interface RegionRepository {
    List<Region> getAllRegions();
    Region getRegionById(Integer id);

    void createRegion(Region region);

    void deleteRegionById(Integer id);

    void updateRegion(Region region);

    int countRegion();
}
