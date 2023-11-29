console.dir(document);

console.log(window.document === document);

//DOM을 통한 HTML 조작

const h1 = document.getElementById('main-title');
console.log(h1);
console.log(h1.innerText);

    
const liList = document.querySelectorAll('li');
console.log(liList[1]);

const liList2 = document.getElementsByClassName('li-item');
console.log(liList2);