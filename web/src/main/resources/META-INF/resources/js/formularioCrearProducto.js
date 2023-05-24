// Obtener elementos del DOM
var createButton = document.getElementById('create-btn');
var modal = document.getElementById('modal');
var closeModal = document.getElementsByClassName('close')[0];
var cancelButton = document.getElementById('cancel-btn');
var saveButton = document.getElementById('save-btn');
var productForm = document.getElementById('product-form');

// Mostrar la ventana modal al hacer clic en el botón "Crear"
createButton.addEventListener('click', function() {
  modal.style.display = 'block';
});

// Cerrar la ventana modal al hacer clic en el botón de cerrar (x)
closeModal.addEventListener('click', function() {
  modal.style.display = 'none';
});

// Cerrar la ventana modal al hacer clic en el botón "Cancelar"
cancelButton.addEventListener('click', function() {
  modal.style.display = 'none';
});

// Manejar el evento de envío del formulario
productForm.addEventListener('submit', function(event) {
  event.preventDefault(); // Evitar el envío del formulario por defecto
  guardarProducto();
});

// Función para guardar el producto (puedes reemplazarla con tu lógica de guardado)
function guardarProducto() {
  // Obtener los valores de los campos del formulario
  var codigo = document.getElementById('codigo').value;
  var nombre = document.getElementById('nombre').value;
  var descripcion = document.getElementById('descripcion').value;
  var categoria = document.getElementById('categoria').value;
  var proveedor = document.getElementById('proveedor').value;
  var fechaCosecha = document.getElementById('fecha-cosecha').value;
  var fechaMaduracion = document.getElementById('fecha-maduracion').value;
  var cantidad = document.getElementById('cantidad').value;
  var stock = document.getElementById('stock').value;
  var precioProduccion = document.getElementById('precio-produccion').value;
  var precioVenta = document.getElementById('precio-venta').value;

  // Aquí puedes realizar las operaciones necesarias para guardar el producto
  // Por ejemplo, enviar los datos al servidor mediante una petición AJAX

  // Cerrar la ventana modal después de guardar el producto
  modal.style.display = 'none';
}
