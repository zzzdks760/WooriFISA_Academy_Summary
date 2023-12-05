export const validateStringIsNotEmpty = (value) => {
    //공백 값을 입력하였을 경우에는 공백은 입력할 수 없습니다. 라는 Error를 던지도록 작성
    if (value.trim().length === 0) throw new Error("공백은 입력할 수 없습니다.");
}

//숫자값 유효성 검증 함수, 전달받은 값이 숫자 값인지 검증
export const validatedNumber = (number) => {
    if (typeof number === 'number' || (typeof number === 'string' && !isNaN(number))) {
        console.log(number);
        return +number;
    }

    if (!Number.isNaN(number)) {
        throw new Error('숫자 값이 아닙니다.');
    }
}