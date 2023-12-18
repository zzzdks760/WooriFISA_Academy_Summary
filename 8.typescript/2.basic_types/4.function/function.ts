function add (a: number, b: number) {
    return a + b;
}
// add('1', 2);
add(1, 2);

function sub (a: number, b: number) : number {
    return a - b;
}

function sayHello () {
    console.log('hello');
    
}

const multiply = (a: number, b: number): number => a * b;

/*
    1. name(string), amount(number)를 가지는 Cookie 타입의 객체 선언

    2. Cookie 타입을 가지는 cookies 배열 생성 및 값 초기화

        dummydata
        [
            { name: 'OREO', amount: 5 },
            { name: 'HERSHEY', amount: 2 },
            { name: 'LOTTE', amount: 3 },
        ]

    3. 함수의 인수로 전달받은 Cookie 객체의 이름과 수량을 파악해주는 함수 myCookieCounter 작성
        파라미터 - 하나의 쿠키 객체, cookie

    4. 전체 Cookie의 재고를 확인해주는 checkStockOfCookie() 함수 작성
        파라미터 - 
            1. 전체 Cookie를 보관하고 있는 cookie 배열, cookieArray
            2. 하나의 쿠키 이름과 수량을 파악해주는 함수 cookieCounter

*/

type Cookie = {
    name: string;
    amount: number;
};

const cookies: Cookie[] = [
    { name: 'OREO', amount: 5 },
    { name: 'HERSHEY', amount: 2 },
    { name: 'LOTTE', amount: 3 }
];

function myCookieCounter(cookie: Cookie) {
    console.log(`${cookie.name} s amount is ${cookie.amount}`);
}

function checkStockOfCookie(cookieArray: Cookie[], cookieCounter: (cookie: Cookie) => void) {
    cookieArray.map(cookieCounter);
}

checkStockOfCookie(cookies, myCookieCounter);