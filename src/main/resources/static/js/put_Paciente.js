const showDomicilios = (domicilios) => {
    const select = document.querySelector('#domicilio');
    domicilios.forEach(domicilio => {
        let option = document.createElement('option');
        option.setAttribute('value', domicilio.id);
        option.innerText = `${domicilio.calle} ${domicilio.numero} - ${domicilio.localidad} - ${domicilio.provincia}`;
        select.appendChild(option);
        
    });
}

const getDomicilios = () => {
    const URL = '/domicilios';
    const settings = {
        method:'GET'
    }
    fetch(URL,settings)
    .then(response => response.json())
    .then(data => showDomicilios(data))
    .catch(error => console.log(error))
}


window.addEventListener('load', function () {
    getDomicilios();
    const formulario = document.querySelector('#update_paciente_form');
    formulario.addEventListener('submit', function (event) {
        event.preventDefault();
        let id_param = document.querySelector('#paciente_id').value;
        console.log(id_param)        
        
        const formData = {
            id: document.querySelector('#paciente_id').value,
            nombre: document.querySelector('#nombre').value,
            apellido: document.querySelector('#apellido').value,
            dni: document.querySelector('#dni').value,
            email: document.querySelector('#email').value,
            fechaAlta: document.querySelector('#fecha').value,
            domicilio:{
                id: parseInt(document.querySelector('#domicilio').value)
            }

        };
        const url = '/pacientes/';
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
            '<strong></strong> Paciente modificado. </div>';
            let response = document.querySelector('#response');
            response.innerHTML=successModal;
            response.style.display = 'block';
          })
          .catch(error => alert(error))

        
 })
})
    const findBy = (id) => {
          const url = '/pacientes/'+id;
          const settings = {
              method: 'GET'
          }
          fetch(url,settings)
          .then(response => response.json())
          .then(data => {
              let paciente = data;
              document.querySelector('#paciente_id').value = paciente.id;
              document.querySelector('#nombre').value = paciente.nombre;
              document.querySelector('#apellido').value = paciente.apellido;
              document.querySelector('#dni').value = paciente.dni;
              document.querySelector('#email').value = paciente.email;
              document.querySelector('#fecha').value=paciente.fechaAlta;
              document.querySelector('#domicilio').value = paciente.domicilio.id;           

            //el formulario por default esta oculto y al editar se habilita
              document.querySelector('#div_paciente_updating').style.display = "block";
          }).catch(error => {
              alert("Error: " + error);
          })
          
      }
      //refrescar los resultados actualizados
      const reload = () => window.location.reload();