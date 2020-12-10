package com.ecommerce.microcommerce.dao;

import com.ecommerce.microcommerce.model.Personnage;

import java.util.List;


public interface PersonnageDao {

    // GET
    List<Personnage> findAll();

    // GETBYID
    Personnage findById(int id);

    // POST
    Personnage save(Personnage personnage);

    // PUT
    Personnage update(int id,Personnage input);

    // DELETE
    boolean delete(int id);
}




