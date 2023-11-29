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
    }, 500 ); // 0.5 second delay
}

function c( callback ) {
	setTimeout( () => {
        console.log( 'c() called' );
        callback();
    }, 1200 ); // 1.1 second delay
}

a( () => console.log('a() is done!') );
b( () => console.log('b() is done!') );
c( () => console.log('c() is done!') );

// delay때문에 b a c 순서로 호출됨