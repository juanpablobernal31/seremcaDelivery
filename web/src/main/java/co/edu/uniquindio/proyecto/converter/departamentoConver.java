package co.edu.uniquindio.proyecto.converter;

import co.edu.uniquindio.proyecto.entidades.Departamento;
import co.edu.uniquindio.proyecto.servicios.adminServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

@Component
public class departamentoConver implements Converter<Departamento> {

    @Autowired
    private adminServicio adminServicio;


    @Override
    public Departamento getAsObject(FacesContext context, UIComponent component, String value) {
        Departamento departamento = null;
        try{
            departamento = adminServicio.obtenerDepartamento(Integer.parseInt(value));
        }catch (Exception e){
            throw new RuntimeException();
        }

        return departamento;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Departamento value) {
        if (value!= null){
            return ""+value.getIdDepartamento();
        }

        return "";
    }
}
