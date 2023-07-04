// import logo from './logo.svg'
import './App.css';
import React from 'react';
import { useState, useEffect } from 'react';

function App() {

  const [planets, setPlanets] = useState([]);
  const [planetName, setPlanetName] = useState("")
  const [species, setSpecies] = useState([])
  const [creatures, setCreatures] = useState([]);
  // // const [googleLoaded, setGoogleLoaded] = useState(false)

  useEffect(() => {
    getPlanets();
    getCreatures();
    getSpecies();
}, [])

  const getPlanets = function(){
  fetch("http://localhost:8080/planets")
  .then((res) => {
      if (res.ok) {
        return res.json();
      } else {
        throw new Error("Failed to fetch data");
      }
    })
  .then((data) => {
      setPlanets(data);
    })
}


const getSpecies = function(){
fetch("http://localhost:8080/species")
.then((res) => {
    if (res.ok) {
      return res.json();
    } else {
      throw new Error("Failed to fetch data");
    }
  })
.then((data) => {
    setSpecies(data);
  })
}

const getCreatures = function(){
fetch("http://localhost:8080/creatures")
.then((res) => {
    if (res.ok) {
      return res.json();
    } else {
      throw new Error("Failed to fetch data");
    }
  })
.then((data) => {
    setCreatures(data);
  })
}
const listPlanets = planets.map((planet) => (
    <p>{planet.name}</p>
)) 
const listSpecies = species.map((species) => (
  <p>{species.name}</p>
)) 
const listCreatures = creatures.map((creature) => (
  <p>{creature.name}</p>
)) 
const savePlanet = (evt) => {
  evt.preventDefault();
  const newPlanet = { id: Date.now(), name: planetName}
  const planetListCopy = [...planets, newPlanet]
  setPlanets(planetListCopy)
  setPlanetName("")
}
const handlePlanetInput = (evt) => {
  setPlanetName(evt.target.value);
}



  return (
    <div className="App">
    <form action='post' onSubmit={savePlanet}>
    <label htmlFor="new-planet">Add a new planet:</label>
    <input id="new-todo" type="text" onChange={handlePlanetInput} value={planetName} />
    <input type="submit" value="Save" className="save-button" />
    </form>
    <h1>Planets</h1>
      {listPlanets}
      <h1>Species</h1>
      {listSpecies}
      <h1>Creatures</h1>
      {listCreatures}
    </div>
  );
}

export default App;
