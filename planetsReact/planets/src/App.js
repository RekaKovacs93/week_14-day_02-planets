// import logo from './logo.svg'
import './App.css';
import React from 'react';
import { useState, useEffect } from 'react';

function App() {

  const [planets, setPlanets] = useState([]);
  const [creatureName, setCreatureName] = useState("")
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

const postCreature = (payload) => {
    return fetch ( "http://localhost:8080/creatures", {
        method: 'POST',
        body: JSON.stringify(payload),
        headers: { 'Content-Type': 'application/json' }
    })
    .then(res => res.json())
}


const listPlanets = planets.map((planet) => (
    <p>{planet.name}</p>
)) 

const listSpecies = species.map((species) => (
  <div>
  <h3>{species.planet.name}</h3>
  <li>{species.name}</li>
  </div>
)) 
const listCreatures = creatures.map((creature) => (
  <div>
  {/* <h3>{creature.species.planet.name}</h3> */}
  <h1>{creature.name} :</h1>
  <h3>Species</h3>
  <li>{creature.species.name}</li>
  <h3>Planet</h3>
  <li>{creature.species.planet.name}</li>
  </div>
)) 
const saveCreature = () => {
  const newCreature = { id: Date.now(), name: creatureName}
  const creatureListCopy = [...creatures, newCreature]
  setCreatures(creatureListCopy)
  setCreatureName("")
}
const handleCreatureInput = (evt) => {
  setCreatureName(evt.target.value);
  postCreature(creatureName)
    .then((data) => {saveCreature(data)})
}



  return (
    <div className="App">
    <form action='post' onSubmit={saveCreature}>
    <label htmlFor="new-creature">Add a new creature:</label>
    <input id="new-creature" type="text" onChange={handleCreatureInput} value={creatureName} />
    <input type="submit" value="Save" className="save-button" />
    </form>
      {/* <h1>Planets</h1> */}
      {/* {listSpecies} */}
      {/* <h1>Species</h1>
      {listSpecies} */} 
      {/* <h1>Creatures</h1> */}
      {listCreatures}
    </div>
  );
}

export default App;
