import { describe, expect, test } from 'vitest'; // vitest에서 제공하는 expect(), test() import
import { add } from "./calculator";

test.skip('1.배열 내 모든 숫자 요소들의 합을 구해야 한다.', () => {
    // Arranage - 테스트를 수행하기 위한 의존성 준비
    const numbers = [1, 2, 3];

    // Act - 실제 수행할 테스트 대상 코드
    const result = add(numbers);

    // Assert - 테스트의 성공/실패 여부를 확인하기 위한 단정문(~일 것이다.)
    // expect(result).toBe(6); // 6은 하드코딩되었기 때문에 numbers의 값에 따라 동적으로 변경되도록

    // Array.prototype.reduce()를 통해서 배열의 합 계산하는 코드 작성
    const initialValue = 0;
    const expectedResult 
    = numbers.reduce((previousValue, currentValue) => previousValue + currentValue, initialValue);
    
    expect(result).toBe(expectedResult);

});

// 테스트 스위트(test suite)
// describe('비슷한 테스트 케이스끼리 그룹화', () => {});

describe.skip('2. 유효하지 않은 입력값', () => {
    test('2-1. 하나라도 공백 값이 전달될 경우, NaN을 반환한다.', () => {
        // Arrange
        const numbers = [1, '']; // '' = 공백값
        
        // Act
        const result = add(numbers);

        // Assert
        expect(result).toBeNaN();
    });

    test('2-2. 문자열로 작성된 숫자값이 전달되어도 연산 결과를 반환한다.', () => {
        const numbers = ['1', '2'];

        const result = add(numbers);

        // Number(previousValue)
        const expectedResult 
    = numbers.reduce((previousValue, currentValue) => +previousValue + +currentValue, 0);

        expect(result).toBe(expectedResult);
    });

    test('2-3. 하나라도 숫자가 아닌 값이 전달될 경우, NaN을 반환한다.', () => {
        const result = add([1,'string']);
        expect(result).toBeNaN();
    });

    test('2-4. 빈 배열이 전달될 경우 0을 반환한다.', () => {
        const numbers = [];

        const result = add(numbers);

        expect(result).toBe(0);
    });

    test('2-5. add()에 인수가 전달되지 않을 경우 예외를 던진다.', () => {
        const resultFunction = () => {
            add();
        }

        expect(resultFunction).toThrow();
    });

});