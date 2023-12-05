import { add } from "./src/calculator.js";
import { validateStringIsNotEmpty } from "./src/validation.js";

const form = document.getElementById('form');
const output = document.getElementById('result');

const formSubmitHandler = (event) => {
    event.preventDefault();

    const formData = new FormData(form);

    const firstNumber = formData.get('firstNumber');    
    const secondNumber = formData.get('secondNumber');
    
    const numbers = [];
    numbers.push(firstNumber);
    numbers.push(secondNumber);

    // 덧셈 로직
    let result = "";

    //공백 값 검증
    try {
        //유효성 처리 이후 숫자 값으로만 검증된 배열
        const validatedNumbers = [];

        for (const number of numbers) {
            //공백값 검증
            validateStringIsNotEmpty(number);
            //유효한 숫자인지 검증
            const validatedNumber = validatedNumber(number);
            validatedNumbers.push(validatedNumber);
        }
        result = add(validatedNumbers);
        
    } catch (error) {
        result = error.message;
    }

    validateStringIsNotEmpty(number);

    output.textContent = result;
    
}

form.addEventListener('submit', formSubmitHandler);