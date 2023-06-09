package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.*;

import java.util.List;


public interface adminServicio {

    //PROVEEDOR
    Proveedor crearProveedor(Proveedor proveedor) throws Exception;
    void eliminarProveedor(int idProveedor) throws Exception;
    Proveedor actualizarProveedor(Proveedor proveedor) throws Exception;
    List<Proveedor> listarProveedor();
    Proveedor obtenerProveedor(int id) throws Exception;



    //CATEGORIA
    Categoria crearCategoria(Categoria categoria) throws Exception;
    void eliminarCategoria(int  idCategoria) throws Exception;
    Categoria actualizarCategoria(Categoria categoria) throws Exception;
    List<Categoria> listarCategoria();
    Categoria obtenerCategoria(int id) throws Exception;



    //DEPARTAMENTO
    Departamento crearDepartamento(Departamento departamento) throws Exception;
    void eliminarDepartamento(int idDepartamento) throws Exception;
    Departamento actualizarDepartamento(Departamento departamento) throws Exception;
    List<Departamento> listarDepartamento();
    Departamento obtenerDepartamento(int id) throws Exception;


    //MUNICIPIO
    Municipio crearMunicipio(Municipio municipio) throws Exception;
    void eliminarMunicio(int idMunicipio) throws Exception;
    Municipio actualizarMunicipio(Municipio municipio) throws Exception;
    List<Municipio> listarMunicipio();
    Municipio obtenerMunicipio(int id) throws Exception;


    //PRODUCTO
    Producto crearProducto(Producto producto) throws Exception;
    void eliminarProducto(int idProducto) throws Exception;
    Producto actualizarProducto(Producto producto) throws Exception;
    List<Producto> listarProducto();
    Producto obtenerProducto(int id) throws Exception;


    //PUNTO_VENTA
    PuntoVenta crearPuntoVenta(PuntoVenta puntoVenta) throws Exception;
    void eliminarPuntoVenta(int idPuntoVenta) throws Exception;
    PuntoVenta actualizarPuntoVenta(PuntoVenta puntoVenta) throws Exception;
    List<PuntoVenta> listarPuntoVenta();
    PuntoVenta obtenerPuntoVenta(int idPuntoVenta) throws Exception;


    //VENTA
    Venta crearVenta(Venta venta) throws Exception;
    void eliminarVenta(int idVenta) throws Exception;
    Venta actualizarVenta(Venta venta) throws Exception;
    List<Venta> listarVenta();
    Venta obtenerVenta(int idVenta) throws Exception;


    //faltan para proximas entregas las de envio, estado, detalleVenta  y venta

}
