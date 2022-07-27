

async function getCommentListFromServer() {
    try {
      const resp = await fetch('/cfcheck/list');
      const cfmenuList = await resp.json();
      return await cfmenuList;
    } catch (error) {
      console.log(error);
    }
  }




function spreadCommentList(result) {
    let div = document.getElementById("menu_list");
    div.innerHTML = '';
    for (let i = 0; i < result.length; i++) {
        if(result[i].sal == 1) {
          let html =`<div class="col mb-5">`;
          html += `<div class="card h-50">`;
      
          html += `<div class="badge bg-dark text-white position-absolute " `;
          html += `style="top: 0.5rem; right: 0.5rem">Sal</div>`;
       
          html += `<img class="card-img-top" src="/_fileUpload/th_${result[i].image_file}" alt="..." />`;
      
          html += `<div class="card-body p-4">`;
          html += `<div class="text-center">`;
       
          html += `<h5 class="fw-bolder">${result[i].name}</h5>`;
        
          html += `<div class="d-flex justify-content-center small text-warning mb-2">`;
          html += `<div class="bi-star-fill"></div>`;
          html += `<div class="bi-star-fill"></div>`;
          html += `<div class="bi-star-fill"></div>`;
          html += `<div class="bi-star-fill"></div>`;
          html += `<div class="bi-star-fill"></div>`;
          html += `</div>`;
         
          html += `<span class="text-muted">Price : ${result[i].price}</span>`;
          html += `</div>`;
          html += `</div>`;
       
          html += `<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">`;
          html += `<div class="text-center">`;
          html += `<form action="/cfo/cart_ss" method="post">`;
          html += `<input type="hidden" name="pno" value="${result[i].pno}">`;
          
          html += `<button class="btn btn-dark mt-auto cart_go" type="submit">Add to cart</button>`;
          
          html += `</form>`;
          html += `</div>`;
          html += `</div>`;
          html += `</div>`;
          html += `</div>`;
          console.log("판매중");
          div.innerHTML += html;
            
        } else{
            let html = `<div class="col mb-5">`;
          html += `<div class="card h-50">`;
            
            html += `<div class="badge bg-danger text-white position-absolute"`;
            html += `style="top: 0.5rem; right: 0.5rem">Sold Out</div>`;
            
            html += `<img class="card-img-top" src="/_fileUpload/th_${result[i].image_file}" alt="..." />`;
            
            html += `<div class="card-body p-4">`;
            html += `<div class="text-center">`;
            
            html += `<h5 class="fw-bolder">${result[i].name}</h5>`;
            
            html += `<div `;
            html += `class="d-flex justify-content-center small text-warning mb-2">`;
            html += `<div class="bi-star-fill"></div>`;
            html += `<div class="bi-star-fill"></div>`;
            html += `<div class="bi-star-fill"></div>`;
            html += `<div class="bi-star-fill"></div>`;
            html += `<div class="bi-star-fill"></div>`;
            html += `</div>`;
            
            html += `<span class="text-muted">Price : ${result[i].price}</span>`;
            html += `</div>`;
            html += `</div>`;
            
            html += `<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">`;
            html += `<div class="text-center">`;
            
            html += `<a class="btn btn-danger mt-auto disabled" href="/cfo/cart_ss?pno=${result[i].pno}">Sold Out</a>`;
            html += `</div>`;
            html += `</div>`;
            html += `</div>`;
            html += `</div>`;
            console.log("판매종료");
            div.innerHTML += html;
        }
    }
  }

  function coffeelist(result){
    let div = document.getElementById("menu_list");
    div.innerHTML = '';
    for (let i = 0; i < result.length; i++) {
        if(result[i].sal == 1 && result[i].kind == 1) {
          let html =`<div class="col mb-5">`;
          html += `<div class="card h-50">`;
      
          html += `<div class="badge bg-dark text-white position-absolute " `;
          html += `style="top: 0.5rem; right: 0.5rem">Sal</div>`;
       
          html += `<img class="card-img-top" src="/_fileUpload/th_${result[i].image_file}" alt="..." />`;
      
          html += `<div class="card-body p-4">`;
          html += `<div class="text-center">`;
       
          html += `<h5 class="fw-bolder">${result[i].name}</h5>`;
        
          html += `<div class="d-flex justify-content-center small text-warning mb-2">`;
          html += `<div class="bi-star-fill"></div>`;
          html += `<div class="bi-star-fill"></div>`;
          html += `<div class="bi-star-fill"></div>`;
          html += `<div class="bi-star-fill"></div>`;
          html += `<div class="bi-star-fill"></div>`;
          html += `</div>`;
         
          html += `<span class="text-muted">Price : ${result[i].price}</span>`;
          html += `</div>`;
          html += `</div>`;
       
          html += `<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">`;
          html += `<div class="text-center">`;
          html += `<form action="/cfo/cart_ss" method="post">`;
          html += `<input type="hidden" name="pno" value="${result[i].pno}">`;
          
          html += `<button class="btn btn-dark mt-auto cart_go" type="submit">Add to cart</button>`;
          
          html += `</form>`;
          html += `</div>`;
          html += `</div>`;
          html += `</div>`;
          html += `</div>`;
          console.log("판매중");
          div.innerHTML += html;
            
        } else if(result[i].sal == 2 && result[i].kind == 1){
            let html = `<div class="col mb-5">`;
          html += `<div class="card h-50">`;
            
            html += `<div class="badge bg-danger text-white position-absolute"`;
            html += `style="top: 0.5rem; right: 0.5rem">Sold Out</div>`;
            
            html += `<img class="card-img-top" src="/_fileUpload/th_${result[i].image_file}" alt="..." />`;
            
            html += `<div class="card-body p-4">`;
            html += `<div class="text-center">`;
            
            html += `<h5 class="fw-bolder">${result[i].name}</h5>`;
            
            html += `<div `;
            html += `class="d-flex justify-content-center small text-warning mb-2">`;
            html += `<div class="bi-star-fill"></div>`;
            html += `<div class="bi-star-fill"></div>`;
            html += `<div class="bi-star-fill"></div>`;
            html += `<div class="bi-star-fill"></div>`;
            html += `<div class="bi-star-fill"></div>`;
            html += `</div>`;
            
            html += `<span class="text-muted">Price : ${result[i].price}</span>`;
            html += `</div>`;
            html += `</div>`;
            
            html += `<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">`;
            html += `<div class="text-center">`;
            
            html += `<a class="btn btn-danger mt-auto disabled" href="/cfo/cart_ss?pno=${result[i].pno}">Sold Out</a>`;
            html += `</div>`;
            html += `</div>`;
            html += `</div>`;
            html += `</div>`;
            console.log("판매종료");
            div.innerHTML += html;
        }
    }
  }
  
  function juice_smoth_list(result){
    let div = document.getElementById("menu_list");
    div.innerHTML = '';
    for (let i = 0; i < result.length; i++) {
        if(result[i].sal == 1 && result[i].kind == 2) {
          let html =`<div class="col mb-5">`;
          html += `<div class="card h-50">`;
      
          html += `<div class="badge bg-dark text-white position-absolute " `;
          html += `style="top: 0.5rem; right: 0.5rem">Sal</div>`;
       
          html += `<img class="card-img-top" src="/_fileUpload/th_${result[i].image_file}" alt="..." />`;
      
          html += `<div class="card-body p-4">`;
          html += `<div class="text-center">`;
       
          html += `<h5 class="fw-bolder">${result[i].name}</h5>`;
        
          html += `<div class="d-flex justify-content-center small text-warning mb-2">`;
          html += `<div class="bi-star-fill"></div>`;
          html += `<div class="bi-star-fill"></div>`;
          html += `<div class="bi-star-fill"></div>`;
          html += `<div class="bi-star-fill"></div>`;
          html += `<div class="bi-star-fill"></div>`;
          html += `</div>`;
         
          html += `<span class="text-muted">Price : ${result[i].price}</span>`;
          html += `</div>`;
          html += `</div>`;
       
          html += `<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">`;
          html += `<div class="text-center">`;
          html += `<form action="/cfo/cart_ss" method="post">`;
          html += `<input type="hidden" name="pno" value="${result[i].pno}">`;
          
          html += `<button class="btn btn-dark mt-auto cart_go" type="submit">Add to cart</button>`;
          
          html += `</form>`;
          html += `</div>`;
          html += `</div>`;
          html += `</div>`;
          html += `</div>`;
          console.log("판매중");
          div.innerHTML += html;
            
        } else if (result[i].sal == 2 && result[i].kind == 2){
            let html = `<div class="col mb-5">`;
          html += `<div class="card h-50">`;
            
            html += `<div class="badge bg-danger text-white position-absolute"`;
            html += `style="top: 0.5rem; right: 0.5rem">Sold Out</div>`;
            
            html += `<img class="card-img-top" src="/_fileUpload/th_${result[i].image_file}" alt="..." />`;
            
            html += `<div class="card-body p-4">`;
            html += `<div class="text-center">`;
            
            html += `<h5 class="fw-bolder">${result[i].name}</h5>`;
            
            html += `<div `;
            html += `class="d-flex justify-content-center small text-warning mb-2">`;
            html += `<div class="bi-star-fill"></div>`;
            html += `<div class="bi-star-fill"></div>`;
            html += `<div class="bi-star-fill"></div>`;
            html += `<div class="bi-star-fill"></div>`;
            html += `<div class="bi-star-fill"></div>`;
            html += `</div>`;
            
            html += `<span class="text-muted">Price : ${result[i].price}</span>`;
            html += `</div>`;
            html += `</div>`;
            
            html += `<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">`;
            html += `<div class="text-center">`;
            
            html += `<a class="btn btn-danger mt-auto disabled" href="/cfo/cart_ss?pno=${result[i].pno}">Sold Out</a>`;
            html += `</div>`;
            html += `</div>`;
            html += `</div>`;
            html += `</div>`;
            console.log("판매종료");
            div.innerHTML += html;
        }
    }
  }

  

  function snack_list(result){
    let div = document.getElementById("menu_list");
    div.innerHTML = '';
    for (let i = 0; i < result.length; i++) {
        if(result[i].sal == 1 && result[i].kind == 3) {
          let html =`<div class="col mb-5">`;
          html += `<div class="card h-50">`;
      
          html += `<div class="badge bg-dark text-white position-absolute " `;
          html += `style="top: 0.5rem; right: 0.5rem">Sal</div>`;
       
          html += `<img class="card-img-top" src="/_fileUpload/th_${result[i].image_file}" alt="..." />`;
      
          html += `<div class="card-body p-4">`;
          html += `<div class="text-center">`;
       
          html += `<h5 class="fw-bolder">${result[i].name}</h5>`;
        
          html += `<div class="d-flex justify-content-center small text-warning mb-2">`;
          html += `<div class="bi-star-fill"></div>`;
          html += `<div class="bi-star-fill"></div>`;
          html += `<div class="bi-star-fill"></div>`;
          html += `<div class="bi-star-fill"></div>`;
          html += `<div class="bi-star-fill"></div>`;
          html += `</div>`;
         
          html += `<span class="text-muted">Price : ${result[i].price}</span>`;
          html += `</div>`;
          html += `</div>`;
       
          html += `<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">`;
          html += `<div class="text-center">`;
          html += `<form action="/cfo/cart_ss" method="post">`;
          html += `<input type="hidden" name="pno" value="${result[i].pno}">`;
          
          html += `<button class="btn btn-dark mt-auto cart_go" type="submit">Add to cart</button>`;
          
          html += `</form>`;
          html += `</div>`;
          html += `</div>`;
          html += `</div>`;
          html += `</div>`;
          console.log("판매중");
          div.innerHTML += html;
            
        } else if(result[i].sal == 2 && result[i].kind == 3){
            let html = `<div class="col mb-5">`;
          html += `<div class="card h-50">`;
            
            html += `<div class="badge bg-danger text-white position-absolute"`;
            html += `style="top: 0.5rem; right: 0.5rem">Sold Out</div>`;
            
            html += `<img class="card-img-top" src="/_fileUpload/th_${result[i].image_file}" alt="..." />`;
            
            html += `<div class="card-body p-4">`;
            html += `<div class="text-center">`;
            
            html += `<h5 class="fw-bolder">${result[i].name}</h5>`;
            
            html += `<div `;
            html += `class="d-flex justify-content-center small text-warning mb-2">`;
            html += `<div class="bi-star-fill"></div>`;
            html += `<div class="bi-star-fill"></div>`;
            html += `<div class="bi-star-fill"></div>`;
            html += `<div class="bi-star-fill"></div>`;
            html += `<div class="bi-star-fill"></div>`;
            html += `</div>`;
            
            html += `<span class="text-muted">Price : ${result[i].price}</span>`;
            html += `</div>`;
            html += `</div>`;
            
            html += `<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">`;
            html += `<div class="text-center">`;
            
            html += `<a class="btn btn-danger mt-auto disabled" href="/cfo/cart_ss?pno=${result[i].pno}">Sold Out</a>`;
            html += `</div>`;
            html += `</div>`;
            html += `</div>`;
            html += `</div>`;
            console.log("판매종료");
            div.innerHTML += html;
        }
    }
  }


  
  function printCommentList(){
    console.log("자바스크립트 실행");
    getCommentListFromServer().then(result => {
      console.log(result);
      if(result.length > 0) {
        spreadCommentList(result);
      }else {
        let div = document.getElementById("menu_list");
        div.innerHTML = '메뉴가 없습니다. 메뉴를 추가해주세요.';
      }
    });
  }
  document.getElementById(`btnradio_all`).addEventListener('click', (e)=>{
    getCommentListFromServer().then(result => {
      if(result.length > 0) {
        spreadCommentList(result);
      }else {
        let div = document.getElementById("menu_list");
        div.innerHTML = '메뉴가 없습니다. 메뉴를 추가해주세요.';
      }
    });
  })
  
  document.getElementById(`btnradio1`).addEventListener('click', (e)=>{
    getCommentListFromServer().then(result => {
      if(result.length > 0) {
        coffeelist(result);
      }else {
        let div = document.getElementById("menu_list");
        div.innerHTML = '메뉴가 없습니다. 메뉴를 추가해주세요.';
      }
    });
  })

  document.getElementById(`btnradio2`).addEventListener('click', (e)=>{
    getCommentListFromServer().then(result => {
      if(result.length > 0) {
        juice_smoth_list(result);
      }else {
        let div = document.getElementById("menu_list");
        div.innerHTML = '메뉴가 없습니다. 메뉴를 추가해주세요.';
      }
    });
  })

  document.getElementById(`btnradio3`).addEventListener('click', (e)=>{
    getCommentListFromServer().then(result => {
      if(result.length > 0) {
        snack_list(result);
      }else {
        let div = document.getElementById("menu_list");
        div.innerHTML = '메뉴가 없습니다. 메뉴를 추가해주세요.';
      }
    });
  })
