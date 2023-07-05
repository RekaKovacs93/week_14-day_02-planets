package com.codeclan.example.planets.controllers;

import com.codeclan.example.planets.models.Species;
import com.codeclan.example.planets.repositories.SpeciesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class SpeciesController {

    @Autowired
    SpeciesRepository speciesRepository;

    @GetMapping(value = "/species")
    public List<Species> getAllSpecies(){
        return speciesRepository.findAll();
    }

    @GetMapping(value = "/species/{id}")
    public Optional<Species> getSpeciesById(@PathVariable Long id){
        return speciesRepository.findById(id);
    }
}
