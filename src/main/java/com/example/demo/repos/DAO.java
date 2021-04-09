package com.example.demo.repos;
import com.example.demo.models.Kompis;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


/**
 * Created by Jacaranda Perez
 * Date: 2021-04-08
 * Project: SpringInitializrDemo
 */

public class DAO {

    public List<Kompis> getAllKompisar(){
        Kompis juan = new Kompis(1, "Juan", "Madrid", "423898672");
        Kompis maria = new Kompis(2, "Maria", "Mexico", "723898672");
        Kompis jose = new Kompis(3, "Jose", "Sydney", "823898672");
        Kompis anna = new Kompis(4, "Anna", "Beirut", "423898672");
        Kompis julia = new Kompis(5, "Julia", "Ohio", "623898672");
        LinkedList<Kompis> minaKompisar =  new LinkedList<>();
        minaKompisar.add(juan);
        minaKompisar.add(maria);
        minaKompisar.add(jose);
        minaKompisar.add(anna);
        minaKompisar.add(julia);

        return minaKompisar;
    }

}
