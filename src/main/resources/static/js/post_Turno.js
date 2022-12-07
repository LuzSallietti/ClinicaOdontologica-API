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
    const URL = '/odontologos'; //reemplazar en Java
    const settings = {
        method:'GET'
    }
    fetch(URL,settings)
    .then(response => response.json())
    .then(data => showOdontologos(data))
    .catch(error => console.log(error))
}
const getPacientes = () => {
    const URL = '/pacientes'; //reemplazar en Java
    const settings = {
        method:'GET'
    }
    fetch(URL,settings)
    .then(response => response.json())
    .then(data => showPacientes(data))
    .catch(error => console.log(error))
}

window.addEventListener('load', () => {
    getOdontologos();
    getPacientes();
    const formulario = document.querySelector('#add_new_turno');
    formulario.addEventListener('submit', (e) => {
        e.preventDefault();

        const formData = {
            paciente:{
                id: parseInt(document.querySelector('#paciente').value)
            },
            odontologo:{
                id: parseInt(document.querySelector('#odontologo').value)
            },
            fecha: document.querySelector('#fecha').value,
            hora: document.querySelector('#hora').value          
        }
        console.log(formData); //OK

        const URL = '/turnos'; //reemplazar en Java
        const settings = {
            method: 'POST',
            headers: {
                'Content-Type': 'Application/json',
            },
            body:JSON.stringify(formData)
        }

        fetch(URL, settings)
        .then(reponse => reponse.json())
        .then(data => { 
            let successModal='<div class="alert alert-success alert-dismissible">' +
            '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
            '<strong></strong> Turno agregado </div>';
          let response = document.querySelector('#response');
          response.innerHTML = successModal;
          response.style.display = 'block';
          formulario.reset();
        })
        .catch(error => {
            let errorAlert = '<div class="alert alert-danger alert-dismissible">' +
            '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
            '<strong> Error. Intente nuevamente</strong> </div>';

            let response = document.querySelector('#response').innerHTML = errorAlert;
            response.style.display = "block";
            formulario.reset();
        })

    }) 
})
