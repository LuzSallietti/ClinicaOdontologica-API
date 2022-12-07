const deleteBy = (id) => {
    const url = '/turnos/'+ id;
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
}