// console.log(`Hello World`);




// word.addEventListener('click', isPalindrome);

function isPalindrome() {
  const word = document.getElementById('palindromeWord');
  const result = "test" ;
  let palindrome = true;

  for (i = 0; i < word.length / 2; i++) {
  
    if (word[i] !== word[word.length - 1 - i]) {
      palindrome = false;
    }
  
  }
  console.log(palindrome);

}