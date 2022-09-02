package br.com.andre.mvc.mudi.controller;

import br.com.andre.mvc.mudi.model.Pedido;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home(Model model){
        Pedido pedido = new Pedido();
        pedido.setNomeProduto("Console PlayStation 5");
        pedido.setUrlProduto("https://www.amazon.com.br/Console-PlayStation-5-Digital-Edition/dp/B09FGCKBPK/ref=sr_1_6?__mk_pt_BR=ÅMÅŽÕÑ&crid=3L3HUDV7BBYZ3&keywords=ps5&qid=1662117629&sprefix=ps5%2Caps%2C244&sr=8-6&ufe=app_do%3Aamzn1.fos.25548f35-0de7-44b3-b28e-0f56f3f96147");
        pedido.setUrlImagem("https://m.media-amazon.com/images/I/51VjZBvjOyL._AC_SL1000_.jpg");
        pedido.setDescricao("Digital Edition");

        List<Pedido> pedidos = Arrays.asList(pedido);
        model.addAttribute("pedidos", pedidos);
        return "home";
    }

}
