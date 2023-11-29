// 전역 스코프
// -> 디버거로 실행해보기
var x = '전역변수 x';
var y = '전역변수 y';

function outer() {
    var z = 'outer() 내 지역변수 z';

    console.log(x);
    console.log(y);
    console.log(z);

    function inner() {
        var x = 'inner() 내 지역변수 x';
        
        console.log(x);
        console.log(y);
        console.log(z);
    }

    inner();
}

outer();

console.log(x);
console.log(z);