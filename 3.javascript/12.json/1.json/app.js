//JS 객체
const book = {
    title: '노인과 바다',
    author: '헤밍웨이',
    isSolid: false,
    genere: ['소설', '에세이'],
};


const jsonDate = JSON.stringify(book);
console.log(jsonDate);


const parsedDate = JSON.parse(jsonDate);
console.log(parsedDate);



// 배열
const books = [
    { id: 1, title: "하농", author: "하농", isSold: false },
    { id: 2, title: "체르니", author: "체르니", isSold: true },
    { id: 3, title: "부르크뮐러", author: "부르크뮐러", isSold: true },
]

for (let index = 0; index < books.length; index++) {
    const element = books[index];
    const ify = jsonDate.stringify(element);
    console.log(ify);
}