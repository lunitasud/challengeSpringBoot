package com.pokedex.pokedex.controllers;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pokedex.pokedex.Pokedex;
import com.pokedex.pokedex.model.JsonBasicPokemon;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PokedexController {
    JsonBasicPokemon pokemon = new JsonBasicPokemon();
    String URL = "";
    JSONObject json_ini ;
    Pokedex pkdx = new Pokedex();
    ObjectMapper mapper = new ObjectMapper();


    // pokemon API data return service that validates as a parameter the id or name of the referenced pokemon.
    @RequestMapping(value = "pokemon-api/{param}")
    public String pokemon_desc(@PathVariable String param) throws Exception {
        URL = "https://pokeapi.co/api/v2/pokemon/" + param;
        String resulset = pkdx.getHTML(URL);
        json_ini = new JSONObject(resulset);
        String step =json_ini.getString("id");
        if (step != "") {
            return resulset;
        } else {
            return "No existe el pokemon que buscas!";
        }
    }
    // service that return the image url of pokemon selected
    @RequestMapping(value = "poke-img-url/{param}")
    public String pokemon_image_url(@PathVariable  String param) throws Exception {
        URL = "https://pokeapi.co/api/v2/pokemon/"+param;
        String resulset = pkdx.getHTML(URL);
        json_ini = new JSONObject(resulset);
        String step =json_ini.getString("sprites");
        json_ini = new JSONObject(step);
        step = json_ini.getString("other");
        json_ini = new JSONObject(step);
        step = json_ini.getString("official-artwork");
        json_ini = new JSONObject(step);
        step = json_ini.getString("front_default");
        return step;
    }
    //get description of pokemon
    @RequestMapping(value = "poke-desc/{param}")
    public String pokemon_description(@PathVariable String param) throws Exception {
        URL = "https://pokeapi.co/api/v2/characteristic/"+param;
        String resultdesc = pkdx.getHTML(URL);
        json_ini = new JSONObject(resultdesc);
        return resultdesc;
    }

    @RequestMapping(value = "pokevolution/{param}")
    public String pokemon_evolution(@PathVariable String param) throws Exception {
        URL = "https://pokeapi.co/api/v2/evolution-chain/" + param;
        String result_ev = pkdx.getHTML(URL);
        json_ini = new JSONObject(result_ev);
        return result_ev;
    }


    @RequestMapping(value = "pokemondata/{param}")
    public String pokemon_data(@PathVariable String param) throws Exception {
        JSONArray forms ;
        URL = "https://pokeapi.co/api/v2/pokemon/" + param;
        String resulset = pkdx.getHTML(URL);
        json_ini = new JSONObject(resulset);
        pokemon.setId(json_ini.getInt("id"));
        pokemon.setType(json_ini.getString("type"));
        forms =  new JSONArray(json_ini.getString("forms"));
        for (int i = 0; i < forms.length(); i++) {
            try {
                JSONObject jsonObject = forms.getJSONObject(i);
                if (jsonObject.has("name")) {
                    String value = jsonObject.getString("name");
                    pokemon.setName(value);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        pokemon.setWeight(json_ini.getDouble("weight"));
        String json = mapper.writeValueAsString(pokemon);
        return json;
    }


}
