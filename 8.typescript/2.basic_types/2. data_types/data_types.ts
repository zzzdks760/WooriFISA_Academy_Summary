// let year: number = 2023;

let year = 2023; //타입 추론
// 우측에서 전달된 값을 통해 year를 number 타입으로 추론

let userName = 'YOO';

console.log(userName.toLowerCase);

const array = [1, '문자열', 4];

const numbers: number[] = [1, 2, 3];

//tsc 명령어 매번 실행하지 않고 지속적으로 적용 tsc -w