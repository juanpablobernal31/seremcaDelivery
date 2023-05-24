package co.edu.uniquindio.proyecto.bean;

import co.edu.uniquindio.proyecto.entidades.Categoria;
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
public class categoriaBean implements  Serializable {

    private Categoria categoria;

    @Autowired
    private adminServicio adminServicio;

    private List<Categoria> categorias;

    private  List<Categoria> categoriasSelecionadas;

    public List<Categoria> getCategoriasSelecionadas() {
        return categoriasSelecionadas;
    }

    public void setCategoriasSelecionadas(List<Categoria> categoriasSelecionadas) {
        this.categoriasSelecionadas = categoriasSelecionadas;
    }

    public categoriaBean(adminServicio adminServicio){
        this.adminServicio = adminServicio;
        categoriasSelecionadas = new ArrayList<>();
        categorias = adminServicio.listarCategoria();
    }

    @PostConstruct
    public void init(){
        categoria = new Categoria();
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public co.edu.uniquindio.proyecto.servicios.adminServicio getAdminServicio() {
        return adminServicio;
    }

    public void setAdminServicio(co.edu.uniquindio.proyecto.servicios.adminServicio adminServicio) {
        this.adminServicio = adminServicio;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public void agregarCategoria (){
        try {
            if (categoria!=null){
                adminServicio.crearCategoria(categoria);
                System.out.println(categoria.toString());
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

    public void  borrarCategoria(){
        try {
            categoriasSelecionadas.forEach(c->{
                try {
                    adminServicio.eliminarCategoria(c.getIdCategoria());
                    categorias.remove(c);
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
