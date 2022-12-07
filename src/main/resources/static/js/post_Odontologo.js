window.addEventListener('load', () => {
    const formulario = document.querySelector('#add_new_odontologo');
    formulario.addEventListener('submit', (e) =>{
        e.preventDefault();

        const formData = {
            nombre: document.querySelector('#nombre').value,
            apellido: document.querySelector('#apellido').value,
            matricula: document.querySelector('#matricula').value
        }

        const URL = '/odontologos';
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
            '<strong></strong> Odontólogo agregado </div>';
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