package com.ecommerce.microcommerce.web.controller;

import com.ecommerce.microcommerce.dao.PersonnageDao;
import com.ecommerce.microcommerce.model.Personnage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class PersonnageController {


    @Autowired
    private PersonnageDao IPersonnageDao;

    //Récupérer la liste des personnages
    @RequestMapping(value="/personnages", method= RequestMethod.GET)
    public List<Personnage> ListePersonnages () {

        return IPersonnageDao.FindAll();

    }

    //Récupérer un personnage par son Id
    @GetMapping(value="/personnages/{id}")
    public Personnage AfficherPersonnageParId(@PathVariable int id) {


        return IPersonnageDao.PersonnageFindById(id);

    };

}
