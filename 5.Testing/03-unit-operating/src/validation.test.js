import { describe, expect, test } from "vitest";
import { validateStringIsNotEmpty, validatedNumber } from "./validation";

describe('문자열 검증 테스트 - validateStringIsNotEmpty()', () => {
    
    test('길이가 1 또는 2 이상인 빈 문자열이 전달될 경우 에러가 발생한다.', () => {
        const input = '  ';

        const result = () => validateStringIsNotEmpty(input);

        expect(result).toThrowError();
        
    });

    test('에러가 발생된 경우 (공백은 입력할 수 없습니다.) 라는 에러 메시지를 출력한다.', () => {
        const input = '';
        const result = () => validateStringIsNotEmpty(input);

        expect(result).toThrow('공백은 입력할 수 없습니다.');
    });

    test('일반 문자열이 전달될 경우 에러가 발생하지 않는다.', () => {
        const input = '유효한 문자열';

        const result = () => validateStringIsNotEmpty(input);
        expect(result).not.toThrowError();
    });

});

describe('숫자값 검증 테스트 - validateNumber()', () => {
    test('에러가 발생된 경우 (숫자 값이 아닙니다) 라는 에러 메시지를 출력한다.', () => {
        const input = '숫자 아님';
        const result = () => {
            validatedNumber(input);
        }
        expect(result).toThrow('숫자 값이 아닙니다');
        
    });

    test('숫자 기반의 문자열이 전달된 경우 숫자 타입으로 변환한다.', () => {
        const input = '1';
        const result = validatedNumber(input);
        expect(result).toBeTypeOf('number');
    });

    test('유효한 숫자가 전달되면 에러를 발생시키지 않는다.', () => {
        const input = 1;
        const result = () => validatedNumber(input);
        expect(result).not.toThrow();
    });
});