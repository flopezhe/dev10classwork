// let first = `first word`;
// let second = 'second word';
// let last = "last word";

// console.log(`${first} plus ${second} plus ${last}`)


// console.log(`hello world`);


// function countStr(string){

//     let num = 0;
//     for(let i = 0; i < string.length; i++){
//         num++
//     }

//     return num;
// }

// let string = "test";

// console.log(countStr(string));

// function printNumbers(from, to) {
//     console.log(`Printing numbers from ${from} to ${to}...`);
  
//     for (let i = from; i <= to; i++) {
//       console.log(i);
//     }
//   }
  
//   printNumbers(1, 5);
//   printNumbers(10, 15);
//   printNumbers(20, 25);

// let a1 = ["word"];
// a1.push("test");
// a1.push("etc ");
// a1.push["aweaeweaw"];
// a1.push(2);
// a1.push(false);
// a1[0] = 1232;

// function randomBlah(elem, index, arr){
//     console.log(elem, index, arr );
// }

// let word = a1.find(elem => elem.startsWith(1));
// console.log(word);

// for (const c of a1){
//     console.log`${c}`;
// }

// function infoGather(blah, index){
//     console.log(blah,index);
// }
// a1.forEach(infoGather);
// console.log(a1.find(Number));
// console.log(a1)

// const colors = ["red", "blue", "yellow", false];


// // the predicate accepts a value, an array element,
// // the element's index (optional)
// // and the source array (optional)
// function hasLengthFour(elem, index, srcArray) {
//   console.log(elem, index, srcArray);
//   return elem.length == 4;
// }

// // find ----------------------

// // returns the first element with a length of 4.
// let color = colors.find(hasLengthFour);
// console.log(color); // blue

// color = colors.find(elem => elem.startsWith("y"));
// console.log(color); // yellow

// const random = ["random", "aweawe" , "aeae" , "waooo"];

// let newRandom = random.map(r => r.toUpperCase());

// console.log(newRandom);

// let car = {};

// car.year = 2024;
// car.make = "Chevy";
// car.model = "Activ Trax";
// car.parts = ["wheels", "breaks", "engine", "seats"]
// car.getDescription = function(){
//     return `CAR ${this.make} has ${this.parts.length} parts`;
// }
// console.log(car.getDescription());
// let capsules = [];


const str = `{"name": "word"}`;

let func = JSON.parse(str);

console.log(func);
