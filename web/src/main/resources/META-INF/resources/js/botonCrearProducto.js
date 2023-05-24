document.addEventListener('DOMContentLoaded', function() {
  // Obtener elementos del DOM
  var createButton = document.getElementById('create-btn');
  var modal = document.getElementById('modal');
  var modalContent = document.querySelector('.modal-content');
  //var closeModal = document.getElementsByClassName('close')[0];
  var closeModal = document.getElementById('close-product');

  // Mostrar el formulario al hacer clic en el botón "Crear"
  createButton.addEventListener('click', function() {
    // Mostrar la ventana emergente
    modal.style.display = 'block';
  });

  // Cerrar la ventana emergente al hacer clic en el botón de cerrar (x)
  closeModal.addEventListener('click', function() {
    modal.style.display = 'none';
  });


});
