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
public class RegistroBean implements Serializable {


    private Persona persona;

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @Autowired
    private final personaServicio personaServicio;
    public RegistroBean(personaServicio personaServicio) {
        this.personaServicio = personaServicio;
    }


    String confirmacion;

    public String getConfirmacion() {
        return confirmacion;
    }

    public void setConfirmacion(String confirmacion) {
        this.confirmacion = confirmacion;
    }

    @PostConstruct
    public void init(){
        persona = new Persona();
    }

    public void registrarPersona(){
        try{
            if(persona.getContrasena().equals(confirmacion)) {
                personaServicio.registrarPersona(persona);
                System.out.println(persona.toString());
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta","Usuario registrado!!!");
                FacesContext.getCurrentInstance().addMessage("mensajeBean", fm);
            }else{
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta","Contraseñas no coinciden");
                FacesContext.getCurrentInstance().addMessage("mensajeBean", fm);
            }
        }catch (Exception e){

            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", e.getMessage());
            System.out.println(e.toString());
            FacesContext.getCurrentInstance().addMessage("mensajeBean", fm);

        }
    }
}
