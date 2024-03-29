async function removeFileAtServer(uuid){
    try {
        const url = "/product/file/"+uuid;
        const config = {
            method : 'delete'
        }
        const resp = await fetch(url, config);
        const result =await resp.text();
        return result;
    } catch (error) {
        console.log(error);
    }
}



document.addEventListener('click',(e) =>{
    if(e.target.classList.contains('fileDelBtn')){
        removeFileAtServer(e.target.dataset.uuid).then(result => {
          console.log(result);
          alert('파일 삭제' + (parseInt(result) > 0? "완료" : "실패"));
          if(parseInt(result)){
              e.target.closest('li').remove();
          }
        });
    }

});

