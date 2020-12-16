package com.ecommerce.microcommerce.accessingdatamysql;

import com.ecommerce.microcommerce.model.Personnage;
import org.springframework.data.repository.CrudRepository;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface PersonnageRepository extends CrudRepository<Personnage, Integer> {

}