async function delectItemOfServer(ino){
    try {
        const url =`http://mosncks.dothome.co.kr/api/items/delete`;
        const config = {
          method : `POST`,
          headers: {
              'Accept':'application/json',
              'Content-type':'application/x-www-form-urlencoded'
          },
          body : JSON.stringify({id:ino})
        };
        const resp = await fetch(url, config);
        const result = await resp.json();
        return await result;
    } catch (error) {
        console.log(error);
    }
}


document.getElementById(`delBtn`).addEventListener(`click`, (e)=>{
    e.preventDefault();
    // let ino = e.target.dataset.ino;
    // let ino = document.getElementById(`id`).value;

    delectItemOfServer(e.target.dataset.ino).then(result => {
        console.log(result);
        alert(result.message);
        debugger;
        location.replace(`index.html`);
    });
});



document.addEventListener(`DOMContentLoaded`, () =>{
    // console.log(location.search);
    let queryString = location.search; // 주소표시줄 뒤에 ?.... 가져옴
    let ino = queryString.substring(queryString.indexOf(`=`)+1);
    document.getElementById(`delBtn`).dataset.ino=ino;
    

    getItemViewFromServer(ino).then(result =>{
        // console.log(result.items[0]);
        const item = result.items[0];
        const inputs = document.querySelectorAll(`.needs-validation input`);

        inputs.forEach(input=> {
            input.value = item[input.id];
        }); 

        // document.getElementById(`id`).value = item.id; //ino
        // document.getElementById(`name`).value =item.name;
        // document.getElementById(`price`).value =item.price;
        // document.getElementById(`description`).value =item.description;
        let optionList = document.querySelectorAll(`#category option`);
        optionList.forEach(option => {
            if(option.value == item.category_id){
                option.setAttribute(`selected`, true);
            }
        });
    });

});


async function getItemViewFromServer(ino) {
    try {
        const resp= await fetch("http://mosncks.dothome.co.kr/api/items/read/"+ino)
        const respText = await resp.text();
        const itemObj = await JSON.parse(respText);
        return await itemObj;
    } catch (error) {
        console.log(error);
    }
}

async function updateItemToServer(itemObj) {
    try {
      const url =`http://mosncks.dothome.co.kr/api/items/update`;
      const config = {
        method : `POST`,
        headers: {
            'Accept':'application/json',
            'Content-type':'application/x-www-form-urlencoded'
        },
        body : JSON.stringify(itemObj)
      };
      const resp = await fetch(url, config);
      const result = await resp.json();
      return await result;
    } catch (error) {
        console.log(error);
    } 
}




document.querySelector(`button.w-100.btn`).addEventListener(`click`, (e)=>{
    e.preventDefault();
    const inputs = document.querySelectorAll(`.needs-validation input`);
    let itemObj = {};
    // itemObj.id = ino;
    
    inputs.forEach(elem => {
        itemObj[elem.id] = elem.value;
    });
    itemObj.category_id = document.querySelector(`#category option:checked`).value;

    const now = new Date();
    let createNow = `${now.getFullYear()}-${now.getMonth()+1}-${now.getDate()} ${now.getHours()}:${now.getMinutes()}:${now.getSeconds()}`;
    itemObj.modified = createNow;
    console.log(itemObj);

    updateItemToServer(itemObj).then(result => {
        console.log(result);
        alert(result.message);
    });

});


