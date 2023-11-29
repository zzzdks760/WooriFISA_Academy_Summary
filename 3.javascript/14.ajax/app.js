// // 1. 생성자 함수를 통해 XMLHttpRequest 인스턴스(객체) 생성
// const xhr = new XMLHttpRequest();

// // 2. onload 이벤트 프로퍼티에 서버로부터의 응답이 완료되었는지 확인하는 코드 작성
// xhr.onload = () => {
//     if (xhr.readyState === xhr.DONE && xhr.status === 200) {
//         const responseData = xhr.responseText; // responseText: 서버로부터 받은 응답 데이터
//         const result = JSON.parse(responseData); // JSON 역직렬화
//         console.log(result); 
//     }
// }

// // 3. 요청 준비(open(method, url, async, ..))
// const url = 'https://jsonplaceholder.typicode.com/users/1';
// xhr.open('GET', url);

// // 4. 요청 실제 전송
// xhr.send();


// const xhr = new XMLHttpRequest();

// console.dir(xhr);