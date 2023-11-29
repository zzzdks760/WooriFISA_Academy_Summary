const dog = {
    age: 2
};
console.log(dog.age);

const cat = {age : 5};
console.log(cat.age);

const ages = [2, 5];
console.log(ages[0]);

const dog2 = {
    age: 2,
    name: 'toto',
    walk: () => console.log('강아지가 걷는다'),

    address: {
        si: "서울시",
        gu: "마포구",
        dong: "상암동"
    }
};

dog2.walk();

// console.log(`toto의 주소는 ${dog2.address.si} ${dog2.address.gu} ${dog2.address.dong}임`);
console.log('toto의 주소는', dog2.address.si, dog2.address.gu, `${dog2.address.dong}임`);


const {si, gu, dong} = dog2.address;
console.log(dong);

const arr = [si, gu, dong] = [1, 2, 3];
console.log();
