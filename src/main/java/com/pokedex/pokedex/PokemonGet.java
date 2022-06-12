package com.pokedex.pokedex;

import com.pokedex.pokedex.model.JsonBasicPokemon;

import org.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;


public class PokemonGet {

    public static void main(String[] args) {
        String pokemon = "";
        String pokemon_desc = "";
        String URL = "https://pokeapi.co/api/v2/pokemon/pikachu";
        String URL_description = "https://pokeapi.co/api/v2/characteristic/";
        JsonBasicPokemon jbp = new JsonBasicPokemon();
        try {
            /*get the information of pokemon services*/
            pokemon = getHTML(URL);
            JSONObject json_ini = new JSONObject(pokemon);

            /*Asign data to pokemon propierties*/
            jbp.setType(json_ini.getString("type"));
            jbp.setName(json_ini.getString("name"));
            jbp.setWeight(json_ini.getDouble("weight"));
            jbp.setAbility(json_ini.getString("abilities"));

            //get pokemon description by id
            pokemon_desc = getHTML(URL_description+json_ini.getString("id"));
            JSONObject json_desc = new JSONObject(pokemon_desc);
            jbp.setDescription(json_desc.getString("descriptions"));
            System.out.println(jbp.getType());
            //System.out.println(json_desc.getString());
        }catch (Exception e) {
            pokemon = e.toString();
        }

    }

    /*Method for execute request*/
    public static String getHTML(String urlToRead) throws Exception {
        StringBuilder result = new StringBuilder();
        URL url = new URL(urlToRead);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(conn.getInputStream()))) {
            for (String line; (line = reader.readLine()) != null; ) {
                result.append(line);
            }
        }
        return result.toString();
    }

    //metodo para recibir nombre del pokemon desde front
}
