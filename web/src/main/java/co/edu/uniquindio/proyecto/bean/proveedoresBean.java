package co.edu.uniquindio.proyecto.bean;

import java.io.Serializable;

import co.edu.uniquindio.proyecto.entidades.Proveedor;
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
public class proveedoresBean implements Serializable {

    private Proveedor proveedor;

    @Autowired
    private adminServicio adminServicio;

    private List<Proveedor> proveedores;

    public proveedoresBean(adminServicio adminServicio){
        this.adminServicio = adminServicio;
        proveedores = adminServicio.listarProveedor();
    }

    @PostConstruct
    public  void init(){
        proveedor = new Proveedor();
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public co.edu.uniquindio.proyecto.servicios.adminServicio getAdminServicio() {
        return adminServicio;
    }

    public void setAdminServicio(co.edu.uniquindio.proyecto.servicios.adminServicio adminServicio) {
        this.adminServicio = adminServicio;
    }

    public List<Proveedor> getProveedores() {
        return proveedores;
    }

    public void setProveedores(List<Proveedor> proveedores) {
        this.proveedores = proveedores;
    }
}
