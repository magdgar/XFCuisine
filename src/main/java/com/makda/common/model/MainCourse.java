package com.makda.common.model;

import com.makda.common.model.Cuisine;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by magdgar on 2016-04-02.
 */

@Entity
@Table(name = "main_courses", catalog = "xf", uniqueConstraints = {
        @UniqueConstraint(columnNames = "MAIN_COURSE_NAME")})
public class MainCourse implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "MAIN_COURSE_ID", unique = true, nullable = false)
    private Integer mainCourseId;

    @Column(name = "MAIN_COURSE_NAME", unique = true, nullable = false, length = 10)
    private String mainCuorseName;

    @ManyToOne
    @JoinColumn(name = "CUISINE_ID", nullable = false)
    private Cuisine cuisine;

    @Column(name = "PRICE", nullable = false)
    private Integer price;

    public MainCourse(){}
    public MainCourse(String name, Cuisine cuisine, int price){
        this.mainCuorseName = name;
        this.cuisine = cuisine;
        this.price = price;
    }

    public Integer getMainCourseId() {
        return this.mainCourseId;
    }

    public void setMainCourseId(Integer id) {
        this.mainCourseId = id;
    }


    public String getMainCuorseName() {
        return this.mainCuorseName;
    }

    public void setMainCourseName(String name) {
        this.mainCuorseName = name;
    }


    public Cuisine getMainCourseCuisine() { return this.cuisine; }

    public void setMainCourseCuisine(Cuisine cuisine) { this.cuisine = cuisine; }

    public Integer getPrice() { return price; }

    public void setPrice(Integer price) { this.price = price; }
}
