// 타입 별칭을 활용한 객체 타입 선언
// type 키워드 사용(타입 이름은 일반적으로 대문자 시작)

type Cookie = {
    name: string;
    pubDate: number;
    company: string;
};

let firstCookie:  Cookie //별칭을 활용해서 변수의 타입을 명시

firstCookie = {
    name: 'OREO',
    pubDate: 1910,
    company: 'orion'
};

// secondCookie = 'LOTTE';