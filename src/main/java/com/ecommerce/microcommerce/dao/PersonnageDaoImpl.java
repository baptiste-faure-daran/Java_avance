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
    public List<Personnage>FindAll() {
       return ListeTousPersonnages;
   }

   @Override
    public Personnage PersonnageFindById(int id) {
        for (Personnage personnage : ListeTousPersonnages){
            if (personnage.getId() == id) {
                return personnage;
            }
        }
       return null;
   }

   @Override
    public Personnage PersonnageSave(Personnage personnage) {
        ListeTousPersonnages.add(personnage);
       return personnage;
   }


}

