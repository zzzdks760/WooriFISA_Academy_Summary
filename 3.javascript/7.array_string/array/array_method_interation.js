// forEach()
console.group('forEach()');
let fish = ['shark', 'whale', 'koi', 'nimo', 'defense'];

// fish.forEach(item => {
//     console.log(item);
// })

fish.forEach((item, index) => console.log(item, index)); // function body가 한 줄이기 때문에 { } 생략 가능.
console.groupEnd();

// map() : 배열의 각 요소들을 순차적으로 특정한 연산을 진행한 후 새로운 배열 반환.
console.group('map()');
let printFish = fish.map(aFish => {
    console.log(aFish);
})

// fish 배열의 모든 요소(각 물고기)들을 복수화시킴
let fishes = fish.map(aFish => `${aFish}s`);
console.log(fishes);

// 숫자 배열을 제곱한 새로운 배열 반환
let numbers = [1, 2, 3, 4];
sqrtNumbers = numbers.map(number => number * number); // 콜백 함수로 반환된 값들로 새로운 배열 반환.
console.log(sqrtNumbers);
console.groupEnd();




// filter() : 배열의 각 요소들을 주어진 조건을 통과한 요소들만 모아다가 새로운 배열로 반환
console.group('filter()');
let snacks = ['cookie', 'smoothy', 'soup', 'mnm'];
let filteredList = snacks.filter(snack => snack[0] === 's');
console.log(filteredList);

// 주어진 배열에서 짝수만 반환
// numbers = [1, 2, 3, 4]
const even = numbers.filter(number => number % 2 === 0);
console.log(even);
console.groupEnd();

// reduce() : 주어진 배열을 하나의 결과값으로 반환함.
console.group('reduce()'); 
let someNumbers = [53, 42, 33, 15, 2, 7, 39]; // 문자열, 배열 등 다른 데이터 타입도 됨.
let sum = someNumbers.reduce((a, b) => a + b);
console.log(sum);
console.groupEnd();

// find() : 주어진 테스트를 통과하는 첫 번째 값을 반환함.
console.group('find()');

let foods = ['meat', 'kimchi', 'asparagus', 'eggs'];
const vegetable = foods.find(food => ['kimchi', 'asparagus'].includes(food));

console.log(vegetable);
console.groupEnd();

// findIndex() : 주어진 테스트를 통과하는 첫 번째 값의 인덱스 반환.
console.group('findIndex()');
const vegetableIndex = foods.findIndex(food => ['kimchi', 'asparagus'].includes(food));
console.log(vegetableIndex);

const drinkIndex = foods.findIndex(food => ['coffee', 'tea'].includes(food));
console.log(drinkIndex); // 찾고자하는 값이 없으면 -1 반환.
console.groupEnd();