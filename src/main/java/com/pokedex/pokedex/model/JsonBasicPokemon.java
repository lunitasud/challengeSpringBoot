package com.pokedex.pokedex.model;
public class JsonBasicPokemon {


    Integer  id=0;
    String type="";
    String name="";
    Double weight=0.0;

    String abilities[];
    String Description;
    String evolutions[];

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {        this.id = id;    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String[] getAbilities() {
        return abilities;
    }

    public void setAbilities(String[] abilities) {
        this.abilities = abilities;
    }
    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String[] getEvolutions() {
        return evolutions;
    }

    public void setEvolutions(String[] evolutions) {
        this.evolutions = evolutions;
    }



}
