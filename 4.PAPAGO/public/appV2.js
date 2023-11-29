const [sourceSelect, targetSelect] = document.getElementsByTagName('select');
const [sourceTextArea, targetTextArea] = document.getElementsByTagName('textarea');

let targetLanguage = 'en';
targetSelect.addEventListener('change', (event) => targetLanguage = event.target.value);

let timer;
sourceTextArea.addEventListener('input', (event) => {
    if(timer) clearTimeout(timer);

    timer = setTimeout(async () => {
        const text = event.target.value;
        const result = await detectLanguage(text);
        translateLanguage(result, text);
    }, 2000);

});

// options 객체 생성해주는 함수
// options 객체를 만들건데 파라미터로부터(from) 전달받은 method, body, headers로 만든다
const optionsFrom = (method, body, headers) => {
    return { // 객체 리터럴을 바로 반환
        method,
        headers: {
            'Content-Type': 'application/json',
            ...headers // spread 문법
        },
        body: JSON.stringify(body)
    };
}

// 언어 감지 요청 기능을 수행하는 함수
const detectLanguage = async (text) => {
    let sourceLanguage;

    const url = '/detectLangs';
    const options = {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ query: text }),
    };

    await fetch(url, options)
    .then(response => response.json())
    .then(data => {
        sourceLanguage = data.langCode;
        sourceSelect.value = sourceLanguage;
    })
    .catch(error => console.error(error));

    return sourceLanguage;
}

// 언어 번역 요청 기능을 수행하는 함수
const translateLanguage = async (sourceLanguage, text) => {
    const url = '/translate';

    const body = {
        source: sourceLanguage,
        target: targetLanguage,
        text,
    }

    await fetch(url, optionsFrom('POST', body))
    .then(response => response.json())
    .then(data => {
        const result = data.message.result;
        targetTextArea.value = result.translatedText;
        targetSelect.value = result.tarLangType;
    })
    .catch(error => console.error(error));
}