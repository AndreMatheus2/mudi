package br.com.andre.mvc.mudi.repository;

import br.com.andre.mvc.mudi.model.Pedido;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class PedidoRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Pedido> recuperaTodosPedidos(){
        Query query = entityManager.createQuery("select p from Pedido p", Pedido.class);
        return query.getResultList();
    }
}
