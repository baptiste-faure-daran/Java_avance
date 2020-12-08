package com.ecommerce.microcommerce.model;

public class Personnage {

    public int Id;
    public String Name;
    public String Classe;

    public Personnage(int id, String name, String classe) {
        Id = id;
        Name = name;
        Classe = classe;

    }

    public String ToString() {
        return "id :" + Id + ", classe :" + Classe + ", name :" + Name;
    }

    public int getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public String getClasse() {
        return Classe;
    }

    public void setId(int id) {
        Id = id;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setClasse(String classe) {
        Classe = classe;
    }
}
