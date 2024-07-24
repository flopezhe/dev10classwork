// let first = `first word`;
// let second = 'second word';
// let last = "last word";

// console.log(`${first} plus ${second} plus ${last}`)


console.log(`hello world`);


function countStr(string){

    let num = 0;
    for(let i = 0; i < string.length; i++){
        num++
    }

    return num;
}

let string = "test";

console.log(countStr(string));