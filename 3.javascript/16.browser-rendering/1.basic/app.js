// DOM 
const headingEl = document.querySelector('h1');
const paraEl = document.querySelector('p');
const divEl = document.querySelector('div');

console.log(headingEl instanceof HTMLDivElement); // false, HTMLHeadingElement

// paraEl instanceof HTMLDivElement; // false, HTMLParagraphElement
// divEl instanceof HTMLDivElement; // true

// headingEl instanceof Node; // true
// paraEl instanceof Node; // true
// divEl instanceof Node; // true

/**
 * DOM Parser
 * HTML 문자열을 DOM Tree로 변환
 */

// new DOMParser, new XMLHttpRequest();, -> 생성자 함수를 통해 객체 생성
// 생성자 함수 - 함수 작성 방법 중 하나(교재 참조)
const domParser = new DOMParser();

console.log(domParser);

// 서버로부터 받은 HTML 문자열이라고 가정
const result = domParser.parseFromString('<div class="main">hello</div>', 'text/html');
console.log(result);