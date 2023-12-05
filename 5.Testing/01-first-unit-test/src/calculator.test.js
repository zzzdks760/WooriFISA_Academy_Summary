/**
 * calculator.js를 테스트하는 코드
 */

import { expect, test } from "vitest";
import { add } from "./calculator.js";


//하나의 테스트 케이스 작성할 때 사용하는 함수
//test(테스트 시나리오, 실제로 테스트를 수행하는 콜백함수)

test('배열 내 모든 숫자 요소들의 합을 구해야 한다', () => {
    const result = add([1, 2, 3]);

    expect(result.toBe(6));
});

// AAA 패턴(Arrange, Act, Assert)
test('AAA 패턴을 활용하여 작성', () => {
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
