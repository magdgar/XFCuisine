package com.makda.common;

import com.makda.common.model.*;
import org.hibernate.Query;
import org.hibernate.Session;
import com.makda.persistence.HibernateUtil;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main( String[] args ) {
        createData(); //use only in first run
        displayMenu();
        getOrder();
    }

    public static void getOrder(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("What you wonna get? Drink - type D, Lunch - type L");
        String decision = scanner.next();

        Session session = HibernateUtil.getSessionFactory().openSession();
        if(decision.equals("L")){
            System.out.println("So you wonna lunch. Type name of dish");
            String dishName = scanner.next();
            System.out.println("Nice. Type name of desert");
            String desertName = scanner.next();

            String hql = "FROM MainCourse M WHERE M.mainCuorseName ='"+ dishName+"'";
            Query query = session.createQuery(hql);
            List dishList = query.list();
            if(dishList.size() ==0)
                System.out.println("No such dish in menu");
            else {
                String hql1 = "FROM Desert D WHERE D.desertName ='" + desertName+"'";
                Query desertQuery = session.createQuery(hql1);
                List desertsList = desertQuery.list();
                if (desertsList.size() == 0)
                    System.out.println("No such desert in menu");
                else {
                    Order order = new Order(((MainCourse) dishList.get(0)), ((Desert) desertsList.get(0)), null, false, false);
                    session.beginTransaction().begin();
                    session.save(order);
                    session.getTransaction().commit();
                }
            }

        }else if(decision.equals("D")){
            System.out.println("Thirsty? I see...  Type name of drink");
            String drinkName = scanner.next();
            System.out.println("Wonna Ice qubes? Type Y to confirm");
            boolean iceChoise= false;
            if(scanner.next().equals("Y"))
                iceChoise = true;
            System.out.println("Wonna Ice lemon? Type Y to confirm");
            boolean lemonChoise =  false;
            if(scanner.next().equals("Y"))
                lemonChoise = true;
            String hql = "FROM Drink D WHERE D.drinkName ='" + drinkName+"'";
            Query drinkQuery = session.createQuery(hql);
            List drinkList = drinkQuery.list();
            if (drinkList.size() == 0)
                System.out.println("No such desert in menu");
            else{
                Order order = new Order(null, null, ((Drink) drinkList.get(0)), iceChoise, lemonChoise);
                session.beginTransaction().begin();
                session.save(order);
                session.getTransaction().commit();
            }
        }else{
            System.out.println("Nothing? oh See you soon");
        }
    }

    public static void displayMenu(){

        Session session = HibernateUtil.getSessionFactory().openSession();
        String hql = "FROM MainCourse";
        Query query = session.createQuery(hql);
        List mainCourse = query.list();

        String hql1 = "FROM Desert";
        Query desertQuery = session.createQuery(hql1);
        List deserts = desertQuery.list();

        String hql2 = "FROM Drink ";
        Query drinkQuery = session.createQuery(hql2);
        List drinks = drinkQuery.list();

        System.out.println("\n\nMenu:");
        System.out.println("\nMainCourses:");
        for(Object m: mainCourse){
            System.out.println(((MainCourse)m).getMainCourseCuisine().getCuisineName() +"  "+((MainCourse)m).getMainCuorseName() + " "+ String.valueOf(((MainCourse)m).getPrice()));
        }

        System.out.println("\nDeserts:");
        for(Object desert: deserts){
            System.out.println(((Desert)desert).getDesertName() +" "+String.valueOf(((Desert)desert).getPrice()));
        }

        System.out.println("\nDrinks:");
        for(Object drink: drinks){
            System.out.println(((Drink)drink).getDrinkName()+" "+String.valueOf(((Drink)drink).getPrice()));
        }
    }

    public static void createData(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Cuisine cuisine = new Cuisine("Polish");
        Cuisine cuisine1 = new Cuisine("Mexican");
        Cuisine cuisine2 = new Cuisine("Italian");

        session.save(cuisine);
        session.save(cuisine1);
        session.save(cuisine2);

        MainCourse mainCourse = new MainCourse("Chili", cuisine1, 25);
        MainCourse mainCourse1 = new MainCourse("Tacos", cuisine1, 15);
        MainCourse mainCourse2 = new MainCourse("Burito", cuisine1, 10);

        session.save(mainCourse);
        session.save(mainCourse1);
        session.save(mainCourse2);

        mainCourse = new MainCourse("Pizza", cuisine2, 25);
        mainCourse1 = new MainCourse("Lasagne", cuisine2, 14);
        mainCourse2 = new MainCourse("Sphagetti", cuisine2, 18);

        session.save(mainCourse);
        session.save(mainCourse1);
        session.save(mainCourse2);

        mainCourse = new MainCourse("Pierogi", cuisine, 13);
        mainCourse1 = new MainCourse("Schabowy", cuisine, 17);
        mainCourse2 = new MainCourse("Bigos", cuisine, 15);

        session.save(mainCourse);
        session.save(mainCourse1);
        session.save(mainCourse2);

        Drink drink = new Drink("cocacola", 5);
        Drink drink1 = new Drink("tea", 3);
        Drink drink2 = new Drink("beer", 4);
        Desert desert = new Desert("cake", 6);

        session.save(drink);
        session.save(drink1);
        session.save(drink2);
        session.save(desert);

        session.getTransaction().commit();
    }
}
