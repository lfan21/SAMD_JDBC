package com.samd.beans;

import com.samd.excepciones.PersistenciaExcepcion;
import com.samd.fachada.Fachada;
import com.samd.modelo.Tema;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

@ManagedBean
@SessionScoped
public class TemaControlador {

    private Fachada fachada;
    private Tema tema;
    private List<SelectItem> listaComboTipoTema;
    private List<Tema> listaTemas;
    private List<Tema> temaFiltrado;


    public List<Tema> getListaTemas() throws PersistenciaExcepcion {
        return fachada.listarTemas();
    }

    public void setListaTemas(List<Tema> listaTemas) {
        this.listaTemas = listaTemas;
    }

    public List<SelectItem> getListaComboTipoTema() throws PersistenciaExcepcion {

        List<Tema> listaAuxTipoTema = new ArrayList<>();
        this.listaComboTipoTema.clear();

        listaAuxTipoTema = fachada.cargarComboTema();

        for (Tema tema : listaAuxTipoTema) {

            SelectItem tipoTemaItem = new SelectItem(tema.getIdTema(), tema.getNombre());
            this.listaComboTipoTema.add(tipoTemaItem);
        }

        return listaComboTipoTema;
    }

    public void setListaComboTipoTema(List<SelectItem> listaComboTipoTema) {
        this.listaComboTipoTema = listaComboTipoTema;
    }

    public Tema getTema() {
        return tema;
    }

    public void setTema(Tema tema) {
        this.tema = tema;
    }

    public TemaControlador() {
        fachada = Fachada.getInstancia();
        tema = new Tema();
        listaComboTipoTema = new ArrayList<>();
        listaTemas = new ArrayList<>();
    }

    public List<Tema> getTemaFiltrado() {
        return temaFiltrado;
    }

    public void setTemaFiltrado(List<Tema> temaFiltrado) {
        this.temaFiltrado = temaFiltrado;
    }

    public void ingresartTema() throws Exception {

        if (fachada.existeTemaNombre(tema)) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Gestión de Temas", "El tema ya se encuentra ingresado"));
        } else {
            fachada.ingresarTema(this.tema);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Gestión de Temas", "Tema ingresado correctamente"));

        }

    }

    public void eliminarTema() throws PersistenciaExcepcion {
        fachada.eliminarTema(this.tema);
    }

    public void modificarTema() throws PersistenciaExcepcion {
        fachada.modificarTema(this.tema);

    }

}
