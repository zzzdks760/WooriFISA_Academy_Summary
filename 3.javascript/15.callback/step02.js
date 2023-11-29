function a(callback) {

    setTimeout(() => {
        console.log('a is call');
        callback();
    }, 1000);
}

a(() => console.log('a is done'));