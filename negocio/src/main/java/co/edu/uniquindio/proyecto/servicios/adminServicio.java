package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.*;
import org.hibernate.boot.model.source.spi.IdentifierSource;

import java.util.List;


public interface adminServicio {

    //PROVEEDOR
    proveedor crearProveedor(proveedor proveedor) throws Exception;
    void eliminarProveedor(int idProveedor) throws Exception;
    proveedor actualizarProveedor(proveedor proveedor) throws Exception;
    List<proveedor> listarProveedor();
    proveedor obtenerProveedor(int id) throws Exception;



    //CATEGORIA
    categoria crearCategoria(categoria categoria) throws Exception;
    void eliminarCategoria(int  idCategoria) throws Exception;
    categoria actualizarCategoria(categoria categoria) throws Exception;
    List<categoria> listarCategoria();
    categoria obtenerCategoria(int id) throws Exception;



    //DEPARTAMENTO
    departamento crearDepartamento(departamento departamento) throws Exception;
    void eliminarDepartamento(int idDepartamento) throws Exception;
    departamento actualizarDepartamento(departamento departamento) throws Exception;
    List<departamento> listarDepartamento();
    departamento obtenerDepartamento(int id) throws Exception;


    //MUNICIPIO
    municipio crearMunicipio(municipio municipio) throws Exception;
    void eliminarMunicio(int idMunicipio) throws Exception;
    municipio actualizarMunicipio(municipio municipio) throws Exception;
    List<municipio> listarMunicipio();
    municipio obtenerMunicipio(int id) throws Exception;


    //PRODUCTO
    producto crearProducto(producto producto) throws Exception;
    void eliminarProducto(int idProducto) throws Exception;
    producto actualizarProducto(producto producto) throws Exception;
    List<producto> listarProducto();
    producto obtenerProducto(int id) throws Exception;


    //faltan para proximas entregas las de envio, estado, puntoVenta, detalleVenta  y venta

}
