const a = 5;

if (a === 5) {
    console.log('a는 5입니다.');
} else if (a === 6){
    console.log('a는 6입니다.');
} else {
    console.log('5가 아닙니다.');
}


const selectButton = document.getElementById('cookie');
const result = document.getElementById('result');

function setResult() {
    const choice = selectButton.value;
    console.log(choice);

    if (choice === "one") {
        result.textContent = '한대';
    } else if (choice === "two") {
        result.textContent = '두대';
    } else {
        result.textContent = '보류';
    }
}

selectButton.addEventListener('change', setResult);