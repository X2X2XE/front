async function getRepliesListFromServer(pno) {
  try {
    const resp=await fetch(`/rep/list/`+pno);
    const replist =await resp.json();
    return replist;
  } catch (error) {
    console.log(error);
  }
}

function spreadRepliesList(result){
    let div = document.getElementById("accordionExample");
    div.innerHTML = '';
    for (let i = 0; i < result.length; i++) {
      let html = `<div class="accordion-item">`;
      html += `<h2 class="accordion-header" id="headingOne${i}">`;
        html += `<button class="accordion-button" type="button"`;
          html += `data-bs-toggle="collapse" data-bs-target="#collapseOne${i}"`;
          html += `aria-expanded="true" aria-controls="collapseOn${i}"> ${result[i].rno}, ${result[i].pno}, ${result[i].replier} </button> </h2>`;

      html += `<div id="collapseOne" class="accordion-collapse${i} collapse show"`;
        html += `aria-labelledby="headingOne${i}" data-bs-parent="#accordionExample">`;
        html += `<div class="accordion-body">`;
        html += `<button type="button" data-rno="${result[i].rno}" class="btn btn-sm btn-outline-warning repModBtn">%</button>`;
        html += `<button type="button" data-rno="${result[i].rno}" class="btn btn-sm btn-outline-danger repDelBtn">X</button>`;
        html += `<input type="text" class="form-control" id="repText" value="${result[i].reply}">`; 
        html += `${result[i].mod_at}`;
        html += `</div> </div></div>`;
        div.innerHTML += html;
      
    }
}


function printRepliesList(pno){
  getRepliesListFromServer(pno).then(result => {
    console.log(result);
    if(result.length > 0){
      spreadRepliesList(result);
    }else {
      let div = document.getElementById("accordionExample");
      div.innerHTML ='댓글이 없습니다';
      //html로 list가 존재하지 않습니다. 표현
    }
  });
}


async function updateRepliesToServer(rnoVal,repText){
  try {
    const url = "/rep/modify";
    const config = {
      method : 'post',
      headers : {
        'Content-Type' : 'application/json; charset=utf-8'
      },
      body : JSON.stringify({rno:rnoVal, reply:repText})      
    };
    const resp = await fetch(url, config);
    const result  = await resp.text();
    return result;
  }catch (error){
    console.log(error);
  }
}

async function removeRepliesFromServer(rnoVal){
  try {
    const url = "/rep/remove/" + rnoVal;
    const config = {
      method : 'post',     
    };
    const resp = await fetch(url, config);
    const result  = await resp.text();
    return result;
  }catch (error){
    console.log(error);
  }
}


document.addEventListener(`click`, (e) => {
  if(e.target.classList.contains('repModBtn')) {
    let rnoVal = e.target.dataset.rno;
    let div = e.target.closest('div');
    let repText = div.querySelector('#repText').value;
    updateRepliesToServer(rnoVal,repText).then(result =>{
      if(result > 0){
        alert("댓글 수정 성공!");
        printRepliesList(pnoVal);
      }
    });
  }
  if(e.target.classList.contains(`repDelBtn`)){
    let rnoVal = e.target.dataset.rno;
    // 필요한 cnoVal변수 얻기
    removeRepliesFromServer(rnoVal).then(result => {
      if(result > 0){
        alert("댓글 삭제 성공!");
        printRepliesList(pnoVal);
      } 

    });
  }
})



async function postRepliesToServer(repData){
  try {
    const url = "/rep/post";
    const config = {
      method : 'post',
      headers : {
        'Content-Type' : 'application/json; charset=utf-8'
      },
      body : JSON.stringify(repData)      
    };
    const resp = await fetch(url, config);
    const result  = await resp.text();
    return result;
  }catch (error){
    console.log(error);
  }
}

document.getElementById('repAddBtn').addEventListener('click', () => {
  const repText = document.getElementById('repText').value;
  if(repText == null || repText == ''){
    alert('댓글 내용을 입력해 주세요!');
    return false;
  }else {
    let repData = {
      pno : pnoVal,
      replier : document.getElementById('repWriter').innerText,
      reply : repText
    };
    postRepliesToServer(repData).then(result => {
      if(result > 0) {
        alert('댓글 등록 성공!');
        document.getElementById('repText').value = "";
      }
      printRepliesList(repData.pno);
    });
  }
});