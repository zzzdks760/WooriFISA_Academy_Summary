const xhr = new XMLHttpRequest();

const xhrButtonSuccess = document.getElementById("success");
const xhrButtonError = document.getElementById("error");
const xhrButtonAbort = document.getElementById("abort");
const log = document.getElementById("event-log");

const resultData = document.getElementById('result');

function handleEvent(e) {
  log.textContent = `${log.textContent}${e.type}: ${e.loaded} bytes transferred\n`;

  if (xhr.readyState === xhr.DONE && xhr.status === 200) {
    // responseText: 서버로부터 받은 응답 데이터
    const responseData = xhr.response;
    resultData.textContent = responseData;

    const result = JSON.parse(responseData); // parse를 하지 않을 경우 문자열
    console.log(result);
}
}

function addListeners(xhr) {
  xhr.addEventListener("loadstart", handleEvent);
  xhr.addEventListener("load", handleEvent);
  xhr.addEventListener("loadend", handleEvent);
  xhr.addEventListener("progress", handleEvent);
  xhr.addEventListener("error", handleEvent);
  xhr.addEventListener("abort", handleEvent);
}

function runXHR(url) {
  log.textContent = "";
  addListeners(xhr);
  xhr.open("GET", url);
  xhr.send();
  return xhr;
}

// JSON Data 요청
xhrButtonSuccess.addEventListener("click", () => {
   runXHR('https://jsonplaceholder.typicode.com/todos/1');
});


xhrButtonError.addEventListener("click", () => {
  runXHR("https://somewhere.org/i-dont-exist");
});

xhrButtonAbort.addEventListener("click", () => {
  runXHR("image.jpg").abort();
});
  