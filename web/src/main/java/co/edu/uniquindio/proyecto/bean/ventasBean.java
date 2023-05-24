package co.edu.uniquindio.proyecto.bean;

import co.edu.uniquindio.proyecto.entidades.Persona;
import co.edu.uniquindio.proyecto.entidades.Venta;
import co.edu.uniquindio.proyecto.servicios.adminServicio;
import co.edu.uniquindio.proyecto.servicios.personaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.util.ArrayList;
import java.util.List;

@Component
@ViewScoped
public class ventasBean {

    private Venta venta=new Venta();

    @Autowired
    private adminServicio adminServicio;

    @Autowired
    private  personaServicio personaServicio;

    private List<Persona> personas;

    private  List<Venta> ventas;

    private List<Venta> ventaSelecionada;

    public  ventasBean(adminServicio adminServicio, personaServicio personaServicio){
        this.adminServicio = adminServicio;
        this.personaServicio = personaServicio;
        personas = personaServicio.listarPersona();
        ventaSelecionada = new ArrayList<>();
        ventas = adminServicio.listarVenta();
    }

    public List<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(List<Venta> ventas) {
        this.ventas = ventas;
    }

    public void agregarVenta (){
        try {
            if (venta!=null){
                adminServicio.crearVenta(venta);
                System.out.println(venta.toString());
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

    public void  borrarVenta(){
        try {
            ventas.forEach(v->{
                try {
                    adminServicio.eliminarVenta(v.getIdVenta());
                    ventas.remove(v);
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

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public List<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }

    public List<Venta> getVentaSelecionada() {
        return ventaSelecionada;
    }

    public void setVentaSelecionada(List<Venta> ventaSelecionada) {
        this.ventaSelecionada = ventaSelecionada;
    }
}
