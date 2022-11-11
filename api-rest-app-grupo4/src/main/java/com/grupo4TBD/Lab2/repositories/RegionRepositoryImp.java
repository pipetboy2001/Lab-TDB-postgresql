package com.grupo4TBD.Lab2.repositories;


import com.grupo4TBD.Lab2.models.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class RegionRepositoryImp implements RegionRepository {
    @Autowired
    private Sql2o sql2o;

    @Override
    public List<Region> getAllRegions() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select gid, nom_reg, geom from region where nom_reg is not null;")
                    .executeAndFetch(Region.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Region getRegionById(Integer id){
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select gid, nom_reg, geom from region where gid = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(Region.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void createRegion(Region region) {
        String sql = "INSERT INTO region ( nom_reg, geom) VALUES ( :nom_reg,ST_GeomFromText(:geom))";
        try (Connection conn = sql2o.open()) {
            conn.createQuery(sql)
                    .addParameter("nom_reg", region.getNom_reg())
                    .addParameter("geom", region.getGeom())
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteRegionById(Integer id) {
        String sql = "DELETE from region WHERE gid = :gid";
        try (Connection conn = sql2o.open()) {
            conn.createQuery(sql)
                    .addParameter("gid", id)
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateRegion(Region region){
        String sql = "UPDATE region SET nom_reg = :nom_reg, geom = ST_GeomFromText(:geom) WHERE gid = :gid";
        try (Connection conn = sql2o.open()) {
            conn.createQuery(sql)
                    .addParameter("nom_reg", region.getNom_reg())
                    .addParameter("geom", region.getGeom())
                    .addParameter("gid", region.getGid())
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public int countRegion(){
        int total = 0;
        try(Connection conn = sql2o.open()){
            total = conn.createQuery("select count(*) from region where nom_reg is not null;")
                    .executeScalar(Integer.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return total;
    }



}
