/*
    입력 폼 구현을 위해 필요한 객체를 생각해보기(모델링)

    모델링 - 현실에 존재하는 문제를 해결하기 위해
    가상 세계로 추상화시키는 활동, 작업

    값을 입력받는 역할 수행하는 클래스 - UserInputForm
    입력받은 값을 검증'만'하는 역할을 수행하는 클래스 - Validator
    입력받은 값이 유효할 경우 해당 값을 가지고 하나의 회원 정보를 가지고 있을 회원 클래스 생성 - User
    
*/

/*
    회원(User) 클래스 선언 및 정의

    회원은 userName과 password를(속성, 필드) 가지고 있음

    회원은 인사를 할 수 있음(greet())
    console.log('Hi, I am ' + userName); // 
*/

class User {
    userName;
    password;

    constructor(userName, password) { // 회원 객체를 생성할 때, userName과 password를 필수로 입력
    // JS는 복수 생성자 구현불가, https://stackoverflow.com/questions/32626524/why-doesnt-javascript-es6-support-multi-constructor-classes
        if (!arguments.length) {
            this.userName = 'nobody';
            this.password = 'none';
        } else {
            this.userName = userName;
            this.password = password;
        }
    }

    greet() {
        console.log('Hi, I am ' + this.userName);
    }
}



// Validator 클래스 선언
class Validator {

    REQUIRED = 'REQUIRED'; // Validator 클래스가 가진 속성(변수) - 'REQUIRED'(문자열값)
    MIN_LENGTH = 'MIN_LENGTH';

    constructor() {
        console.log('Validator 객체가 생성되었음');
    }

    /**
     * @param {*} value - 입력값
     * @param {*} flag - 필수 입력 값인지, 최소 길이를 포함하는지와 같은 구분자
     * @param {*} validatorValue - 최소 길이 숫자값
     */
    validateUserInput(value, flag, validatorValue) {
        if (flag === this.REQUIRED) {
            return value.trim().length > 0;
        }
        if (flag === this.MIN_LENGTH) {
            return value.trim().length > validatorValue;
        }
    }

}

// UserInputForm 클래스 선언
class UserInputForm {
    constructor() { // 생성자 - UserInputForm 객체를 생성해주는 함수
        console.log('UserInputForm 객체가 생성되었음');
    }

    // 사용자 입력값 받을 수 있도록 역할을 부여(함수)
    processUserInput(userName, password, validator) {
        
        // 입력받은 값이 유효한지 검증하기 위해 validator에게 메시지 전달
        const isUserInputValid = validator.validateUserInput(userName, validator.REQUIRED);
        const isPasswordInputValid = validator.validateUserInput(password, validator.MIN_LENGTH, 5);

        if (isUserInputValid && isPasswordInputValid) { // id, password가 모두 유효할 경우
            // 회원 클래스를 통해 회원 객체 생성
            const createdUser = new User(userName, password);

            // 생성된 회원 객체를 반환
            return createdUser;
        } else { // 유효하지 않은 값일 경우 빈(Empty) 회원 객체를 반환하도록
            const emptyUser = new User();
            return emptyUser;
        }  
    }
}


function main(id, password) {
    // UserInputForm 객체를 생성
    const userInputForm = new UserInputForm();
    console.log(userInputForm); // userInputForm 객체가 대기중
    
    // Validator 객체 생성
    const validator = new Validator();
    
    // userInputForm에게 메시지 전달
    const user = userInputForm.processUserInput(id, password, validator); // userInputForm아 입력값 받아
    user.greet(); // Hi, i am ~
}

const userInput = prompt('id, password를 공백을 구분하여 입력하세요');
const [id, password] = userInput.split(' ');
main(id, password);