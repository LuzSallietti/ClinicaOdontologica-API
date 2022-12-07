const showOdontologos = (odontologos) => {
    const select = document.querySelector('#odontologo');
    odontologos.forEach(odontologo => {
        let option = document.createElement('option');
        option.setAttribute('value', odontologo.id);
        option.innerText = `${odontologo.nombre} ${odontologo.apellido}`;
        select.appendChild(option);
        
    });
}

const showPacientes = (pacientes) => {
    const select = document.querySelector('#paciente');
    pacientes.forEach(paciente => {
        let option = document.createElement('option');
        option.setAttribute('value', paciente.id);
        option.innerText = `${paciente.nombre} ${paciente.apellido}`;
        select.appendChild(option);
        
    });

}

const getOdontologos = () => {
    const URL = '/odontologos';
    const settings = {
        method:'GET'
    }
    fetch(URL,settings)
    .then(response => response.json())
    .then(data => showOdontologos(data))
    .catch(error => console.log(error))
}
const getPacientes = () => {
    const URL = '/pacientes';
    const settings = {
        method:'GET'
    }
    fetch(URL,settings)
    .then(response => response.json())
    .then(data => showPacientes(data))
    .catch(error => console.log(error))
}


window.addEventListener('load', function () {
    getPacientes();
    getOdontologos();
    const formulario = document.querySelector('#update_turno_form');
    formulario.addEventListener('submit', function (event) {
        event.preventDefault();
                
        const formData = {
            id: document.querySelector('#turno_id').value,
            paciente:{
                id: parseInt(document.querySelector('#paciente').value)
            },
            odontologo:{
                id: parseInt(document.querySelector('#odontologo').value)
            },           
            fecha: document.querySelector('#fecha').value,
            hora: document.querySelector('#hora').value
        };
        const url = '/turnos/';
        const settings = {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formData)
        }
          fetch(url,settings)
          .then(response => response.json())
          .then(data => {
            console.log(data)
            let successModal='<div class="alert alert-success alert-dismissible">' +
            '<button type="button" class="close" onclick="reload()" data-dismiss="alert">&times;</button>' +
            '<strong></strong> Turno modificado. </div>';
            let response = document.querySelector('#response');
            response.innerHTML=successModal;
            response.style.display = 'block';
          })
          .catch(error => alert(error))

        
 })
})

    const findBy = (id) => {
          const url = '/turnos/'+id;
          const settings = {
              method: 'GET'
          }
          fetch(url,settings)
          .then(response => response.json())
          .then(data => {
              let turno = data;
              document.querySelector('#turno_id').value = turno.id;
              document.querySelector('#fecha').value = turno.fecha;
              document.querySelector('#hora').value = turno.hora;
              document.querySelector('#paciente').value = turno.paciente.id;
              document.querySelector('#odontologo').value = turno.odontologo.id;                     

            //el formulario por default esta oculto y al editar se habilita
              document.querySelector('#div_turno_updating').style.display = "block";
          }).catch(error => {
              alert("Error: " + error);
          })
          
      }
      //refrescar los resultados actualizados
      const reload = () => window.location.reload();