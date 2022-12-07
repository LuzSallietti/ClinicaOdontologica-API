const deleteBy = (id) => {
    const url = '/odontologos/'+ id;
          const settings = {
              method: 'DELETE'
          }
          fetch(url,settings)
          .then(response => response.json())
          .then(data => {
            console.log(data)          
          let row_id = "#tr-" + id;
          document.querySelector(row_id).remove();
          })
          .catch(error => alert("¡No se puede eliminar! Este odontólogo tiene turnos asignados."));
}