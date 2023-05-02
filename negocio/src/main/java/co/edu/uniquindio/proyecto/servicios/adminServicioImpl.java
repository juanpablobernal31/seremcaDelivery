package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.*;
import co.edu.uniquindio.proyecto.repo.*;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
class adminServicioImpl implements adminServicio{



   private proveedorRepo proveedorRepo;
   private categoriaRepo categoriaRepo;
   private departamentoRepo departamentoRepo;
   private municipioRepo municipioRepo;
   private  productoRepo productoRepo;

    public adminServicioImpl(co.edu.uniquindio.proyecto.repo.proveedorRepo proveedorRepo, co.edu.uniquindio.proyecto.repo.categoriaRepo categoriaRepo, co.edu.uniquindio.proyecto.repo.departamentoRepo departamentoRepo, co.edu.uniquindio.proyecto.repo.municipioRepo municipioRepo, co.edu.uniquindio.proyecto.repo.productoRepo productoRepo) {
        this.proveedorRepo = proveedorRepo;
        this.categoriaRepo = categoriaRepo;
        this.departamentoRepo = departamentoRepo;
        this.municipioRepo = municipioRepo;
        this.productoRepo = productoRepo;
    }

    @Override
    public proveedor crearProveedor(proveedor proveedor) throws Exception{
        boolean bandera = findProveedorById(proveedor.getIdProveedor());
        if (bandera){
            throw new RuntimeException("El proveedor ya existe.");
        }

        return proveedorRepo.save(proveedor);
    }

    private boolean findProveedorById(int id){ return productoRepo.findById(id).orElse(null)!=null;}

    @Override
    public void eliminarProveedor(int idProveedor) throws Exception {
        Optional<proveedor> buscado = proveedorRepo.findById(idProveedor);
        if(buscado.isEmpty()){
            throw new RuntimeException("Proveedor no existe.");
        }

        proveedorRepo.delete(buscado.get());
    }

    @Override
    public proveedor actualizarProveedor(proveedor proveedor) throws Exception {
        Optional<proveedor> buscado = proveedorRepo.findById(proveedor.getIdProveedor());
        if(buscado.isEmpty()){
            throw new Exception("proveedor no existente");
        }
        return proveedorRepo.save(proveedor);
    }

    @Override
    public List<proveedor> listarProveedor() {
        return proveedorRepo.findAll();
    }

    @Override
    public proveedor obtenerProveedor(int id) throws Exception {
        proveedor proveedor =proveedorRepo.findById(id).orElse(null);

        if (proveedor ==null){
            throw  new Exception("datos incorrectos");
        }
        return proveedor;
    }

    @Override
    public categoria crearCategoria(categoria categoria) throws Exception {
        boolean bandera = findCategoriaById(categoria.getIdCategoria());
        if (bandera){
            throw new RuntimeException("La categoria ya existe.");
        }

        return categoriaRepo.save(categoria);
    }

    private boolean findCategoriaById(int id){ return categoriaRepo.findById(id).orElse(null)!=null;}
    @Override
    public void eliminarCategoria(int idCategoria) throws Exception{
        Optional<categoria> buscado = categoriaRepo.findById(idCategoria);
        if(buscado.isEmpty()){
            throw new RuntimeException("La categoria no existe.");
        }

        categoriaRepo.delete(buscado.get());
    }

    @Override
    public categoria actualizarCategoria(categoria categoria) throws Exception{
        Optional<categoria> buscado = categoriaRepo.findById(categoria.getIdCategoria());
        if(buscado.isEmpty()){
            throw new Exception("categoria no existente");
        }
        return categoriaRepo.save(categoria);
    }

    @Override
    public List<categoria> listarCategoria() {
        return categoriaRepo.findAll();
    }

    @Override
    public categoria obtenerCategoria(int id) throws Exception {
        categoria categoria =categoriaRepo.findById(id).orElse(null);

        if (categoria ==null){
            throw  new Exception("datos incorrectos");
        }
        return categoria;    }


