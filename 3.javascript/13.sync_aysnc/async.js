function first() {
    console.log('first() called');
}

function someLongWork() {
    console.log('오래 걸리는 작업 수행 중..');
}

function second() {
    console.log('second() called');
}


setTimeout(first, 3 * 1000);
second();