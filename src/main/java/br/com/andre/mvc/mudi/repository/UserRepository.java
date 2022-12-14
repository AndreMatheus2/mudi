package br.com.andre.mvc.mudi.repository;

import br.com.andre.mvc.mudi.model.Pedido;
import br.com.andre.mvc.mudi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    User findByUsername(String username);

}
