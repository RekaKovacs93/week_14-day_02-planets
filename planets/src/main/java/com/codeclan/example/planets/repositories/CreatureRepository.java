package com.codeclan.example.planets.repositories;

import com.codeclan.example.planets.models.Creature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreatureRepository extends JpaRepository<Creature, Long> {
}
