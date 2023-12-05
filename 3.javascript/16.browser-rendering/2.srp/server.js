const express = require('express');
const path = require('path');

const app = express();

app.get('/:dir/:file', (HTTPRequest, HTTPResponse) => {
    HTTPResponse.sendFile(path.resolve( __dirname, HTTPRequest.params.dir, HTTPRequest.params.file));
});

app.get('/:dir/:file', (HTTPRequest, HTTPResponse) => {
    HTTPResponse.sendFile(path.resolve( __dirname, HTTPRequest.params.dir, HTTPRequest.params.file));
});

app.get('/:delay/:dir/:file', (HTTPRequest, HTTPResponse) => {
    setTimeout(() => {
        HTTPResponse.sendFile(path.resolve( __dirname, HTTPRequest.params.dir, HTTPRequest.params.file));
    }, Number(HTTPRequest.params.delay));
});

const port = 3000;
app.listen(port, () => console.log(`http://127.0.0.1:${port}/ app listening on port ${port}`));