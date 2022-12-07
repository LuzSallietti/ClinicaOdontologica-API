window.addEventListener('load', () => {
    const URL = '/pacientes';
    const settings = {
        method:'GET'
    }
    fetch(URL,settings)
    .then(response => response.json())
    .then(data => {
        let table = document.querySelector('#pacienteTable');
        data.forEach(paciente => {
            console.log(paciente)
            //crear fila
            let row = table.insertRow();
            let tr_id ='tr-'+paciente.id;
            row.id = tr_id;

            //boton delete de cada fila
            let deleteButton = '<button' +
                                      ' id=' + '\"' + 'btn_delete_' + paciente.id + '\"' +
                                      ' type="button" onclick="deleteBy('+paciente.id+')" class="btn btn-danger btn_delete">' +
                                      '&times' +
                                      '</button>';
            
            //boton update de cada fila
            let updateButton = '<button' +
                                      ' id=' + '\"' + 'btn_id_' + paciente.id + '\"' +
                                      ' type="button" onclick="findBy('+paciente.id+')" class="btn btn-info btn_id">' +
                                      paciente.id +
                                      '</button>';
            
            //insertar la fila en DOM
            row.innerHTML = '<td>' + updateButton + '</td>' +
                              '<td class=\"td_name\">' + paciente.nombre.toUpperCase() + '</td>' +
                              '<td class=\"td_lastname\">' + paciente.apellido.toUpperCase() + '</td>' +
                              '<td class=\"td_dni\">' + paciente.dni + '</td>' +
                              '<td class=\"td_email\">' + paciente.email + '</td>' +
                              '<td class=\"td_fecha\">' + paciente.fechaAlta.split('-').reverse().join("-") + '</td>' +
                              '<td class=\"td_fecha\">' + paciente.domicilio.calle + ' ' + paciente.domicilio.numero + ' - ' + paciente.domicilio.localidad + '</td>' +
                              '<td>' + deleteButton + '</td>';
            
        })
    })
})