async function emailDupleCheckFromServer(emailVal){
    try {
        const url = "/member/dupleCheck";
        const config = {
            method : 'post',
            headers : {
                'header' : document.querySelector('meta[name="_csrf_header"]').content,
                'Content-Type' : 'application/json; charset=utf-8',        
                'X-XSRF-Token' : document.querySelector('meta[name="_csrf"]').content
  
            },
            body : JSON.stringify({email : emailVal})
        }
        const resp = await fetch(url, config);
        const result =await resp.text();
        return result;
    } catch (error) {
        console.log(error);
    }
}


document.getElementById("dupleCheck").addEventListener('click', (e)=>{
    e.preventDefault();
    let emailInputed = document.getElementById('email');
    let emailVal = emailInputed.value;
    console.log(emailVal);
    if(emailVal == ''){
        alert("가입할 이메일을 입력하세요!");
        emailInputed.focus();
        return;
    } else {
        emailDupleCheckFromServer(emailVal).then(result =>{
            console.log(result);
            if(parseInt(result)){
                alert("이미 사용중인 이메일 주소입니다.");
                emailInputed.value = "";
                emailInputed.focus();
            } else {
                alert("사용 가능한 이메일 주소입니다.");
                document.getElementById("pwd").focus();
            }
        });
    }
})