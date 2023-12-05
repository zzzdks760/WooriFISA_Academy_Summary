/**
 * numbers 배열 요소와 합을 구하여 반환하는 함수
 */

export const add = (numbers) => {
    let sum = 0;
    for (const number of numbers) {
        sum += number;
    }
    return sum;
}