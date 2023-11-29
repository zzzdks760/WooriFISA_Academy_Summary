let g = 0;

function setGwith100() {
    console.log('setGWith100 started');

    setTimeout (() => {
        g = 100;
    }, 1000);

    console.log('setGWith100 ended');

    return g;
}

const result = setGwith100();
console.log(result);
console.log(g);



//'setGWith100 started'
//setGWith100 ended
//g