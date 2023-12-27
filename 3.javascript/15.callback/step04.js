function a( callback ) {
	setTimeout( () => {
        console.log( 'a() called' );
        callback();
    }, 1000 ); // 1 second delay
}

function b( callback ) {
	setTimeout( () => {
        console.log( 'b() called' );
        callback();
    }, 1000 ); // 0.5 second delay
}

function c( callback ) {
	setTimeout( () => {
        console.log( 'c() called' );
        callback();
    }, 1000 ); // 1.1 second delay
}

a(() => {
    console.log('a is done');

    b(() => {
        console.log('b is done');

        c(() => {
            console.log('c is done');
        })
    });
}); // 콜백 헬 발생(가독성, 코드 이해도 저하, 예외처리 곤란함)