package com.codeclan.example.planets.other;

import com.codeclan.example.planets.models.Creature;
import com.codeclan.example.planets.models.Planet;
import com.codeclan.example.planets.models.Species;
import com.codeclan.example.planets.repositories.CreatureRepository;
import com.codeclan.example.planets.repositories.PlanetRepository;
import com.codeclan.example.planets.repositories.SpeciesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("!test")
//@Component

public class DataLoader implements ApplicationRunner {

    @Autowired
    PlanetRepository planetRepository;

    @Autowired
    SpeciesRepository speciesRepository;

    @Autowired
    CreatureRepository creatureRepository;

    public DataLoader(){};

    public void run(ApplicationArguments args){
        Planet sontar = new Planet("Mars");
        planetRepository.save(sontar);
        Planet raxacoricofallapatorius = new Planet("Raxacoricofallapatorius");
        planetRepository.save(raxacoricofallapatorius);
        Planet earth = new Planet("Earth");
        planetRepository.save(earth);

        Species sontaran = new Species("Sontaran", sontar);
        speciesRepository.save(sontaran);
        Species sletheen = new Species("Sletheen", raxacoricofallapatorius);
        speciesRepository.save(sletheen);
        Species human = new Species("Human", earth);
        speciesRepository.save(human);
        Species slug = new Species("Slug", earth);
        speciesRepository.save(slug);

        Creature strax = new Creature("Strax", sontaran, "brown");
        creatureRepository.save(strax);
        Creature stacy = new Creature("Stacy", sontaran, "purple");
        creatureRepository.save(stacy);
        Creature jocrassa = new Creature("Jocrassa", sletheen, "black");
        creatureRepository.save(jocrassa);
        Creature blon = new Creature("Blon", sletheen, "Not so black");
        creatureRepository.save(blon);
        Creature dave = new Creature("Dave", human, "green");
        creatureRepository.save(dave);
        Creature ann = new Creature("Ann", human, "blue");
        creatureRepository.save(ann);
        Creature sluggy = new Creature("Sluggy", slug, "i don't know");
        creatureRepository.save(sluggy);
        Creature slugsie = new Creature("Slugsie", slug, "no idea");
        creatureRepository.save(slugsie);

    }
}
