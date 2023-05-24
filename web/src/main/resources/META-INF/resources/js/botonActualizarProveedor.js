function openUpdateWindow(button) {
  // Obtener los datos de la fila correspondiente
  var row = button.closest(".row");
  var cells = row.getElementsByClassName("cell");

  // Crear un objeto con los valores de las celdas
  var rowData = {
    codigo: cells[0].textContent,
    nombre: cells[1].textContent,
    asociacion: cells[2].textContent,
    cedula: cells[3].textContent,
    promedioProduccion: cells[4].textContent,
    ultimaProduccion: cells[5].textContent,
    numeroCosechas: cells[6].textContent,
    altura: cells[7].textContent,
    ciudad: cells[8].textContent,
    departamento: cells[9].textContent,
  };

  // Convertir el objeto en una cadena de consulta
  var queryString = Object.keys(rowData)
    .map(function (key) {
      return encodeURIComponent(key) + "=" + encodeURIComponent(rowData[key]);
    })
    .join("&");

  // Abrir una nueva ventana o pestaña con el formulario y pasar la cadena de consulta como parámetro
  var updateWindow = window.open("formularioActualizarProveedor.html?" + queryString, "_blank");
}
