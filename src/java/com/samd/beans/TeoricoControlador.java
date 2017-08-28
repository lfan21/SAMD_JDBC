package com.samd.beans;

import com.samd.excepciones.PersistenciaExcepcion;
import com.samd.fachada.Fachada;
import com.samd.modelo.Tema;
import com.samd.modelo.Teorico;
import java.util.List;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class TeoricoControlador {

    private final Fachada fachada;
    private List<Teorico> listaTeoricos;
    private Teorico teorico;
    private List<Teorico> teoricoFiltrado;
    private List<Teorico> listaTeoricosIdTema;

    public List<Teorico> getListaTeoricosIdTema() throws PersistenciaExcepcion {

        Map<String, String> parametro = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        int id = Integer.parseInt(parametro.get("idTema"));

        return listaTeoricosIdTema = fachada.listarTeoricosPorId(id);
    }

    public void setListaTeoricosIdTema(List<Teorico> listaTeoricosIdTema) {
        this.listaTeoricosIdTema = listaTeoricosIdTema;
    }

    public List<Teorico> getTeoricoFiltrado() {
        return teoricoFiltrado;
    }

    public void setTeoricoFiltrado(List<Teorico> teoricoFiltrado) {
        this.teoricoFiltrado = teoricoFiltrado;
    }

    public List<Teorico> getListaTeoricos() throws PersistenciaExcepcion {
        return fachada.listarTeoricos();
    }

    public void setListaTeoricos(List<Teorico> listaTeoricos) {
        this.listaTeoricos = listaTeoricos;
    }

    public Teorico getTeorico() {
        return teorico;
    }

    public void setTeorico(Teorico teorico) {
        this.teorico = teorico;
    }

    public TeoricoControlador() {
        fachada = Fachada.getInstancia();
        teorico = new Teorico();

    }

    public void ingresarTeorico() throws PersistenciaExcepcion {

        if (fachada.exiteTeoricoNombre(teorico)) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Gestión de Teóricos", "El Teórico ya se encuentra ingresado"));
        } else {
            fachada.ingresarTeorico(this.teorico);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Gestión de Teóricos", "Teórico ingresado correctamente"));

        }

    }

    public void modificarTeorico() throws PersistenciaExcepcion {
        fachada.modificarTeorico(this.teorico);

    }

    public void eliminarTeorico() throws PersistenciaExcepcion {
        fachada.eliminarTeorico(this.teorico);

    }

}
