function openUpdateWindow(button) {
  // Obtener los datos de la fila correspondiente
  var row = button.closest(".row");
  var cells = row.getElementsByClassName("cell");

  // Crear un objeto con los valores de las celdas
  var rowData = {
    codigo: cells[0].textContent,
    nombre: cells[1].textContent,
    descripcion: cells[2].textContent,
    categoria: cells[3].textContent,
    proveedor: cells[4].textContent,
    fechaCosecha: cells[5].textContent,
    fechaMaduracion: cells[6].textContent,
    cantidad: cells[7].textContent,
    stock: cells[8].textContent,
    precioProduccion: cells[9].textContent,
    precioVenta: cells[10].textContent
  
  };

  // Convertir el objeto en una cadena de consulta
  var queryString = Object.keys(rowData)
    .map(function (key) {
      return encodeURIComponent(key) + "=" + encodeURIComponent(rowData[key]);
    })
    .join("&");

  // Abrir una nueva ventana o pestaña con el formulario y pasar la cadena de consulta como parámetro
  var updateWindow = window.open("formularioActualizarProducto.html?" + queryString, "_blank");
}
