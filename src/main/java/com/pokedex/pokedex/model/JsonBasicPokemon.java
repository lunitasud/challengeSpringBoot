package com.pokedex.pokedex.model;

public class JsonBasicPokemon {
    String type="";
    String name="";
    Double weight=0.0;
    String ability;
    String Description;
    String evolutions[];

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

    public String getAbility() {
        return ability;
    }

    public void setAbility(String ability) {
        this.ability = ability;
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
