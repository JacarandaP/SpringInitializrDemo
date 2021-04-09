package com.example.demo.controllers;

import com.example.demo.models.Kompis;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


@RestController
public class HelloWorldController {

    @RequestMapping("/")
    public String index() {
        return "Hello world!";
    }

    @RequestMapping("/hej")
    //Skickar parameter som kan vara null
    public String hej(@RequestParam(required = false) String name) {
        if (name == null) return "Hello World";
        return "hello + name";

        //localhost:8080/hej?hame=Sigrun
    }

    @RequestMapping("/hej2")
    //Skickar parameter som kan default
    public String hej2(@RequestParam(defaultValue = "Sigrun") String name) {
        if (name == null) return "Hello World";
        return "hello world + name";

        //localhost:8080/hej?name=Sigrun
    }

    @RequestMapping("/hej3")
    public String hej3(@RequestParam String name,
                       @RequestParam String lastname) {
        if (name == null) return "Hello World";
        return "helloW + name" + "" + lastname;

        //localhost:8080/hej2?firstname=Elvis&lastname=Presley
    }

    public int getNumber() {
        int min = 1;
        int max = 2;

        Random random = new Random();
        int number = random.nextInt(max + min) + min;
        return number;
    }

    public String getAnimal() {
        List<String> animals = Arrays.asList("katt", "hund", "spindel", "skata");
        Random random = new Random();
        String randomAnimal = animals.get(random.nextInt(animals.size()));
        System.out.println(randomAnimal);
        return randomAnimal;

    }

    @RequestMapping("/lucky")
    public String lucky(@RequestParam String luckyYou) {
        String response = "hej";
        if (luckyYou.equals("animal")) {
            response = getAnimal();
            return response;

        } else if (luckyYou.equals("number")) {
            response = String.valueOf(getNumber());
            return response;

        }
        return response;
    }

    @RequestMapping("/luckyOptionals")
    public String luckyOptionals(@RequestParam String luckyYou, @RequestParam(required = false) String firstname) {
        String response = "hej";
        if (luckyYou.equals("animal")) {
            response = getAnimal();
            return firstname + "your lucky animal is " + response;
        } else if (firstname == null) {
            response = getAnimal();
            return "your lucky animal is" + response;
        } else if (luckyYou.equals("number")) {
            response = String.valueOf(getNumber());
            return firstname + "your lucky number is " + response;
        } else if (firstname == null) {
            response = getAnimal();
            return "your lucky number is " + response;
        }
        return response;
    }


    @RequestMapping("/hej4")
    public String hej4(@RequestParam List<String> names) {
        return "hello" + names;
        //Två sätt att få samma resultat:
        //localhost:8080/hej4?names=sigrun&names=maria&names=luna
        //localhost:8080/hej4?names=sigrun,maria,names,luna
    }

    //Path parametrar
    //localhost:8080/hejPathParam/sigrun
    @RequestMapping("/hejPathParam/{name}")
    public String hejPathParam(@PathVariable String name) {
        return "hello " + name;
    }




}