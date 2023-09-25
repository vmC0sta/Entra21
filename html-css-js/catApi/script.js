function inserirImg(){

    fetch('https://api.thecatapi.com/v1/images/search')
    .then((dados)=> dados.json())
    .then((response) => {
        console.log(response[0].url)
        let image = document.getElementsByTagName('img')[0] 
        image.src = response[0].url
        image.width = 500
        image.height = 300
        image.alt = response[0].alt
    })
    
}

setInterval(inserirImg, 100);