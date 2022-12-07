window.addEventListener('load', () => {
    const URL = '/odontologos';
    const settings = {
        method:'GET'
    }
    fetch(URL,settings)
    .then(response => response.json())
    .then(data => {
        let table = document.querySelector('#odontologoTable');
        data.forEach(odontologo => {
            console.log(odontologo)
            //crear fila
            let row = table.insertRow();
            let tr_id ='tr-'+odontologo.id;
            row.id = tr_id;

            //boton delete de cada fila
            let deleteButton = '<button' +
                                      ' id=' + '\"' + 'btn_delete_' + odontologo.id + '\"' +
                                      ' type="button" onclick="deleteBy('+odontologo.id+')" class="btn btn-danger btn_delete">' +
                                      '&times' +
                                      '</button>';
            
            //boton update de cada fila
            let updateButton = '<button' +
                                      ' id=' + '\"' + 'btn_id_' + odontologo.id + '\"' +
                                      ' type="button" onclick="findBy('+odontologo.id+')" class="btn btn-info btn_id">' +
                                      odontologo.id +
                                      '</button>';
            
            //insertar la fila en DOM
            row.innerHTML = '<td>' + updateButton + '</td>' +
                              '<td class=\"td_name\">' + odontologo.nombre.toUpperCase() + '</td>' +
                              '<td class=\"td_lastname\">' + odontologo.apellido.toUpperCase() + '</td>' +
                              '<td class=\"td_matricula\">' + odontologo.matricula + '</td>' +                              
                              '<td>' + deleteButton + '</td>';
            
        })
    })
})