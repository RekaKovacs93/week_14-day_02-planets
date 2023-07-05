package com.codeclan.example.planets.controllers;

import com.codeclan.example.planets.models.Planet;
import com.codeclan.example.planets.repositories.PlanetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PlanetController {

    @Autowired
    PlanetRepository planetRepository;

    @GetMapping(value = "/planets")
    public List<Planet> getAllPlanets(){
        return planetRepository.findAll();
    }

    @GetMapping(value = "/planets/{id}")
    public Optional<Planet> getPlanetById(@PathVariable Long id){
        return planetRepository.findById(id);
    }

    @PostMapping(value = "/planets")
    public ResponseEntity<Planet> postPirate(@RequestBody Planet planet){
        planetRepository.save(planet);
        return new ResponseEntity<>(planet, HttpStatus.CREATED);
    }

}
