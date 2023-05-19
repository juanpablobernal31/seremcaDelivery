package co.edu.uniquindio.proyecto.bean;


import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.servicios.adminServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;

@Component
@ViewScoped
public class listarProductosBean  implements Serializable {

    private Producto producto;

    @Autowired
    private adminServicio adminServico;

    private  List<Producto> productos;



    public listarProductosBean(adminServicio adminServico) {
        this.adminServico = adminServico;
        productos = adminServico.listarProducto();
    }

    @PostConstruct
    public void init(){
        producto = new Producto();
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

    public void agregarProducto (){
        this.productos.add(this.producto);
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


}
