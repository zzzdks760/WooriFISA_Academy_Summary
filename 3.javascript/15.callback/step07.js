// let post;

// const get = (url) => {
//     console.log('get() started');
//     const xhr = new XMLHttpRequest();
//     xhr.open('GET', url);
//     xhr.send();

//     xhr.onload = () => { // onload 프로퍼티에 화살표 함수가 이벤트로 등록된 후 get()함수가 내부의 비동기 요청 처리 결과를 받기 전에 먼저 종료됨
//         if (xhr.status === 200) {
//             console.log(xhr.response); // onload 이벤트는 callstack이 비어버린 후(53line의 console.log의 수행 종료) 가장 마지막에 동작
            
//             post = JSON.parse(xhr.response); // 상위 스코프에 값을 할당

//             return JSON.parse(xhr.response); // 값 그 자체를 반환(?)
//         } else {
//             console.error(`${xhr.status} ${xhr.statusText}`);
//         }
//     }
//     console.log('get() ended');
// }

// const url = 'https://jsonplaceholder.typicode.com/posts/1';

// const getResult = get(url);
// console.log(getResult); // undefined

// console.log(post); // 상위 스코프에 할당 불가

// // 정리하면 비동기 처리 결과를 외부에 반환하거나 상위 스코프의 변수에 값을 할당할 수 없고,
// // 따라서 비동기 함수의 처리 결과(서버의 응답 등)에 대한 처리는 비동기 함수 내부에서 수행해야함.ac



let resultData;

const get = (url, successCallback) => {
    console.log('get() started');

    const xhr = new XMLHttpRequest();
    xhr.open('GET', url);
    xhr.send();

    xhr.onload = () => {
        if (xhr.status === 200) {
            successCallback(xhr.response);
            console.log(resultData);
        }
    }
}


const url = 'https://jsonplaceholder.typicode.com/posts/1';

const getResult = get(url, (result) => {
    resultData = result;
});
console.log('getResult: ', getResult);