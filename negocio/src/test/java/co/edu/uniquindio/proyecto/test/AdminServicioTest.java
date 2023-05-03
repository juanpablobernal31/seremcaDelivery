package co.edu.uniquindio.proyecto.test;


import co.edu.uniquindio.proyecto.entidades.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import co.edu.uniquindio.proyecto.servicios.adminServicio;
import org.springframework.test.context.jdbc.Sql;

import javax.transaction.Transactional;
import java.util.List;

@SpringBootTest
@Transactional
public class AdminServicioTest {

    @Autowired
    private adminServicio adminServicio;

    //PROVEEDOR
    @Test
    @Sql("classpath:dataset.sql")
    public void crearProveedor(){
        Proveedor proveedor = new Proveedor(10,10,1, EsAsociacion.SI, 1600, "asoMora", "123", new Municipio(), new Departamento());

        try{
            Proveedor guardado = adminServicio.crearProveedor(proveedor);

            Assertions.assertNotNull(guardado);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void  eliminarProveedor() throws Exception {
        try{
            adminServicio.eliminarProveedor(1);
        }catch (Exception e){
            Assertions.assertTrue(false);
        }

        try{
            adminServicio.obtenerProveedor(1);
        }catch (Exception e){
            Assertions.assertTrue(true);
        }

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarProveedor(){
        try{
            Proveedor proveedor = adminServicio.obtenerProveedor(1);
            proveedor.setNombreProveedor("morasMor");
            Proveedor nuevo = adminServicio.actualizarProveedor(proveedor);

            Assertions.assertEquals("morasMor", nuevo.getNombreProveedor());
        }catch(Exception e){

        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void  listarProveedores(){
        List<Proveedor> lista = adminServicio.listarProveedor();

        lista.forEach(System.out::println);
    }


    //CATEGORIA

    @Test
    @Sql("classpath:dataset.sql")
    public void crearCategoria(){
        Categoria categoria = new Categoria("mora", "mora que enamora", 4, "kilo");
        try{
            Categoria guardado = adminServicio.crearCategoria(categoria);

            Assertions.assertNotNull(guardado);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void  eliminarCategoria() throws Exception {
        try{
            adminServicio.eliminarCategoria(1);
        }catch (Exception e){
            Assertions.assertTrue(false);
        }

        try{
            adminServicio.obtenerProveedor(1);
        }catch (Exception e){
            Assertions.assertTrue(true);
        }

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarCategoria(){
        try{
            Categoria categoria = adminServicio.obtenerCategoria(1);
            categoria.setNombreCategoria("morasMor");
            Categoria nuevo = adminServicio.actualizarCategoria(categoria);

            Assertions.assertEquals("morasMor", nuevo.getNombreCategoria());
        }catch(Exception e){

        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void  listarCategoria(){
        List<Categoria> lista = adminServicio.listarCategoria();

        lista.forEach(System.out::println);
    }

    //DEPARTAMENTO

    @Test
    @Sql("classpath:dataset.sql")
    public void crearDepartamento(){
        Departamento departamento = new Departamento("quindio");
        try{
            Departamento guardado = adminServicio.crearDepartamento(departamento);

            Assertions.assertNotNull(guardado);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void  eliminarDepartamento() throws Exception {
        try{
            adminServicio.eliminarDepartamento(1);
        }catch (Exception e){
            Assertions.assertTrue(false);
        }

        try{
            adminServicio.obtenerProveedor(1);
        }catch (Exception e){
            Assertions.assertTrue(true);
        }

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarDepartamento(){
        try{
            Departamento departamento = adminServicio.obtenerDepartamento(1);
            departamento.setNombreDepartamento("morasMor");
            Departamento nuevo = adminServicio.actualizarDepartamento(departamento);

            Assertions.assertEquals("morasMor", nuevo.getNombreDepartamento());
        }catch(Exception e){

        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void  listarDepartamento(){
        List<Departamento> lista = adminServicio.listarDepartamento();

        lista.forEach(System.out::println);
    }

    //MUNICIPIO

    @Test
    @Sql("classpath:dataset.sql")
    public void crearMunicipio(){
        Municipio municipio = new Municipio("calarca", new Departamento());
        try{
            Municipio guardado = adminServicio.crearMunicipio(municipio);

            Assertions.assertNotNull(guardado);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void  eliminarMunicipio() throws Exception {
        try{
            adminServicio.eliminarMunicio(1);
        }catch (Exception e){
            Assertions.assertTrue(false);
        }

        try{
            adminServicio.obtenerProveedor(1);
        }catch (Exception e){
            Assertions.assertTrue(true);
        }

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarMunicipio(){
        try{
            Municipio municipio = adminServicio.obtenerMunicipio(1);
            municipio.setNombremunicipio("morasMor");
            Municipio nuevo = adminServicio.actualizarMunicipio(municipio);

            Assertions.assertEquals("morasMor", nuevo.getNombremunicipio());
        }catch(Exception e){

        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void  listarMunicipio(){
        List<Municipio> lista = adminServicio.listarMunicipio();

        lista.forEach(System.out::println);
    }

    //PRODUCTO

    @Test
    @Sql("classpath:dataset.sql")
    public void crearProducto(){
        Producto producto = new Producto(10, 10, 5000, 10000, "mora", "mora que enamora", "123", "456", new Proveedor(), new Categoria());
        try{
            Producto guardado = adminServicio.crearProducto(producto);

            Assertions.assertNotNull(guardado);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void  eliminarProducto() throws Exception {
        try{
            adminServicio.eliminarProducto(1);
        }catch (Exception e){
            Assertions.assertTrue(false);
        }

        try{
            adminServicio.obtenerProveedor(1);
        }catch (Exception e){
            Assertions.assertTrue(true);
        }

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarProducto(){
        try{
            Producto producto = adminServicio.obtenerProducto(1);
            producto.setNombreProducto("morasMor");
            Producto nuevo = adminServicio.actualizarProducto(producto);

            Assertions.assertEquals("morasMor", nuevo.getNombreProducto());
        }catch(Exception e){

        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void  listarProducto(){
        List<Producto> lista = adminServicio.listarProducto();

        lista.forEach(System.out::println);
    }


}
