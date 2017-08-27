package com.samd.beans;

import com.samd.excepciones.PersistenciaExcepcion;
import com.samd.fachada.Fachada;
import com.samd.modelo.Teorico;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class TeoricoControlador {

    private final Fachada fachada;
    private List<Teorico> listaTeoricos;
    private Teorico teorico = new Teorico();
    private List<Teorico> teoricoFiltrado;
    private List<Teorico> listaTeoricosIdTema;

    public List<Teorico> getListaTeoricosIdTema(int id) throws PersistenciaExcepcion {
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
 
    }

    public void ingresarTeorico() throws PersistenciaExcepcion {
        fachada.ingresarTeorico(this.teorico);

    }

    public void modificarTeorico() throws PersistenciaExcepcion {
        fachada.modificarTeorico(this.teorico);

    }

    public void eliminarTeorico() throws PersistenciaExcepcion {
        fachada.eliminarTeorico(this.teorico);

    }

}