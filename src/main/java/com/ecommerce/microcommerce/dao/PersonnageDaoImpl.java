package com.ecommerce.microcommerce.dao;

import com.ecommerce.microcommerce.model.Personnage;
import org.springframework.stereotype.Repository;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


import java.util.List;
import java.util.ArrayList;

@Repository
@EnableSwagger2
public class PersonnageDaoImpl implements PersonnageDao {

    public static List<Personnage> ListeTousPersonnages = new ArrayList<Personnage>();

    static {
        ListeTousPersonnages.add(new Personnage(1, "Marcel", "Barde"));
        ListeTousPersonnages.add(new Personnage(2, "Franck", "Druide"));
        ListeTousPersonnages.add(new Personnage(3, "Denis", "Moine"));
    }

    private int counter = 4;

    @Override
    public List<Personnage> findAll() {
        return ListeTousPersonnages;
    }

    @Override
    public Personnage findById(int id) {

        Personnage personnageRet = null;


        for (Personnage personnage : ListeTousPersonnages) {
            if (personnage.getId() == id) {
                personnageRet = personnage;
            }
        }
        return personnageRet;
    }

    @Override
    public Personnage save(Personnage personnage) {
        Personnage newPersonnage = new Personnage(counter++, personnage.getName(), personnage.getClasse());
        ListeTousPersonnages.add(newPersonnage);
        return newPersonnage;
    }

    @Override
    public Personnage update(int id, Personnage input) {
        Personnage putPersonnage = findById(id);

        if (putPersonnage != null) {
            putPersonnage.setName(input.getName());
            putPersonnage.setClasse(input.getClasse());
        }
        return putPersonnage;
    }

    /*

    public Personnage save1(Personnage personnage) {
        Personnage personnageToUpdate = findById(personnage.getId());
        if (personnageToUpdate != null) {
            ListeTousPersonnages.set(ListeTousPersonnages.indexOf(personnageToUpdate), personnage);
        }
        ListeTousPersonnages.add(personnage);
        return personnage;
    }

     */

    @Override
    public boolean delete(int id) {
        Boolean isDeleted = false;
        Personnage removePersonnage = findById(id);

        if (removePersonnage != null) {
            ListeTousPersonnages.remove(removePersonnage);
            isDeleted = true;
        }
        return removePersonnage != null;
    }

}

