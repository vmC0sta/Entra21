$(document).ready(function(){
    $("#btnExibir").click(()=>{
        let qtdeCadeiras = $("#qtdeCadeiras").val()
        let cadeiras = ''
        for(let i  = 1; i <= qtdeCadeiras; i++){
          cadeiras += `<button class='livre'>${i}</button>`
        }
        $("#sala").html(cadeiras)
        //mostrar total de cadeiras disponiveis
        $("#livre").text(qtdeCadeiras)

        $("button").click((item)=>{
           //let classe = item.target.getAttribute("class")
           let classe = $(item.target).attr('class')
           classe == 'livre' ? $(item.target).attr('class','ocupado') : $(item.target).attr('class','livre')
           
           $("#livres").text(document.getElementsByClassName('livre').length)
           $("#ocupado").text(document.getElementsByClassName('ocupado').length)
        })
    })    
   
    
 });