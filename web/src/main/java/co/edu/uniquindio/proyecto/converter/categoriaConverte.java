package co.edu.uniquindio.proyecto.converter;

import co.edu.uniquindio.proyecto.entidades.Categoria;
import co.edu.uniquindio.proyecto.servicios.adminServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

@Component
public class categoriaConverte implements Converter<Categoria> {

   @Autowired
   private adminServicio adminServicio;

    @Override
    public Categoria getAsObject(FacesContext context, UIComponent component, String value){
        Categoria categoria = null;
        try{
            categoria= adminServicio.obtenerCategoria(Integer.parseInt(value));

        }catch (Exception e){
            throw new RuntimeException();
        }
        return categoria;
    }

    @Override
    public  String getAsString(FacesContext context, UIComponent component, Categoria value){
       if (value!=null){
           return ""+value.getIdCategoria();
       }
        return "";
    }
}
