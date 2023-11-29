const btn = document.getElementById('btn');
const span = document.getElementById('cnt');
const dBtn = document.getElementById('decrease');
const rBtn = document.getElementById('reset');
const iBtn = document.getElementById('increase');
let count = 0;

function clickCounter () {
    count++;
    span.innerText = `${count}`;
    console.log(count);
}

function random(number) {
    return Math.floor(Math.random() * (number + 1));
}


btn.onclick = function () {
    const rndCol =
        "rgb(" + random(255) + "," + random(255) + "," + random(255) + ")";
    document.getElementById('box').style.backgroundColor = rndCol;
    clickCounter();
}

increase.onclick = function increase () {
    const rndCol =
        "rgb(" + random(255) + "," + random(255) + "," + random(255) + ")";
    document.getElementById('box').style.backgroundColor = rndCol;
    count++;
    span.innerText = `${count}`;
}

decrease.onclick = function decrease () {
    const rndCol =
        "rgb(" + random(255) + "," + random(255) + "," + random(255) + ")";
    document.getElementById('box').style.backgroundColor = rndCol;
    count--;
    span.innerText = `${count}`;
}

reset.onclick = function reset () {
    const rndCol =
        "rgb(" + random(255) + "," + random(255) + "," + random(255) + ")";
    document.getElementById('box').style.backgroundColor = rndCol;
    count = 0;
    span.innerText = `${count}`;
}
