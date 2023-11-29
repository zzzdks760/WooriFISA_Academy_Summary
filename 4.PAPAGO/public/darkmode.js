// dark mode 토글 버튼
const checkbox = document.getElementById('checkbox');

// dark mode 적용하기 위해 태그를 가져오고, <html>에 class="dark"를 적용해야함
const html = document.querySelector('html');

// 삼항연산자 checkbox의 값이 checked로 변경되면 class="dark" 옵션 추가
// 그렇지 않을 경우, class="dark" 옵션을 제거

checkbox.addEventListener('click', () => {
    checkbox.checked ? html.classList.add('dark') : html.classList.remove('dark')
});