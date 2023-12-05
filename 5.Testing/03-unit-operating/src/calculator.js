/**
 * numbers 배열 요소와 합을 구하여 반환하는 함수
 */

export const add = (numbers) => {

    let sum = 0;
    
    for (const number of numbers) {
        //공백이 입력될 경우
        sum += number;
    }
    
    return sum;
}