package com.makda.common.model;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by magdgar on 2016-04-02.
 */

@Entity
@Table(name = "deserts", catalog = "xf", uniqueConstraints = {
        @UniqueConstraint(columnNames = "DESERT_NAME")})
public class Desert implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "DESERT_ID", unique = true, nullable = false)
    private Integer desertId;

    @Column(name = "DESERT_NAME", unique = true, nullable = false, length = 10)
    private String desertName;

    @Column(name = "PRICE", nullable = false)
    private Integer price;

    public Desert(){}
    public Desert(String name, int price){
        this.desertName = name;
        this.price = price;
    }


    public Integer getDesertId() { return this.desertId; }

    public void setDesertId(Integer id) {
        this.desertId = id;
    }

    public String getDesertName() {
        return this.desertName;
    }

    public void setDesertName(String name) {
        this.desertName = name;
    }

    public Integer getPrice() { return price; }

    public void setPrice(Integer price) { this.price = price; }
}
