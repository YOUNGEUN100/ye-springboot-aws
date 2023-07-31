// 생성 기능
const createButton = document.getElementById('btn');

if (createButton) {
    createButton.addEventListener('click', event => {
        fetch('/api/signup', {
            method: 'POST',
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({
                email: document.getElementById('email').value,
                password: document.getElementById('password').value
            })
        })
            .then(() => {
                alert('회원가입되었습니다.');
                location.replace('http://localhost:8080/login');
            });
    });
}