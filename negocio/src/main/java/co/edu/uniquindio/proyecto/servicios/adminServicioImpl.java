package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.*;
import co.edu.uniquindio.proyecto.repo.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
class adminServicioImpl implements adminServicio{



   private ProveedorRepo proveedorRepo;
   private CategoriaRepo categoriaRepo;
   private DepartamentoRepo departamentoRepo;
   private MunicipioRepo municipioRepo;
   private ProductoRepo productoRepo;

    public adminServicioImpl(ProveedorRepo proveedorRepo, CategoriaRepo categoriaRepo, DepartamentoRepo departamentoRepo, MunicipioRepo municipioRepo, ProductoRepo productoRepo) {
        this.proveedorRepo = proveedorRepo;
        this.categoriaRepo = categoriaRepo;
        this.departamentoRepo = departamentoRepo;
        this.municipioRepo = municipioRepo;
        this.productoRepo = productoRepo;
    }

    @Override
    public Proveedor crearProveedor(Proveedor proveedor) throws Exception{
        boolean bandera = findProveedorById(proveedor.getIdProveedor());
        if (bandera){
            throw new RuntimeException("El proveedor ya existe.");
        }

        return proveedorRepo.save(proveedor);
    }

    private boolean findProveedorById(int id){ return productoRepo.findById(id).orElse(null)!=null;}

    @Override
    public void eliminarProveedor(int idProveedor) throws Exception {
        Optional<Proveedor> buscado = proveedorRepo.findById(idProveedor);
        if(buscado.isEmpty()){
            throw new RuntimeException("Proveedor no existe.");
        }

        proveedorRepo.delete(buscado.get());
    }

    @Override
    public Proveedor actualizarProveedor(Proveedor proveedor) throws Exception {
        Optional<Proveedor> buscado = proveedorRepo.findById(proveedor.getIdProveedor());
        if(buscado.isEmpty()){
            throw new Exception("proveedor no existente");
        }
        return proveedorRepo.save(proveedor);
    }

    @Override
    public List<Proveedor> listarProveedor() {
        return proveedorRepo.findAll();
    }

    @Override
    public Proveedor obtenerProveedor(int id) throws Exception {
        Proveedor proveedor =proveedorRepo.findById(id).orElse(null);

        if (proveedor ==null){
            throw  new Exception("datos incorrectos");
        }
        return proveedor;
    }

    @Override
    public Categoria crearCategoria(Categoria categoria) throws Exception {
        boolean bandera = findCategoriaById(categoria.getIdCategoria());
        if (bandera){
            throw new RuntimeException("La categoria ya existe.");
        }

        return categoriaRepo.save(categoria);
    }

    private boolean findCategoriaById(int id){ return categoriaRepo.findById(id).orElse(null)!=null;}
    @Override
    public void eliminarCategoria(int idCategoria) throws Exception{
        Optional<Categoria> buscado = categoriaRepo.findById(idCategoria);
        if(buscado.isEmpty()){
            throw new RuntimeException("La categoria no existe.");
        }

        categoriaRepo.delete(buscado.get());
    }

    @Override
    public Categoria actualizarCategoria(Categoria categoria) throws Exception{
        Optional<Categoria> buscado = categoriaRepo.findById(categoria.getIdCategoria());
        if(buscado.isEmpty()){
            throw new Exception("categoria no existente");
        }
        return categoriaRepo.save(categoria);
    }

    @Override
    public List<Categoria> listarCategoria() {
        return categoriaRepo.findAll();
    }

    @Override
    public Categoria obtenerCategoria(int id) throws Exception {
        Categoria categoria =categoriaRepo.findById(id).orElse(null);

        if (categoria ==null){
            throw  new Exception("datos incorrectos");
        }
        return categoria;    }


    @Override
    public Departamento crearDepartamento(Departamento departamento) throws Exception{
        boolean bandera = findDepartamentoById(departamento.getIdDepartamento());
        if (bandera){
            throw new RuntimeException("El departamento ya existe.");
        }

        return departamentoRepo.save(departamento);
    }

