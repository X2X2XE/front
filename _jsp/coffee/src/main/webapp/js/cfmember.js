async function checktoServer(idVal){
    try {
        const url = "/cfcheck/check";
        const config = {
            method : 'post',
            headers : {
                'Content-Type' : 'application/json; charset=utf-8'
              },
              body : JSON.stringify({id:idVal})
        };
        
        const resp = await fetch(url, config);
        
        const result  = await resp.text();
        console.log(result);
        return result;
    } catch (error) {
        console.log(error);
    }
}


document.getElementById('check').addEventListener(`click`, (e) => {
    
    
        let id = document.getElementById('id_input').value;
        
        checktoServer(id).then(result => {
            console.log(result);
            if(result >0 ){
                alert("입력한 아이디가 존재합니다")
            } else{
                alert("입력한 아이디는 사용이 가능합니다");
                
            }
        });
    
})

