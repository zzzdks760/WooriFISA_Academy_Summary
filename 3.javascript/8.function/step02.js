// function greeting(name) {
//     console.log(`Hello${name}`);
// }

// const greeting = (name) => console.log(`Hello ${name}`);

// greeting('yoo');


// function processUserInput(name, callbackFunction) {
//     callbackFunction(name);
// }

// processUserInput('yoo', greeting);




// const waitCoupang = (appleBox, callBack) =>  {
//     console.log(`쿠팡에서 ${appleBox}가 도착했다`);
//     callBack();
// }


// function bringItToNeighbor () {
//     console.log('옆집 아주머니에게 전달 완료');
// }

// waitCoupang('appleBox', bringItToNeighbor);

// number = [1, 2, 3];
// const callBack = number => console.log(number);
// callBack(number);


// const waitCoupange = (appleBox, callBack) => {
//     console.log(`쿠팡에서 ${appleBox}가 도착했다.`);
//     callBack();
// }

// function bringItToNeighbor () {
//     console.log('옆집 아주머니에게 전달 완료.');
// }

// waitCoupange('appleBox', bringItToNeighbor);



function callbackFunction (callBack) {
    setTimeout(callBack, 1000);
    console.log('Hello');
}

callbackFunction(() => {
    console.log('waited 1 second');
});