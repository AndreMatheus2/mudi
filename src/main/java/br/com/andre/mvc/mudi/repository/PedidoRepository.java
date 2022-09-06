package br.com.andre.mvc.mudi.repository;

import br.com.andre.mvc.mudi.model.Pedido;
import br.com.andre.mvc.mudi.model.StatusPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    List<Pedido> findByStatus(StatusPedido aguardando);

    @Query("select p from Produto p join p.user u where u.username = :username")
    List<Pedido> findAllByUsuario(@Param("username")String username);
}
