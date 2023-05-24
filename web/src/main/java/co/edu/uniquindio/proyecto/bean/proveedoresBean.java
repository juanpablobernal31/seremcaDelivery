package co.edu.uniquindio.proyecto.bean;

import java.io.Serializable;

import co.edu.uniquindio.proyecto.entidades.Departamento;
import co.edu.uniquindio.proyecto.entidades.EsAsociacion;
import co.edu.uniquindio.proyecto.entidades.Municipio;
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
import java.util.Arrays;
import java.util.List;
@Component
@ViewScoped
public class proveedoresBean implements Serializable {

    private Proveedor proveedor;

    @Autowired
    private adminServicio adminServicio;

    private List<Proveedor> proveedores;

    private List<Departamento> departamentos;

    private List<Municipio> municipios;

    private List<Proveedor> proveedoresSeleccionados;

    private List<EsAsociacion> asociacions;

    private EsAsociacion esAsociacion;

    public proveedoresBean(adminServicio adminServicio){
        this.adminServicio = adminServicio;
        proveedores = adminServicio.listarProveedor();
        proveedoresSeleccionados = new ArrayList<>();
        asociacions = Arrays.asList(esAsociacion.values());
        municipios = adminServicio.listarMunicipio();
        departamentos = adminServicio.listarDepartamento();
    }

    public void agregarProveedor (){
        try {
            if (proveedor!=null){
                adminServicio.crearProveedor(proveedor);
                System.out.println(proveedor.toString());
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta","Categoria agregada.");
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

    public void  borrarProveedor(){
        try {
            proveedores.forEach(p->{
                try {
                    adminServicio.eliminarProveedor(p.getIdProveedor());
                    proveedores.remove(p);
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

    @PostConstruct
    public  void init(){
        proveedor = new Proveedor();
    }

    public EsAsociacion getEsAsociacion() {
        return esAsociacion;
    }

    public void setEsAsociacion(EsAsociacion esAsociacion) {
        this.esAsociacion = esAsociacion;
    }

    public List<EsAsociacion> getAsociacions() {
        return asociacions;
    }

    public void setAsociacions(List<EsAsociacion> asociacions) {
        this.asociacions = asociacions;
    }

    public List<Departamento> getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(List<Departamento> departamentos) {
        this.departamentos = departamentos;
    }

    public List<Municipio> getMunicipios() {
        return municipios;
    }

    public void setMunicipios(List<Municipio> municipios) {
        this.municipios = municipios;
    }

    public List<Proveedor> getProveedoresSeleccionados() {
        return proveedoresSeleccionados;
    }

    public void setProveedoresSeleccionados(List<Proveedor> proveedoresSeleccionados) {
        this.proveedoresSeleccionados = proveedoresSeleccionados;
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
