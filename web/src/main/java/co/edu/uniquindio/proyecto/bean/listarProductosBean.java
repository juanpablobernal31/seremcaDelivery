package co.edu.uniquindio.proyecto.bean;


import co.edu.uniquindio.proyecto.entidades.Categoria;
import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.entidades.Proveedor;
import co.edu.uniquindio.proyecto.servicios.adminServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Component
@ViewScoped
public class listarProductosBean  implements Serializable {

    private Producto producto;

    @Autowired
    private adminServicio adminServico;

    private  List<Producto> productos;

    private List<Producto> productosSelecionados;

    private List<Categoria> categorias;

    private List<Proveedor> proveedores;


    public listarProductosBean(adminServicio adminServico) {
        this.adminServico = adminServico;
        productosSelecionados = new ArrayList<>();
        productos = adminServico.listarProducto();
        categorias = adminServico.listarCategoria();
        proveedores = adminServico.listarProveedor();
    }

    @PostConstruct
    public void init(){
        producto = new Producto();
    }

    public List<Proveedor> getProveedores() {
        return proveedores;
    }

    public void setProveedores(List<Proveedor> proveedores) {
        this.proveedores = proveedores;
    }


    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }


    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public List<Producto> getProductosSelecionados() {
        return productosSelecionados;
    }

    public void setProductosSelecionados(List<Producto> productosSelecionados) {
        this.productosSelecionados = productosSelecionados;
    }

    public void agregarProducto (){
        try {
            if (producto!=null){
                adminServico.crearProducto(producto);
                System.out.println(producto.toString());
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta","Producto agregado.");
                FacesContext.getCurrentInstance().addMessage("mensajeBean", fm);
                ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
            }else{
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta","Los valores son incorrectos");
                FacesContext.getCurrentInstance().addMessage("mensajeBean", fm);
            }
        }catch (Exception e){
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", e.getMessage());
            System.out.println(e.toString());
            FacesContext.getCurrentInstance().addMessage("mensajeBean", fm);

        }
    }

    public void listarProductos(){
        try {
            productos = adminServico.listarProducto();

        }catch (Exception e){
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", e.getMessage());
            System.out.println(e.toString());
            FacesContext.getCurrentInstance().addMessage("mensajeBean", fm);
        }
    }

    public void  borrarProducto(){
        try {
            productosSelecionados.forEach(p->{
                try {
                    adminServico.eliminarProducto(p.getIdProducto());
                    productos.remove(p);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });
        }catch (Exception e){
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", e.getMessage());
            System.out.println(e.toString());
            FacesContext.getCurrentInstance().addMessage("mensajeBean", fm);
        }

    }


}
