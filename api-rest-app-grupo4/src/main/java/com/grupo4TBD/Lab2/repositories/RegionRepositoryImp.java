package com.grupo4TBD.Lab2.repositories;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

@Repository
public class RegionRepositoryImp implements RegionRepository {
    @Autowired
    private Sql2o sql2o;

    @Override
    public int newId() {
        int id = 0;
        String sql = "SELECT MAX(id) FROM region";
        try (Connection conn = sql2o.open()) {
            id = conn.createQuery(sql).executeScalar(Integer.class);
            return id;
        }
    }


}
