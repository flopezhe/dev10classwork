'use strict';

// prompt-sync exports a create function
const createPrompt = require('prompt-sync');
// create a new prompt function with the create function.
const prompt = createPrompt();

function playGame() {
  console.log('There are three doors labeled 1-3.');

  let winningDoor = Math.floor(Math.random()+1)*3;
  let goatDoor1, goatDoor2;

  do {
    goatDoor1 = Math.floor(Math.random() * 3) + 1;
  } while (goatDoor1 === winningDoor);
  
  do {
    goatDoor2 = Math.floor(Math.random() * 3) + 1;
  } while (goatDoor2 === winningDoor || goatDoor1 === goatDoor2);
  

  
  console.log(winningDoor);
  console.log(goatDoor1);
  console.log(goatDoor2);
  let choice = prompt("Do you want to switch doors?")
  let door = prompt('Which do you choose?');
  if(door == "3" || door == "2" || door =="1"){
    console.log(`You chose door # ${door}`);
    if(door==winningDoor){
        console.log(`You win!`)
    } else{
        console.log(`you lose!`)
    }
  } else {
    console.log(`Invalid door`)
  }

}

playGame();
