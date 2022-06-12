package com.pokedex.pokedex.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

@RequestMapping(value = "pokemonData")
public class PokedexController {

    public List<String> pokemon_data(){
        return List.of("1",
                "ditto",
                "imagen",
                "23",
                "descripcion del pokemon ditto");
    }
}
