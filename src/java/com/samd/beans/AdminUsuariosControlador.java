package com.samd.beans;

import com.samd.excepciones.PersistenciaExcepcion;
import com.samd.excepciones.UsuarioExcepcion;
import com.samd.fachada.Fachada;
import com.samd.modelo.TipoUsuario;
import com.samd.modelo.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

@ManagedBean
@SessionScoped

public class AdminUsuariosControlador {

    private List listaUsuarios;
    private List<Usuario> usuarioFiltrado;
    private Usuario usuario = new Usuario();
    private int idTipoUsuario;
    private List<SelectItem> listaComboTipoUsuario;
    private final Fachada fachada = Fachada.getInstancia();

    public List<Usuario> getUsuarioFiltrado() {
        return usuarioFiltrado;
    }

    public void setUsuarioFiltrado(List<Usuario> usuarioFiltrado) {
        this.usuarioFiltrado = usuarioFiltrado;
    }

    public int getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setIdTipoUsuario(int idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }

    public AdminUsuariosControlador() {
        listaUsuarios = new ArrayList();

    }

    public List<SelectItem> getListaTipoUsuario() throws PersistenciaExcepcion {

        this.listaComboTipoUsuario = new ArrayList<>();
        List<TipoUsuario> listaAuxTipoUsuario = fachada.cargarCompoTipoUsuario();

        listaComboTipoUsuario.clear();

        for (TipoUsuario tu : listaAuxTipoUsuario) {
            SelectItem tipoUsuarioItem = new SelectItem(tu.getIdTipoUsuario(), tu.getDescripcion());
            this.listaComboTipoUsuario.add(tipoUsuarioItem);
        }

        return listaComboTipoUsuario;
    }

    public void setListaTipoUsuario(List<SelectItem> listaTipoUsuario) {
        this.listaComboTipoUsuario = listaTipoUsuario;
    }

    public List getListaUsuarios() throws Exception {
        return fachada.getListaUsuarios();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setListaUsuarios(List listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public void ingresarUsuario() throws UsuarioExcepcion, PersistenciaExcepcion {

        if (fachada.existeUsuario(usuario)) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Gestión de Usuarios", "El usuario ingresado ya existe"));
        } else {
            this.usuario.setIdTipo(idTipoUsuario);
            fachada.ingresarUsuario(usuario);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Gestión de Usuarios", "Usuario ingresado correctamente"));
        }

    }

    public void eliminarUsuario() throws Exception {
        fachada.eliminarUsuario(usuario);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Gestión de Usuarios", "Usuario eliminado correctamente"));

    }

    public void modificarUsuario() throws Exception {
        fachada.modificarUsuario(usuario);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Gestión de Usuarios", "Usuario modificado correctamente"));

    }

    public void cambiarContrasenia() throws PersistenciaExcepcion {
        fachada.cambiarContrasenia(this.usuario);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Gestión de Usuarios", "Contraseña cambiada con éxito"));

    }

}
