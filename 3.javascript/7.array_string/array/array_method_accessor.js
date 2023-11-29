// 1. concat() : 두 개 이상의 배열을 합쳐 새로운 배열을 반환.
console.group('concat()');
let disney = ['mickey', 'mini', 'stitch', 'donald duck'];
let ghibli = ['howl', 'totoro', 'mononoke', 'kiki'];

let animation = disney.concat(ghibli);
console.log(animation);

// 원본 배열은 변함없음.
console.log(disney);
console.log(ghibli);
console.groupEnd();

// 2. join() : 모든 배열 요소들을 string으로 변환.
console.group('join()');
let fish = ['shark', 'whale', 'koi', 'nemo(?)', 'defense'];
let fishString = fish.join(); // join() 내부에 별도의 파라미터를 지정하지 않으면 , 를 기준으로 합쳐짐.
console.log(typeof fishString, fishString);

fishString = fish.join(' / ');
console.log(fishString);
console.groupEnd();

// 3. slice() : 일부 요소들을 잘라서(가져다가) 새로운 요소로 반환.
console.group('slice()');
console.log(fish);
let slicedFishArr = fish.slice(2); // 2번 인덱스부터 끝까지.
console.log(slicedFishArr);

slicedFishArr = fish.slice(2, 4); // 2번 인덱스부터 4 -1 번 인덱스까지
console.log(slicedFishArr); 
console.groupEnd();

// 4. indexOf() : 배열에서 찾고자 하는 요소의 가장 첫 번째 인덱스 위치만 반환.(찾고자 하는 요소가 중복이어도)
console.group('indexOf()');
fish = ['shark', 'whale', 'koi', 'whale', 'nemo']; // whale이 1, 3번 인덱스에 중복 위치.

console.log(fish);
console.log(`fish array에서 'whale'의 가장 첫 번째 인덱스 위치 : ${fish.indexOf('whale')}`);

// 찾고자 하는 요소가 없을 경우 -1 반환.
console.log(`한치가 있나요? 한치는 오징어에요! ${fish.indexOf('hanchi')}`);
console.groupEnd();

// 5. lastIndexOf() : 배열에서 찾고자 하는 요소의 가장 마지막 인덱스 위치를 반환.
// 인덱싱을 뒤에서부터 시작함.
console.group('lastIndexOf()');
console.log(fish);
console.log(`whale 요소가 위치한 마지막 인덱스 위치 : ${fish.lastIndexOf('whale')}`);
console.groupEnd();