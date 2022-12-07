window.addEventListener('load', () => {
    const URL = '/turnos';
    const settings = {
        method:'GET'
    }
    fetch(URL,settings)
    .then(response => response.json())
    .then(data => {
        let table = document.querySelector('#turnoTable');
        data.forEach(turno => {
            console.log(turno)
            //crear fila
            let row = table.insertRow();
            let tr_id ='tr-'+turno.id;
            row.id = tr_id;

            //boton delete de cada fila
            let deleteButton = '<button' +
                                      ' id=' + '\"' + 'btn_delete_' + turno.id + '\"' +
                                      ' type="button" onclick="deleteBy('+turno.id+')" class="btn btn-danger btn_delete">' +
                                      '&times' +
                                      '</button>';
            
            //boton update de cada fila
            let updateButton = '<button' +
                                      ' id=' + '\"' + 'btn_id_' + turno.id + '\"' +
                                      ' type="button" onclick="findBy('+turno.id+')" class="btn btn-info btn_id">' +
                                      turno.id +
                                      '</button>';
            
            //insertar la fila en DOM
            row.innerHTML = '<td>' + updateButton + '</td>' +
                              '<td class=\"td_fecha\">' + turno.fecha.split('-').reverse().join("-") + '</td>' +
                              '<td class=\"td_hora\">' + turno.hora + '</td>' +
                              '<td class=\"td_paciente\">' + turno.paciente.nombre.toUpperCase() + " " + turno.paciente.apellido.toUpperCase() + '</td>' +
                              '<td class=\"td_odontologo\">' + turno.odontologo.nombre.toUpperCase() + " " + turno.odontologo.apellido.toUpperCase() + '</td>' +                              
                              '<td>' + deleteButton + '</td>';
            
        })
    })
})