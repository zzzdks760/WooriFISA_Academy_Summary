function order(food, callback) {
    console.log(`${food} 도착`);
    callback();
}

function eat() {
    console.log('먹는다');
}
  
order('짜장면', eat);