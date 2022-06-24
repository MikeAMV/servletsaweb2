package mx.edu.utez.aweb2.proyectobaseestructura2.model.administration.person;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BeanPerson {

    private long id;
    private String name;
    private String lastname;
    private double height;
    private Date age;


    public BeanPerson() {
    }

    public BeanPerson(String name, String lastname, double height, Date age) {
        this.name = name;
        this.lastname = lastname;
        this.height = height;
        this.age = age;
    }

    public BeanPerson(long id, String name, String lastname, double height, Date age) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.height = height;
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public Date getAge() {
        return age;
    }

    public void setAge(Date age) {
        this.age = age;
    }

    public String getAgeFormat(){
        return new SimpleDateFormat("yyyy-MM-dd").format(this.age);
    }
}
