package com.codeclan.example.planets.controllers;

import com.codeclan.example.planets.models.Creature;
import com.codeclan.example.planets.models.Planet;
import com.codeclan.example.planets.repositories.CreatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class CreatureController {

    @Autowired
    CreatureRepository creatureRepository;

    @GetMapping(value = "/creatures")
    public List<Creature> getAllCreatures(){
        return creatureRepository.findAll();
    }
    @GetMapping(value = "/creatures/{id}")
    public Optional<Creature> getPlanetById(@PathVariable Long id){
        return creatureRepository.findById(id);
    }
}
