function openUpdateWindow(button) {
    // Obtener los datos de la fila correspondiente
    var row = button.closest(".row");
    var cells = row.getElementsByClassName("cell");
  
    // Crear un objeto con los valores de las celdas
    var rowData = {
      codigo: cells[0].textContent,
      nombre: cells[1].textContent,
      capacidad: cells[2].textContent,
      municipio: cells[3].textContent,
      departamento: cells[4].textContent,
      
    };
  
    // Convertir el objeto en una cadena de consulta
    var queryString = Object.keys(rowData)
      .map(function (key) {
        return encodeURIComponent(key) + "=" + encodeURIComponent(rowData[key]);
      })
      .join("&");
  
    // Abrir una nueva ventana o pestaña con el formulario y pasar la cadena de consulta como parámetro
    var updateWindow = window.open("formularioActualizarPuntoVenta.html?" + queryString, "_blank");
  }
  