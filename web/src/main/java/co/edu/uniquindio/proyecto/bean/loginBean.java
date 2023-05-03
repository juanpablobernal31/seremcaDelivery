package co.edu.uniquindio.proyecto.bean;

import co.edu.uniquindio.proyecto.entidades.Persona;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import co.edu.uniquindio.proyecto.servicios.personaServicio;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.io.Serializable;

@Component
@ViewScoped
public class loginBean {

    private Persona persona;

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @Autowired
    private final personaServicio personaServicio;
    public loginBean(personaServicio personaServicio) {
        this.personaServicio = personaServicio;
    }

    private int idPersona;
    private String clave;

    public void login() {
        try {
            Persona buscado = personaServicio.login(clave, idPersona);
            if (buscado.getNombrePersona().isEmpty()) {
                // Inicio de sesión exitoso
                System.out.println(buscado.toString());
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", "Login Exitoso!");
                FacesContext.getCurrentInstance().addMessage("mensajeBean", fm);
            } else {
                // Credenciales incorrectas
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Datos incorrectos!");
                FacesContext.getCurrentInstance().addMessage("mensajeBean", fm);
            }
        } catch (Exception e) {

        }
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
}
