var user = {
    us_name : ``,
    us_visit : ``,
    us_favor1 : ``,
    us_favor2 : ``,
    us_favor3 : ``,
    us_mail : ``,
    us_pet : ``,
    us_wish : ``,
}
function save() {
    user.us_name = document.getElementById(`name`).value;
    user.us_visit = document.getElementById(`visit`).value;
    user.us_favor1 = document.getElementById(`favor1`).value;
    user.us_favor2 = document.getElementById(`favor2`).value;
    user.us_favor3 = document.getElementById(`favor3`).value;
    user.us_mail = document.getElementById(`mail`).value;
    user.us_pet = document.getElementById(`pet`).value;
    user.us_wish = document.getElementById(`wish`).value;
    
    console.log(user);
};

function print() {
    
    let name = user.us_name;
    let visit = user.us_visit;
    let favor1 = user.us_favor1;
    let favor2 = user.us_favor2;
    let favor3 = user.us_favor3;
    let mail = user.us_mail;
    let pet = user.us_pet;
    let wish = user.us_wish;
    document.getElementById(`print`).innerText=`${name}-${visit}-${favor1}-${favor2}-${favor3}-${mail}-${pet}-${wish}`;
}