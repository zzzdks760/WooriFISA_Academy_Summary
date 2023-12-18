//문자열만 할당할 수 있음
const message3: string = 'hello'
console.log(message3);

//tsc를 수행할 경우 var로 변환되기 때문에 별도의 실행옵션을 통해 JS 최근 문법으로 변환되도록 할 수 있음

//npx tsc --target es6 step03.ts
//ES6 문법 이상으로 변환되도록 별도의 실행 옵션 추가