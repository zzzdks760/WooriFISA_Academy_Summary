const getBtn = document.getElementById("get-btn");
const postBtn = document.getElementById("post-btn");
const [id, name] = document.getElementsByTagName('p');

const xhr = new XMLHttpRequest();

getBtn.addEventListener('click', () => {
    xhr.open('GET', '/users');

    xhr.send();

    xhr.onload = () => {
        if (xhr.status === 200) {
            const responseData = JSON.parse(xhr.response);
            console.log(responseData);

            //id에 JSON 데이터 중 id가 1번인 값을 할당
            id.textContent = responseData[0].id;
            
            //name에 JSON 데이터 중 id가 1번인 값의 name 값을 할당
            name.textContent = responseData[0].name;
        }
    }
});

postBtn.addEventListener('click', () => {
    const dummyData = {
        id: 11,
        name: 'yoo',
        username: 'kang'
    };
    // 요청 경로는 /users로 동일함
    // 요청 준비, 데이터 조회 요청이 아닌 등록 요청이기 때문에 GET이 아닌 다른 메서드
    xhr.open('POST', '/users');

    // 서버에게 보내는 데이터의 타입은 JSON 타입임을 명시
    xhr.setRequestHeader('Content-Type', 'application/json');
    
    // 요청 전송
    xhr.send(JSON.stringify(dummyData));

    // 응답 완료 시 동작할 이벤트 리스너
    xhr.onload = () => {
        if (xhr.status === 200 || xhr.status === 201) { // 201 created
            // 응답(등록 요청)이 성공할 경우 console.log로 결과 데이터 출력
            console.log(xhr.response);
        }
    }
});
