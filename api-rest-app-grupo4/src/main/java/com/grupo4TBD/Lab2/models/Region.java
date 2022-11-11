package com.grupo4TBD.Lab2.models;

import org.springframework.boot.autoconfigure.domain.EntityScan;


@EntityScan
public class Region {
    private long gid;
    private String nom_reg;
    private String nom_prov;
    private String cod_com;
    private String nom_com;
    private Integer cod_regi;
    private Integer superficie;
    private Integer poblac02;
    private Integer pobl2010;
    private Integer shape_leng;
    private Integer shape_area;
    private String geom;

    public Region(long gid, String nom_reg, String nom_prov, String cod_com, String nom_com, Integer cod_regi, Integer superficie, Integer poblac02, Integer pobl2010, Integer shape_leng, Integer shape_area, String geom) {
        this.gid = gid;
        this.nom_reg = nom_reg;
        this.nom_prov = nom_prov;
        this.cod_com = cod_com;
        this.nom_com = nom_com;
        this.cod_regi = cod_regi;
        this.superficie = superficie;
        this.poblac02 = poblac02;
        this.pobl2010 = pobl2010;
        this.shape_leng = shape_leng;
        this.shape_area = shape_area;
        this.geom = geom;
    }
    //GETTERS
    public long getGid() {
        return gid;
    }

    public String getNom_reg() {
        return nom_reg;
    }

    public String getNom_prov() {
        return nom_prov;
    }

    public String getCod_com() {
        return cod_com;
    }

    public String getNom_com() {
        return nom_com;
    }

    public Integer getCod_regi() {
        return cod_regi;
    }

    public Integer getSuperficie() {
        return superficie;
    }

    public Integer getPoblac02() {
        return poblac02;
    }

    public Integer getPobl2010() {
        return pobl2010;
    }

    public Integer getShape_leng() {
        return shape_leng;
    }

    public Integer getShape_area() {
        return shape_area;
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

    public void setNom_prov(String nom_prov) {
        this.nom_prov = nom_prov;
    }

    public void setCod_com(String cod_com) {
        this.cod_com = cod_com;
    }

    public void setNom_com(String nom_com) {
        this.nom_com = nom_com;
    }

    public void setCod_regi(Integer cod_regi) {
        this.cod_regi = cod_regi;
    }

    public void setSuperficie(Integer superficie) {
        this.superficie = superficie;
    }

    public void setPoblac02(Integer poblac02) {
        this.poblac02 = poblac02;
    }

    public void setPobl2010(Integer pobl2010) {
        this.pobl2010 = pobl2010;
    }

    public void setShape_leng(Integer shape_leng) {
        this.shape_leng = shape_leng;
    }

    public void setShape_area(Integer shape_area) {
        this.shape_area = shape_area;
    }

    public void setGeom(String geom) {
        this.geom = geom;
    }
}
