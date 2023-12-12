/**
 * 
 * @param {String} title 
 * @param {String} summary
 * @returns {Boolean} 입력 폼 항목 중 하나라도 공백이 존재하지 않는지
 */
export const enteredTodoFormIsNotEmpty = (title, summary, category) => {
    if (title.trim().length === 0 || summary.trim().length === 0) 
        return false;

    return true;
}