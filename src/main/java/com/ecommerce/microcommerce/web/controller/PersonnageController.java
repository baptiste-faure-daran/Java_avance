package com.ecommerce.microcommerce.web.controller;

import com.ecommerce.microcommerce.dao.PersonnageDao;
import com.ecommerce.microcommerce.model.Personnage;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
public class PersonnageController {

    @Autowired
    private PersonnageDao IPersonnageDao;

    //Récupérer la liste des personnages
    @ApiOperation(value = "Récupère tous les personnages existants")
    @RequestMapping(value = "/personnages", method = RequestMethod.GET)
    public ResponseEntity<List<Personnage>> DisplayPersonnage() {
        return new ResponseEntity<>(IPersonnageDao.findAll(), HttpStatus.OK);
    }

    //Récupérer un personnage par son Id
    @ApiOperation(value = "Récupère un personnage grâce à son ID à condition que celui-ci existe!")
    @GetMapping(value = "/personnages/{id}")
    public ResponseEntity<Personnage> DisplayById(@PathVariable("id") int id) {

        Personnage response = IPersonnageDao.findById(id);

        if (response != null) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    //Permet d'ajouter un nouveau personnage
    @ApiOperation(value = "Permet l'ajout d'un nouveau personnage à la liste")
    @PostMapping(value = "/personnages")
    public ResponseEntity<Personnage> CreatePerson(@RequestBody Personnage personnageInput) {
        return new ResponseEntity<>(IPersonnageDao.save(personnageInput), HttpStatus.OK);
    }


    //Permet de modifier un personnage existant
    @ApiOperation(value = "Permet de modifier un personnage existant")
    @RequestMapping(value = "/personnages", method = RequestMethod.PUT)
    public ResponseEntity<Personnage> Update(@PathVariable int id, @RequestBody Personnage personnageInput) {

        Personnage response = IPersonnageDao.findById(id);

        if (response != null) {
            response = IPersonnageDao.update(id, personnageInput);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }


    //Supprimer un personnage par son Id
    @ApiOperation(value = "Supprime un personnage en se basant sur son ID")
    @RequestMapping(value = "/personnages/{id}/supprimer", method = RequestMethod.DELETE)
    public ResponseEntity<Void> Delete(@PathVariable int id) {
        Boolean PersonageDelete = IPersonnageDao.delete(id);

        if (PersonageDelete) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
