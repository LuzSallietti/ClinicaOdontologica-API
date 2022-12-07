window.addEventListener('load', () => {
    const URL = '/domicilios';
    const settings = {
        method:'GET'
    }
    fetch(URL,settings)
    .then(response => response.json())
    .then(data => {
        let table = document.querySelector('#addressTable');
        data.forEach(domicilio => {
            console.log(domicilio)
            //crear fila
            let row = table.insertRow();
            let tr_id ='tr-'+ domicilio.id;
            row.id = tr_id;

            //boton delete de cada fila
            let deleteButton = '<button' +
                                      ' id=' + '\"' + 'btn_delete_' + domicilio.id + '\"' +
                                      ' type="button" onclick="deleteBy('+domicilio.id+')" class="btn btn-danger btn_delete">' +
                                      '&times' +
                                      '</button>';
            
            //boton update de cada fila
            let updateButton = '<button' +
                                      ' id=' + '\"' + 'btn_id_' + domicilio.id + '\"' +
                                      ' type="button" onclick="findBy('+domicilio.id+')" class="btn btn-info btn_id">' +
                                      domicilio.id +
                                      '</button>';
            
            //insertar la fila en DOM
            row.innerHTML = '<td>' + updateButton + '</td>' +
                              '<td class=\"td_street\">' + domicilio.calle.toUpperCase() + '</td>' +
                              '<td class=\"td_number\">' + domicilio.numero + '</td>' +
                              '<td class=\"td_city\">' + domicilio.localidad.toUpperCase() + '</td>' +
                              '<td class=\"td_state\">' + domicilio.provincia.toUpperCase() + '</td>' +
                              '<td>' + deleteButton + '</td>';
            
        })
    })
})