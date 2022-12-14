package br.com.andre.mvc.mudi.api;

import br.com.andre.mvc.mudi.model.Pedido;
import br.com.andre.mvc.mudi.model.StatusPedido;
import br.com.andre.mvc.mudi.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidosRest {

    @Autowired
    private PedidoRepository pedidoRepository;

    public List<Pedido> getPedidosAguardandoOfertas(){

        Sort sort = Sort.by("id").descending();
        PageRequest paginacao = PageRequest.of(0, 5, sort);

        return pedidoRepository.findByStatus(StatusPedido.AGUARDANDO, paginacao);
    }

}
