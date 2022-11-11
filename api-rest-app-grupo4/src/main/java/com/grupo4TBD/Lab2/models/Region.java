package com.grupo4TBD.Lab2.models;

import org.springframework.boot.autoconfigure.domain.EntityScan;


@EntityScan
public class Region {
    private long gid;
    private String nom_reg;
    private String geom;

    public Region(long gid, String nom_reg,String geom) {
        this.gid = gid;
        this.nom_reg = nom_reg;
        this.geom = geom;
    }
    //GETTERS
    public long getGid() {
        return gid;
    }

    public String getNom_reg() {
        return nom_reg;
    }

    public String getGeom() {
        return geom;
    }

    //SETTERS

    public void setGid(long gid) {
        this.gid = gid;
    }

    public void setNom_reg(String nom_reg) {
        this.nom_reg = nom_reg;
    }

    public void setGeom(String geom) {
        this.geom = geom;
    }
}
