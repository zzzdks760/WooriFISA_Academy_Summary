let fish = ['piranha', 'koi', 'nimo(?)', 'clown-fish'];
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      
// fish는 무슨 object인가?
console.group('object의 실체(?) 확인');
console.log(typeof fish); // object? what kind of object?
console.log(Array.isArray(fish)); // 해당 객체가 array 객체인지 확인, true/false 
console.groupEnd();

// 1. 원본을 직접 수정하는 mutator methods.

// 1.pop() : 원본 배열의 가장 끝 요소 제거, 해당 값 반환, 추가 파라미터 없음.
console.group('pop()');
console.log(`제거된 값 : ${fish.pop()}`);
console.log(fish);
console.groupEnd();

// 2.shift() : 원본 배열의 가장 첫 번째(앞) 요소 제거.
console.group('shift()');
console.log(`제거된 값 : ${fish.shift()}`); // 모든 요소들의 인덱스가 앞으로 한 칸 당겨져야하기 때문에 성능상 pop()을 사용하는 것이 좋음.
console.log(fish);
console.groupEnd();

// 3.push() : 원본 배열의 가장 끝에 새로운 요소 추가.
console.group('push()');
console.log(`추가된 후 배열의 길이(length) : ${fish.push('defense')}`); // 방어 추가
console.log(fish);
console.groupEnd();

// 4.unshift() : 원본 배열의 가장 앞에 요소 추가.
console.group('unshift()');
console.log(`추가된 후 배열의 길이(length) : ${fish.unshift('shark')}`);
console.log(fish);
console.groupEnd();

// pop(), push()는 array의 가장 끝에 영향을 미치고, shift(), unshift()는 앞에 영향을 미침.
// 따라서 shift, unshift는 모든 인덱스에 영향을 미침.

// 5.splice() : 정해진 위치에 요소를 추가하거나 제거. 추가와 제거를 동시에도 가능.
// Array.splice(index number, number of items to remove, [items to add])
console.group('splice()')

// splice를 활용한 요소 추가.
console.log('splice()를 활용한 요소 추가');
console.log(fish.splice(1, 0, 'whale')); // 빈 배열, 1번째 파라미터를 0으로 지정하면 요소를 삭제하지 않음.
// push()나 unshift()처럼 배열의 가장 앞, 뒤에만 추가하는 것에 비해 더 유연함.
console.log(fish);

// splice를 활용한 요소 제거.
// 세 번째 파라미터였던 'whale'을 작성하지 않으면 요소의 제거가 가능.
console.log('splice()를 활용한 요소 제거');
console.log(fish.splice(1, 2)); // splice(지정된 인덱스, 지정된 인덱스 위치부터 삭제할 요소 수), 제거할 요소 반환.
console.log(fish);

// 추가와 제거를 동시에 하는 법.
console.log('splice()를 활용한 추가와 제거 동시 진행');
fish = ['shark', 'whale', 'koi', 'nimo(?)', 'defense'];
console.log(fish);
console.log(fish.splice(1, 2, 'sakana')); // 1번 인덱스부터 2개의 요소 삭제 후 1번 인덱스에 'whale'추가.
console.log(fish);
console.groupEnd();

// 6. reverse() : 배열의 순서 역순으로 정렬
console.group('reverse()');
console.log(fish.reverse()); // 역순된 배열
console.log(fish); // 원본 변경.
console.groupEnd();

// 7. fill() : 모든 요소들을 주어진 값으로 전부 덮어씀.
console.group('fill()');
console.log('현재 fish array', fish);
console.log(fish.fill('the little mermaid'));
console.log(fish);

// 시작과 끝 지점 지정 가능.
console.log(fish.fill('shark', 1)); // 1번 인덱스부터 끝까지
console.log(fish.fill('olaf', 1, 3)); // 1번 인덱스부터 3 -1까지.
console.groupEnd();

// 8. sort() : 오름차순 정렬
console.group('sort()');
fish = ['shark', 'whale', 'koi', 'nemo(?)', 'defense'];
console.log(fish.sort());
console.log(fish);

// 가장 첫 문자 기준으로 정렬하며, 대문자가 소문자보다 정렬 기준이 앞섬.
console.log('문자 중에 대문자가 끼어있을 경우');
fish = ['Shark', 'whale', 'koi', 'nemo(?)', 'defense'];
console.log(fish.sort());
console.log(fish);

// 문자에 숫자가 추가되어 있다면?
console.log('요소 문자 앞에 숫자가 붙어있다면?');
fish = ['Shark', '2 whale', '53 koi', 'nemo(?)', 'defense'];
console.log(fish.sort());
console.log(fish);

// 숫자 정렬
let numbers = [53, 42, 33, 63, 2, 87];
console.log(numbers.sort()); // ? why? sort()는 숫자의 첫 번째 값을 기준으로 정렬함.

// 숫자를 정렬하기 위해서는 인자값을 비교하는 비교함수를 작성해야함.
const sortNumerically = (a, b) => { // how ? https://medium.com/@winwardo/the-principle-of-least-astonishment-and-javascripts-sort-e98a734a30c9
    return a - b;
}
numbers.sort(sortNumerically); // 콜백함수
console.groupEnd();

// 참고링크 : https://www.digitalocean.com/community/tutorials/how-to-use-array-methods-in-javascript-mutator-methods