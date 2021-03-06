package jsf.controller;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import model.Itens;
import model.Listas;
import model.ListasRepository;

@ManagedBean
public class ListaListasBean {

    public List<Listas> getListaListas() {
        EntityManager entityManager = getEntityManager();

        return new ListasRepository(entityManager).consultaTodas();
    }

    public List<Itens> getItensNaoListados(Long idLista) {
        EntityManager entityManager = getEntityManager();

        return new ListasRepository(entityManager).consultaItensNaoListados(idLista);
    }

    public void removeListas(Listas listas) {
        EntityManager entityManager = getEntityManager();

        new ListasRepository(entityManager).removeLista(listas);
    }

    public Double getValorTotalLista(Long idLista) {
        EntityManager entityManager = getEntityManager();

        return new ListasRepository(entityManager).consultaValorTotalLista(idLista);
    }

    public Long getQuantidadeItensLista(Long idLista) {
        EntityManager entityManager = getEntityManager();

        return new ListasRepository(entityManager).consultaQuantidadeItensLista(idLista);
    }

    private EntityManager getEntityManager() {
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        HttpServletRequest request = (HttpServletRequest) ec.getRequest();
        EntityManager manager = (EntityManager) request.getAttribute("EntityManager");

        return manager;
    }
}
