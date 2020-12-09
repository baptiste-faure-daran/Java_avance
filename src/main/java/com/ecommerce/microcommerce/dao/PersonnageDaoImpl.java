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


    @Override
    public List<Personnage> findAll() {
        return ListeTousPersonnages;
    }

    @Override
    public Personnage findById(int id) {
        for (Personnage personnage : ListeTousPersonnages) {
            if (personnage.getId() == id) {
                return personnage;
            }
        }
        return null;
    }

    @Override
    public Personnage save(Personnage personnage) {
        // Try Catch
        Personnage personnageToUpdate = findById(personnage.getId());
        if (personnageToUpdate != null) {
            ListeTousPersonnages.set(ListeTousPersonnages.indexOf(personnageToUpdate), personnage);
        }
        ListeTousPersonnages.add(personnage);
        return personnage;
    }

    @Override
    public void delete(int id) {
        Personnage removePersonnage = findById(id);
        if (removePersonnage != null) {
            ListeTousPersonnages.remove(removePersonnage);
        }
    }

}

