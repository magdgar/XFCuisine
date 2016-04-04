package com.makda.common.model;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by magdgar on 2016-04-02.
 */

@Entity
@Table(name = "drinks", catalog = "xf", uniqueConstraints = {
        @UniqueConstraint(columnNames = "DRINK_NAME")})
public class Drink implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "DRINK_ID", unique = true, nullable = false)
    private Integer drinkId;

    @Column(name = "DRINK_NAME", unique = true, nullable = false, length = 10)
    private String drinkName;

    @Column(name = "PRICE", nullable = false)
    private Integer price;

    public Drink(){}
    public Drink(String name, int price){
        this.drinkName = name;
        this.price = price;
    }

    public Integer getDrinkId() {
        return this.drinkId;
    }

    public void setDrinkId(Integer id) {
        this.drinkId = id;
    }

    public String getDrinkName() {
        return this.drinkName;
    }

    public void setDrinkName(String name){ this.drinkName = name; }


    public Integer getPrice(){ return price; }

    public void setPrice(Integer price){ this.price = price;}


}
