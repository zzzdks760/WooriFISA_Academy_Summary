const express = require('express')
const app = express()

const client_id = 'c2cCxIl9HwmJ0uWuggxF';
const client_secret = 'HhszD0kXwk';

// public이라는 이름의 폴더에 정적 리소스 보관 후 응답하도록 미들웨어 추가
app.use(express.static('public'));

// 역직렬화용 미들웨어 추가
app.use(express.json());

app.get('/', (req, res) => res.sendFile('index.html'));

// localhost:3000/detectLangs로 요청 시 동작할 핸들러
app.post('/detectLangs', function (req, res) {
   const url = 'https://openapi.naver.com/v1/papago/detectLangs';
   const request = require('request');

   const options = {
       url,
       form: req.body,
       headers: {
        'Content-Type': 'application/json',
        'X-Naver-Client-Id':client_id, 
        'X-Naver-Client-Secret': client_secret
      }
    };

   request.post(options, function (error, response, body) {
     if (!error && response.statusCode == 200) {
      res.send(body); // 응답 결과를 app.js로 전달하는 코드
     } else {
       res.status(response.statusCode).end();
       console.log('error = ' + response.statusCode);
     }
   });
 });

// localhost:3000/translate로 요청 시 동작할 핸들러
app.post('/translate', (req, res) => {
  //  const query = '안녕하세요?';
   const url = 'https://openapi.naver.com/v1/papago/n2mt';
   
   const request = require('request');
   const options = {
       url, // url: url과 같음
      //  form: {'source':'ko', 'target':'en', 'text':query},
      form: req.body,
      headers: {
        'Content-Type': 'application/json',
        'X-Naver-Client-Id':client_id, 
        'X-Naver-Client-Secret': client_secret
      }
    };
    // 실제로 POST 요청 전송 부분
   request.post(options, (error, response, body) => {

     if (!error && response.statusCode == 200) {
      console.log(body);
      res.send(body); // 응답 결과를 app.js로 전달하는 코드
     } else {
       res.status(response.statusCode).end();
       console.log('error = ' + response.statusCode);
     }
   });
 });

// 서버 인스턴스를 3000번 포트에서 대기하도록 명시
const port = 3000;
app.listen(port, () => console.log(`http://127.0.0.1:${port}/ app listening on port ${3000}`));