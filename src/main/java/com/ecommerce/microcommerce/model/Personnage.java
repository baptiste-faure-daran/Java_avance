package com.ecommerce.microcommerce.model;

public class Personnage {


    public int id;
    public String name;
    public String classe;


    public Personnage() {

    }

    public Personnage(int id, String name, String classe) {
        this.id = id;
        this.name = name;
        this.classe = classe;

    }

    public String ToString() {
        return "id :" + id + ", classe :" + classe + ", name :" + name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getClasse() {
        return classe;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }
}
