for (let index = 1; index < 6; index++) {
    console.log(`${index} 번 반복`);
}

const rainbow = 'rainbow';

for (let i = 0; i < rainbow.length; i++) {
    const element = rainbow[i];
    console.log(element);
}


const foods = ['apple', 'orange-cookie', 'avocado', 'doctor-peppermint'];
let favorite = '내가 좋아하는 음식은..';


for (let i = 0; i < foods.length; i++) {
    if (foods[i] === foods.length-1) {
        favorite += '그리고 ' + foods[i];
    } else {
        favorite += foods[i] + ', '
    }
}
console.log(favorite);

const fruits = ['apple', 'banana', 'coconut'];

fruits.forEach(fruit =>  {
    console.log(fruit);
});
