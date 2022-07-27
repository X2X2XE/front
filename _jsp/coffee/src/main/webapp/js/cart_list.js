let val = 1;
document.getElementById('number_minus').addEventListener('click', (e)=>{
    document.getElementById('the_number').value -= 1;
})
document.getElementById('number_plus').addEventListener('click', (e)=>{
    
    document.getElementById('the_number').value = parseInt(document.getElementById('the_number').value)+1;
})





