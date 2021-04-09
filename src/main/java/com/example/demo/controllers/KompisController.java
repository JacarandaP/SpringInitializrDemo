package com.example.demo.controllers;

import com.example.demo.models.Kompis;
import com.example.demo.models.Response;
import com.example.demo.repos.DAO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//CRUD=     create, read, update, delete
@RestController
public class KompisController {
    DAO db = new DAO();
    List<Kompis> minaKompisar = db.getAllKompisar();


    @RequestMapping("/kompisar")
    public  List<Kompis> getKompisar() {
        return minaKompisar;
    }

    @RequestMapping("/kompis/{id}")
    public Kompis getKompisById(@PathVariable int id) {
        Kompis chosenOne = new Kompis();
        for(Kompis k: minaKompisar){
            if(k.getId()==id){
                chosenOne = k;
            }
        }
        return chosenOne;
    }

    @RequestMapping("/oneKompisJSON")
    public Kompis oneKompisJSON(){
        return new Kompis(6, "Rudolf", "Tokyo", "89662");
    }

    /*
    @RequestMapping("/kompisarhtml")
    public  List<Kompis> getKompisarhtml() {
        String everyone="";
        List<Kompis> kompisarna = getKompisar();
        for(int i = 0; i < kompisarna.size(); i++){
            everyone = kompisarna.get(i).getNamn() + "phone" + kompisarna.get(i).getPhone();
        }
        return "minaKompisar;
    }*/

    @RequestMapping("/kompis/{id}/delete")
    public Response deleteKompisById(@PathVariable("id") int id) {
        Response res = new Response("Person unfriended", Boolean.FALSE);
        int unfriend = -1;
        for(int i = 0; i < minaKompisar.size(); i ++){
            if(minaKompisar.get(i).getId() == id){
                unfriend = i;
            }
        }
        if(unfriend != -1){
            minaKompisar.remove(unfriend);
            res.setStatus(Boolean.TRUE);

        }
        return res;
    }

    @PostMapping("/kompis/add")
    public Response addKompis(@RequestBody Kompis b){
        System.out.println(b.getId() + "" + b.getNamn());
        Response res = new Response("Kompis added", Boolean.FALSE);
        minaKompisar.add(b);
        res.setStatus(Boolean.TRUE);
        return res;
    }

    @PostMapping ("/kompis/update")
    public Response upsertKompis(@RequestBody Kompis b){
        Response res = new Response("Kompis updated", Boolean.FALSE);

        int indexToUpdate = -1;
        for (int i = 0; i < minaKompisar.size(); i++){
            if (minaKompisar.get(i).getId() == b.getId()){
                indexToUpdate = i;
            }
        }

        if (indexToUpdate == -1){
            minaKompisar.add(b);
            res.setMessage("Kompis inserted");
            res.setStatus(Boolean.TRUE);
        }
        else{
            minaKompisar.set(indexToUpdate, b);
            res.setStatus(Boolean.TRUE);
        }
        return res;
    }



}
