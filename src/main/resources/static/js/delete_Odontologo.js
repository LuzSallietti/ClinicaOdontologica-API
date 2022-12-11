const deleteBy = (id) => {
    const url = '/odontologos/'+ id;
          const settings = {
              method: 'DELETE'
          }
          fetch(url,settings)
          .then(response => {
          let row_id = "#tr-" + id;
          document.querySelector(row_id).remove();
          })
          .catch(error => alert(error));
}