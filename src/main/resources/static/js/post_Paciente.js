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


window.addEventListener('load', () => {
    getDomicilios();
    const formulario = document.querySelector('#add_new_paciente');
    formulario.addEventListener('submit', (e) =>{
        e.preventDefault();

        const formData = {
            nombre: document.querySelector('#nombre').value,
            apellido: document.querySelector('#apellido').value,
            dni: document.querySelector('#dni').value,
            email: document.querySelector('#email').value,
            fechaAlta: document.querySelector('#fecha').value,
            domicilio:{
                id: parseInt(document.querySelector('#domicilio').value)
            }
        }

        const URL = '/pacientes'; //reemplazar en Java
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
            '<strong></strong> Paciente agregado </div>';
          let response = document.querySelector('#response');
          response.innerHTML=successModal;
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
});