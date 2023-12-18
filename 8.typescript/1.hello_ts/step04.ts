const msg: string = '문자열';

function greet(person: string, date) {
    console.log(`Hello ${person}, today is ${date}`);
    
}

// greet('고양이');

//--noEmitOnError 옵션
//위 옵션을 추가하면 문법 에러가 하나라도 있을 경우 트랜스파일이 불가하도록 설정