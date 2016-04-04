package com.makda.common.model;

/**
 * Created by magdgar on 2016-04-02.
 */

import javax.persistence.*;
import javax.persistence.Entity;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "cuisines", catalog = "xf", uniqueConstraints = {
        @UniqueConstraint(columnNames = "CUISINE_NAME")})
public class Cuisine implements java.io.Serializable {

    private Integer cousineId;
    private String cousineName;

    public Cuisine(){}
    public Cuisine(String name){
        this.cousineName = name;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "CUISINE_ID", unique = true, nullable = false)
    public Integer getCuisineId() {
        return this.cousineId;
    }

    public void setCuisineId(Integer id) {
        this.cousineId = id;
    }

    @Column(name = "CUISINE_NAME", unique = true, nullable = false, length = 10)
    public String getCuisineName() {
        return this.cousineName;
    }

    public void setCuisineName(String name) {
        this.cousineName = name;
    }

}
