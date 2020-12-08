package com.ecommerce.microcommerce.dao;
import com.ecommerce.microcommerce.model.Personnage;

import java.util.List;


public interface PersonnageDao {

     List<Personnage>FindAll();

     Personnage PersonnageFindById(int id);

     Personnage PersonnageSave(Personnage personnage);
}




