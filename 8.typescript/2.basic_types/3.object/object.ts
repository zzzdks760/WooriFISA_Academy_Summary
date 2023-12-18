const dog = {
    age: 2,
    name: 'toto',
    walk: function() {
        console.log('강아지가 걷는다.');
        
    }
}

// age 프로퍼티 조회
console.log(dog.age);

// color 프로퍼티 조회
// console.log(dog.color);


// birth 프로퍼티 조회
// dog.birth = '2023-13-18';

// 추가 방법
let cat: { [key: string]: any } = {};
// cat 객체의 프로퍼티를 동적으로 추가 가능한데, key값은 문자열만 가능, value는 모두 할당 가능

cat.name;
cat.age;

let lion: { age: number, name: string }; // lion 객체 선언

lion = { age: 5, name: 'king' };

let tiger: { age: number, name?: string };

tiger = { age: 3 };

