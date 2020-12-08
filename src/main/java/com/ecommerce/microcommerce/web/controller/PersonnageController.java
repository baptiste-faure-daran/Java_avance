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

        return IPersonnageDao.findAll();

    }

    //Récupérer un personnage par son Id
    @GetMapping(value="/personnages/{id}")
    public Personnage AfficherPersonnageParId(@PathVariable int id) {

        return IPersonnageDao.findById(id);

    };

    @PostMapping(value = "/personnages")
    public void AjouterPersonnage(@RequestBody Personnage personnage) {
        IPersonnageDao.save(personnage);
    }

    //Supprimer un personnage par son Id
    @RequestMapping(value = "/personnages/{id}/supprimer", method = RequestMethod.DELETE)

    public void SupprimerPersonnageParId(@PathVariable int id) {
        IPersonnageDao.delete(id);
    }

}
