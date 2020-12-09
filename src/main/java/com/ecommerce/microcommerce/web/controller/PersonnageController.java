package com.ecommerce.microcommerce.web.controller;

import com.ecommerce.microcommerce.dao.PersonnageDao;
import com.ecommerce.microcommerce.model.Personnage;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
public class PersonnageController {

    @Autowired
    private PersonnageDao IPersonnageDao;

    //Récupérer la liste des personnages
    @ApiOperation(value = "Récupère tous les personnages existants")
    @RequestMapping(value = "/personnages", method = RequestMethod.GET)
    public List<Personnage> ListePersonnages() {

        return IPersonnageDao.findAll();

    }

    //Récupérer un personnage par son Id
    @ApiOperation(value = "Récupère un personnage grâce à son ID à condition que celui-ci existe!")
    @GetMapping(value = "/personnages/{id}")
    public Personnage AfficherPersonnageParId(@PathVariable int id) {

        return IPersonnageDao.findById(id);

    }

    //Permet d'ajouter un nouveau personnage
    @ApiOperation(value = "Permet l'ajout d'un nouveau personnage à la liste")
    @PostMapping(value = "/personnages")
    public void AjouterPersonnage(@RequestBody Personnage personnage) {
        IPersonnageDao.save(personnage);
    }

    //Supprimer un personnage par son Id
    @ApiOperation(value = "Supprime un personnage en se basant sur son ID")
    @RequestMapping(value = "/personnages/{id}/supprimer", method = RequestMethod.DELETE)

    public void SupprimerPersonnageParId(@PathVariable int id) {
        IPersonnageDao.delete(id);
    }

}
