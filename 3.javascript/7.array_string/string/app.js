novel = 'The Little Prince';
const author = 'Saint-Exupery';

// 템플릿 리터럴(Template literal) 방식
console.log(`My favorite nobel is ${novel} 
by ${author}.`); // 변수 동적 바인딩, 줄바꿈 가능

const address =
  'Homer J. Simpson\n' +
  '742 Evergreen Terrace\n' +
  'Springfield';

console.log(address);

const address2 = `Homer J. Simpson
                 742 Evergreen Terrace
                 Springfield`;

console.log(address2);


// 문자열을 생성하는 방법 2가지
// 1. 문자열 리터럴로 생성
const stringPrimitive = 'A new String';
console.log(stringPrimitive);

// 2. 생성자를 통해 생성
const stringObject = new String('A new String');
console.log(stringObject);

console.log(`${typeof stringPrimitive}, ${typeof stringObject}`);

const aString = 'How are you?';
console.log('01234567891011');
console.log('   ',aString[4]);

console.log(aString.charAt(4)); // 내가 원하는 문자 char At 인덱스번호

console.log(aString.indexOf('o'));
console.log(aString.lastIndexOf('o'));

console.log(aString.slice(8, 11));
console.log(aString.length);

// Splitting strings
const originalString = "How are you?";

// Split string by whitespace character
const splitString = originalString.split(" ");

console.log(splitString, Array.isArray(splitString)); 
console.log(splitString[1]);

// Trimming Whitespace
const tooMuchWhitespace = "     How are you?     ";

const trimmed = tooMuchWhitespace.trim();

console.log(trimmed);

// Finding and Replacing String values

// Replace the first instance of "How" with "Where"
const newString = originalString.replace("How", "Where");

console.log(newString);