    @Override
    public departamento crearDepartamento(departamento departamento) throws Exception{
        boolean bandera = findDepartamentoById(departamento.getIdDepartamento());
        if (bandera){
            throw new RuntimeException("El departamento ya existe.");
        }

        return departamentoRepo.save(departamento);
    }

    private boolean findDepartamentoById(int id){ return departamentoRepo.findById(id).orElse(null)!=null;}
    @Override
    public void eliminarDepartamento(int idDepartamento) throws Exception{
        Optional<departamento> buscado = departamentoRepo.findById(idDepartamento);
        if(buscado.isEmpty()){
            throw new RuntimeException("El departamento no existe.");
        }

        departamentoRepo.delete(buscado.get());
    }

    @Override
    public departamento actualizarDepartamento(departamento departamento) throws Exception{
        Optional<departamento> buscado = departamentoRepo.findById(departamento.getIdDepartamento());
        if(buscado.isEmpty()){
            throw new Exception("El departamento no existente");
        }
        return departamentoRepo.save(departamento);
    }

    @Override
    public List<departamento> listarDepartamento() {
        return departamentoRepo.findAll();
    }

    @Override
    public departamento obtenerDepartamento(int id) throws Exception {
        departamento departamento =departamentoRepo.findById(id).orElse(null);

        if (departamento ==null){
            throw  new Exception("datos incorrectos");
        }
        return departamento;    }

    @Override
    public municipio crearMunicipio(municipio municipio) throws Exception{
        boolean bandera = findMunicipioById(municipio.getIdMunicipio());
        if (bandera){
            throw new RuntimeException("El municipio ya existe.");
        }

        return municipioRepo.save(municipio);
    }


    private boolean findMunicipioById(int id){ return municipioRepo.findById(id).orElse(null)!=null;}
    @Override
    public void eliminarMunicio(int idMunicipio) throws Exception{
        Optional<municipio> buscado = municipioRepo.findById(idMunicipio);
        if(buscado.isEmpty()){
            throw new RuntimeException("El municipio no existe.");
        }

        municipioRepo.delete(buscado.get());
    }

    @Override
    public municipio actualizarMunicipio(municipio municipio) throws Exception{
        Optional<municipio> buscado = municipioRepo.findById(municipio.getIdMunicipio());
        if(buscado.isEmpty()){
            throw new Exception("El minucipio no existente");
        }
        return municipioRepo.save(municipio);
    }

    @Override
    public List<municipio> listarMunicipio() {
        return municipioRepo.findAll();
    }

    @Override
    public municipio obtenerMunicipio(int id) throws Exception {
        municipio municipio =municipioRepo.findById(id).orElse(null);

        if (municipio ==null){
            throw  new Exception("datos incorrectos");
        }
        return municipio;
    }


    @Override
    public producto crearProducto(producto producto) throws Exception{
        boolean bandera = findProductoById(producto.getIdProducto());
        if (bandera){
            throw new RuntimeException("El producto ya existe.");
        }

        return productoRepo.save(producto);
    }

    private boolean findProductoById(int id){ return productoRepo.findById(id).orElse(null)!=null;}

    @Override
    public void eliminarProducto(int idProducto) throws Exception{

        Optional<producto> buscado = productoRepo.findById(idProducto);
        if(buscado.isEmpty()){
            throw new RuntimeException("El producto no existe.");
        }

        productoRepo.delete(buscado.get());
    }

    @Override
    public producto actualizarProducto(producto producto) throws Exception{
        Optional<producto> buscado = productoRepo.findById(producto.getCantidadProducto());
        if(buscado.isEmpty()){
            throw new Exception("El producto no existente");
        }
        return productoRepo.save(producto);
    }

    @Override
    public List<producto> listarProducto() {
        return productoRepo.findAll();
    }

    @Override
    public producto obtenerProducto(int id) throws Exception {
        producto producto=productoRepo.findById(id).orElse(null);

        if (producto ==null){
            throw  new Exception("datos incorrectos");
        }
        return producto;
    }
}
