window.addEventListener('load', () => {
    const formulario = document.querySelector('#add_new_address');
    formulario.addEventListener('submit', (e) =>{
        e.preventDefault();

        const formData = {
            calle: document.querySelector('#calle').value,
            numero: document.querySelector('#numero').value,
            localidad: document.querySelector('#localidad').value,
            provincia: document.querySelector('#provincia').value
        }
        
        const URL = '/domicilios';
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
            '<strong></strong> Domicilio agregado </div>';
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