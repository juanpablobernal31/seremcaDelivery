package co.edu.uniquindio.proyecto.bean;

import co.edu.uniquindio.proyecto.entidades.Categoria;
import co.edu.uniquindio.proyecto.servicios.adminServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;
@Component
@ViewScoped
public class categoriaBean implements  Serializable {

    private Categoria categoria;

    @Autowired
    private adminServicio adminServicio;

    private List<Categoria> categorias;

    public categoriaBean(adminServicio adminServicio){
        this.adminServicio = adminServicio;
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
}
