/**
 * 덧셈 함수
 * @param {*number} a 
 * @param {*number} b 
 * @returns {number} 덧셈 결과
 * @author 'sungmin'
 */

function add(a, b) {
    return a+b;
}

console.log(add(3, 5));


const mtp = function (a, b) {
    return a * b;
}

console.log(mtp(3, 5));


const sub = (a, b) => a - b;
console.log(sub(5, 3));

const hello = () => console.log('hello');
hello();

const square = (x) => x * x;
console.log(square(3));