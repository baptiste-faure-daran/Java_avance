package com.ecommerce.microcommerce.dao;
import com.ecommerce.microcommerce.model.Personnage;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.ArrayList;

@Repository
public class PersonnageDaoImpl implements PersonnageDao{

    public static List<Personnage>ListeTousPersonnages =new ArrayList<Personnage>();
    static {
        ListeTousPersonnages.add(new Personnage(1, "Jean Malick", "Sorcier"));
        ListeTousPersonnages.add(new Personnage(2, "Anne Lucille", "Guerrier"));
        ListeTousPersonnages.add(new Personnage(3, "Macille", "Sorcier"));
    }


    @Override
    public List<Personnage> findAll() {
       return ListeTousPersonnages;
   }

   @Override
    public Personnage findById(int id) {
        for (Personnage personnage : ListeTousPersonnages){
            if (personnage.getId() == id) {
                return personnage;
            }
        }
       return null;
   }

   @Override
   public void save(Personnage personnage) {
        ListeTousPersonnages.add(personnage);
   }


    public void delete(int id) {
        Personnage removePersonnage = findById(id);
        if (removePersonnage != null) {
            ListeTousPersonnages.remove(removePersonnage);
        }

   }
}

