$(document).ready(function(){
    $("#btnExibir").click(()=>{
        let qtdeCadeiras = $("#qtdeCadeiras").val()
        let cadeiras = ''

        for(let i = 0; i < qtdeCadeiras;i++){
            cadeiras += `<button class="livre">${i + 1}</button>`
        }
        $("#sala").html(cadeiras)
        $("#livre").text(qtdeCadeiras)
        
    })


    $("button").click((item) =>{
        
        let classe =$(item.target).atrr('class')
        console.log(classe)
        classe == 'livre' ? $(item.target).atrr('class', 'ocupado') : $(item.target).atrr('class','livre')

    })

})
