package com.ecommerce.microcommerce.dao;

import com.ecommerce.microcommerce.model.Personnage;

import java.util.List;


public interface PersonnageDao {

    List<Personnage> findAll();

    Personnage findById(int id);

    Personnage save(Personnage personnage);

    void delete(int id);
}




