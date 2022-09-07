package br.com.andre.mvc.mudi.api;

import br.com.andre.mvc.mudi.dto.RequisicaoNovaOferta;
import br.com.andre.mvc.mudi.dto.RequisicaoNovoPedido;
import br.com.andre.mvc.mudi.model.Oferta;
import br.com.andre.mvc.mudi.model.Pedido;
import br.com.andre.mvc.mudi.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/ofertas")
public class OfertasRest {

    @Autowired
    private PedidoRepository pedidoRepository;

    @PostMapping
    public Oferta criaOferta(RequisicaoNovaOferta requisicao){
        Optional<Pedido> pedidoBuscado = pedidoRepository.findById(requisicao.getPedidoId());
        if (!pedidoBuscado.isPresent()){
            return null;
        }

        Pedido pedido = pedidoBuscado.get();
        Oferta nova = requisicao.toOferta();

        nova.setPedido(pedido);
        pedido.getOfertas().add(nova);
        pedidoRepository.save(pedido);

        return nova;
    }


}
