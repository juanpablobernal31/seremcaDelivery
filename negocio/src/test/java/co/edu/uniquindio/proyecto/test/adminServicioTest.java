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
public class adminServicioTest {

    @Autowired
    private adminServicio adminServicio;

    //PROVEEDOR
    @Test
    @Sql("classpath:dataset.sql")
    public void crearProveedor(){
        proveedor proveedor = new proveedor(10,10,1,esAsociacion.SI, 1600, "asoMora", "123", new municipio(), new departamento());

        try{
            proveedor guardado = adminServicio.crearProveedor(proveedor);

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
            proveedor proveedor = adminServicio.obtenerProveedor(1);
            proveedor.setNombreProveedor("morasMor");
            proveedor nuevo = adminServicio.actualizarProveedor(proveedor);

            Assertions.assertEquals("morasMor", nuevo.getNombreProveedor());
        }catch(Exception e){

        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void  listarProveedores(){
        List<proveedor> lista = adminServicio.listarProveedor();

        lista.forEach(System.out::println);
    }


    //CATEGORIA

    @Test
    @Sql("classpath:dataset.sql")
    public void crearCategoria(){
        categoria categoria = new categoria("mora", "mora que enamora", 4, "kilo");
        try{
            categoria guardado = adminServicio.crearCategoria(categoria);

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
            categoria categoria = adminServicio.obtenerCategoria(1);
            categoria.setNombreCategoria("morasMor");
            categoria nuevo = adminServicio.actualizarCategoria(categoria);

            Assertions.assertEquals("morasMor", nuevo.getNombreCategoria());
        }catch(Exception e){

        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void  listarCategoria(){
        List<categoria> lista = adminServicio.listarCategoria();

        lista.forEach(System.out::println);
    }

    //DEPARTAMENTO

    @Test
    @Sql("classpath:dataset.sql")
    public void crearDepartamento(){
        departamento departamento = new departamento("quindio");
        try{
            departamento guardado = adminServicio.crearDepartamento(departamento);

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
            departamento departamento = adminServicio.obtenerDepartamento(1);
            departamento.setNombreDepartamento("morasMor");
            departamento nuevo = adminServicio.actualizarDepartamento(departamento);

            Assertions.assertEquals("morasMor", nuevo.getNombreDepartamento());
        }catch(Exception e){

        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void  listarDepartamento(){
        List<departamento> lista = adminServicio.listarDepartamento();

        lista.forEach(System.out::println);
    }

    //MUNICIPIO

    @Test
    @Sql("classpath:dataset.sql")
    public void crearMunicipio(){
        municipio municipio = new municipio("calarca", new departamento());
        try{
            municipio guardado = adminServicio.crearMunicipio(municipio);

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
            municipio municipio = adminServicio.obtenerMunicipio(1);
            municipio.setNombremunicipio("morasMor");
            municipio nuevo = adminServicio.actualizarMunicipio(municipio);

            Assertions.assertEquals("morasMor", nuevo.getNombremunicipio());
        }catch(Exception e){

        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void  listarMunicipio(){
        List<municipio> lista = adminServicio.listarMunicipio();

        lista.forEach(System.out::println);
    }

    //PRODUCTO

    @Test
    @Sql("classpath:dataset.sql")
    public void crearProducto(){
        producto producto = new producto(10, 10, 5000, 10000, "mora", "mora que enamora", "123", "456", new proveedor(), new categoria());
        try{
            producto guardado = adminServicio.crearProducto(producto);

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
            producto producto = adminServicio.obtenerProducto(1);
            producto.setNombreProducto("morasMor");
            producto nuevo = adminServicio.actualizarProducto(producto);

            Assertions.assertEquals("morasMor", nuevo.getNombreProducto());
        }catch(Exception e){

        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void  listarProducto(){
        List<producto> lista = adminServicio.listarProducto();

        lista.forEach(System.out::println);
    }


}