    private boolean findDepartamentoById(int id){ return departamentoRepo.findById(id).orElse(null)!=null;}
    @Override
    public void eliminarDepartamento(int idDepartamento) throws Exception{
        Optional<Departamento> buscado = departamentoRepo.findById(idDepartamento);
        if(buscado.isEmpty()){
            throw new RuntimeException("El departamento no existe.");
        }

        departamentoRepo.delete(buscado.get());
    }

    @Override
    public Departamento actualizarDepartamento(Departamento departamento) throws Exception{
        Optional<Departamento> buscado = departamentoRepo.findById(departamento.getIdDepartamento());
        if(buscado.isEmpty()){
            throw new Exception("El departamento no existente");
        }
        return departamentoRepo.save(departamento);
    }

    @Override
    public List<Departamento> listarDepartamento() {
        return departamentoRepo.findAll();
    }

    @Override
    public Departamento obtenerDepartamento(int id) throws Exception {
        Departamento departamento =departamentoRepo.findById(id).orElse(null);

        if (departamento ==null){
            throw  new Exception("datos incorrectos");
        }
        return departamento;    }

    @Override
    public Municipio crearMunicipio(Municipio municipio) throws Exception{
        boolean bandera = findMunicipioById(municipio.getIdMunicipio());
        if (bandera){
            throw new RuntimeException("El municipio ya existe.");
        }

        return municipioRepo.save(municipio);
    }


    private boolean findMunicipioById(int id){ return municipioRepo.findById(id).orElse(null)!=null;}
    @Override
    public void eliminarMunicio(int idMunicipio) throws Exception{
        Optional<Municipio> buscado = municipioRepo.findById(idMunicipio);
        if(buscado.isEmpty()){
            throw new RuntimeException("El municipio no existe.");
        }

        municipioRepo.delete(buscado.get());
    }

    @Override
    public Municipio actualizarMunicipio(Municipio municipio) throws Exception{
        Optional<Municipio> buscado = municipioRepo.findById(municipio.getIdMunicipio());
        if(buscado.isEmpty()){
            throw new Exception("El minucipio no existente");
        }
        return municipioRepo.save(municipio);
    }

    @Override
    public List<Municipio> listarMunicipio() {
        return municipioRepo.findAll();
    }

    @Override
    public Municipio obtenerMunicipio(int id) throws Exception {
        Municipio municipio =municipioRepo.findById(id).orElse(null);

        if (municipio ==null){
            throw  new Exception("datos incorrectos");
        }
        return municipio;
    }


    @Override
    public Producto crearProducto(Producto producto) throws Exception{
        boolean bandera = findProductoById(producto.getIdProducto());
        if (bandera){
            throw new RuntimeException("El producto ya existe.");
        }

        return productoRepo.save(producto);
    }

    private boolean findProductoById(int id){ return productoRepo.findById(id).orElse(null)!=null;}

    @Override
    public void eliminarProducto(int idProducto) throws Exception{

        Optional<Producto> buscado = productoRepo.findById(idProducto);
        if(buscado.isEmpty()){
            throw new RuntimeException("El producto no existe.");
        }

        productoRepo.delete(buscado.get());
    }

    @Override
    public Producto actualizarProducto(Producto producto) throws Exception{
        Optional<Producto> buscado = productoRepo.findById(producto.getCantidadProducto());
        if(buscado.isEmpty()){
            throw new Exception("El producto no existente");
        }
        return productoRepo.save(producto);
    }

    @Override
    public List<Producto> listarProducto() {
        return productoRepo.findAll();
    }

    @Override
    public Producto obtenerProducto(int id) throws Exception {
        Producto producto=productoRepo.findById(id).orElse(null);

        if (producto ==null){
            throw  new Exception("datos incorrectos");
        }
        return producto;
    }
}
