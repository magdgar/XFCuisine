package com.makda.common.model;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by magdgar on 2016-04-02.
 */
@Entity
@Table(name = "orders", catalog = "xf")
public class Order implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ORDER_ID", unique = true, nullable = false)
    private Integer orderId;

    @ManyToOne
    @JoinColumn(name = "MAIN_COURSE_ID")
    private MainCourse mainCourse;

    @ManyToOne
    @JoinColumn(name = "DESERT_ID")
    private Desert desert;

    @ManyToOne
    @JoinColumn(name = "DRINK_ID")
    private Drink drink;

    @Column(name = "LEMON")
    private Boolean lemon;

    @Column(name = "ICE_QUBES")
    private Boolean iceQubes;

    @Column(name = "PRICE", nullable = false)
    private Integer price;

    public Order(){}

    public Order(MainCourse mainCourse, Desert desert, Drink drink, boolean lemon, boolean iceQubes){
        this.mainCourse = mainCourse;
        this.desert = desert;
        this.drink = drink;
        this.iceQubes= iceQubes;
        this.lemon = lemon;
        this.price =  (mainCourse != null)?mainCourse.getPrice():0;
        this.price += (desert!= null)?desert.getPrice():0;
        this.price += (drink!=null)? drink.getPrice():0;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public MainCourse getMainCourse() {
        return mainCourse;
    }

    public void setMainCourse(MainCourse mainCourse) {
        this.mainCourse = mainCourse;
    }

    public Desert getDesert() {
        return desert;
    }

    public void setDesert(Desert desert) {
        this.desert = desert;
    }

    public Drink getDrink() {
        return drink;
    }

    public void setDrink(Drink drink) {
        this.drink = drink;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setLemon(Boolean lemon) {
        this.lemon = lemon;
    }

    public  boolean getLemon(){ return this.lemon; }

    public void setIceQubes(boolean value){ this.iceQubes = value;}

    public boolean getIceQubes(){ return this.iceQubes; }
}
