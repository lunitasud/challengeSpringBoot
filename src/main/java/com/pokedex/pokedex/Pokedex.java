package com.pokedex.pokedex;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pokedex.pokedex.model.JsonBasicPokemon;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class Pokedex{


    public static void main(String[] args) {
        String pokemon = "";
        String pokemon_desc = "";
        String URL = "https://pokeapi.co/api/v2/pokemon/pikachu";
        String URL_description = "https://pokeapi.co/api/v2/characteristic/";
        JsonBasicPokemon jbp = new JsonBasicPokemon();
        ObjectMapper mapper = new ObjectMapper();
        try {
            /*get the information of pokemon services*/
            pokemon = getHTML(URL);
            JSONObject json_ini = new JSONObject(pokemon);
            jbp.setWeight(json_ini.getDouble("weight"));
            jbp.setType(json_ini.getString("type"));
            jbp.setWeight(json_ini.getDouble("weight"));
            System.out.println(jbp.getType());

            JSONArray  forms =  new JSONArray(json_ini.getString("forms"));
            jbp.setName(forms.getJSONObject(0).getString("name"));

            System.out.println("pokemon: "+jbp.getName());

            pokemon_desc = getHTML(URL_description+json_ini.getString("id"));
            JSONObject json_desc = new JSONObject(pokemon_desc);
            jbp.setDescription(json_desc.getString("descriptions"));
           // System.out.println(json_desc.getString());
        }catch (Exception e) {
            pokemon = e.toString();
        }

    }

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

}
