window.addEventListener('load', function () {
    const formulario = document.querySelector('#update_odontologo_form');
    formulario.addEventListener('submit', function (event) {
        event.preventDefault();
        let id_param = document.querySelector('#odontologo_id').value;
        console.log(id_param)        
        
        const formData = {
            id: document.querySelector('#odontologo_id').value,
            nombre: document.querySelector('#nombre').value,
            apellido: document.querySelector('#apellido').value,
            matricula: document.querySelector('#matricula').value,

        };
        const url = '/odontologos/';
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
            '<strong></strong> Odontologo modificado. </div>';
            let response = document.querySelector('#response');
            response.innerHTML=successModal;
            response.style.display = 'block';
          })
          .catch(error => alert(error))

        
 })
})

    const findBy = (id) => {
          const url = '/odontologos/'+id;
          const settings = {
              method: 'GET'
          }
          fetch(url,settings)
          .then(response => response.json())
          .then(data => {
              let odontologo = data;
              document.querySelector('#odontologo_id').value = odontologo.id;
              document.querySelector('#nombre').value = odontologo.nombre;
              document.querySelector('#apellido').value = odontologo.apellido;
              document.querySelector('#matricula').value = odontologo.matricula;            

            //el formulario por default esta oculto y al editar se habilita
              document.querySelector('#div_odontologo_updating').style.display = "block";
          }).catch(error => {
              alert("Error: " + error);
          })
          
      }
      //refrescar los resultados actualizados
      const reload = () => window.location.reload();