window.addEventListener('load', function () {
    const formulario = document.querySelector('#update_address_form');
    formulario.addEventListener('submit', function (event) {
        event.preventDefault();
        let id_param = document.querySelector('#address_id').value;
        console.log(id_param)        
        
        const formData = {
            id: document.querySelector('#address_id').value,
            calle: document.querySelector('#calle').value,
            numero: document.querySelector('#numero').value,
            localidad: document.querySelector('#localidad').value,
            provincia: document.querySelector('#provincia').value

        };
        const url = '/domicilios/'; //reemplazar en Java
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
            '<strong></strong> Domicilio modificado. </div>';
            let response = document.querySelector('#response');
            response.innerHTML=successModal;
            response.style.display = 'block';
          })
          .catch(error => alert(error))

        
 })
})
    const findBy = (id) => {
          const url = '/domicilios/'+id;
          const settings = {
              method: 'GET'
          }
          fetch(url,settings)
          .then(response => response.json())
          .then(data => {
              let address = data;
              document.querySelector('#address_id').value = address.id;
              document.querySelector('#calle').value = address.calle;
              document.querySelector('#numero').value = address.numero;
              document.querySelector('#localidad').value = address.localidad;
              document.querySelector('#provincia').value = address.provincia;


            //el formulario por default esta oculto y al editar se habilita
              document.querySelector('#div_address_updating').style.display = "block";
          }).catch(error => {
              alert("Error: " + error);
          })
          
      }
      //refrescar los resultados actualizados
      const reload = () => window.location.reload();