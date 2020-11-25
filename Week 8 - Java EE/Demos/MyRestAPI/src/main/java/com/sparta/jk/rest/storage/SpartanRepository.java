package com.sparta.jk.rest.storage;

import com.sparta.jk.rest.entities.Spartan;

import javax.inject.Named;
import java.util.HashMap;

@Named
public class SpartanRepository {
    HashMap<Integer, Spartan> spartans = new HashMap<>();
    {
        Spartan spartan1 = new Spartan("Manish", "Gadhvi", "Java Dev");
        Spartan spartan2 = new Spartan("Astha", "Shaw", "Java Dev");
        Spartan spartan3 = new Spartan("Richard", "Gurney", "All");
        Spartan spartan4 = new Spartan("Manish", "Gurney", "All");
        spartans.put(1, spartan1);
        spartans.put(2, spartan2);
        spartans.put(3, spartan3);
        spartans.put(4, spartan4);
    }

    public Spartan getSpartan(Integer id){
        return spartans.get(id);
    }

    public HashMap<Integer, Spartan> getAllSpartans() {
        return spartans;
    }
}
