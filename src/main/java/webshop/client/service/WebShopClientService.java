package webshop.client.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import webshop.client.ServerURLS;
import webshop.client.dto.CartLineDTO;
import webshop.client.dto.ProductDTO;
import webshop.client.dto.ShoppingCartDTO;
import webshop.client.dto.StockDto;

@Service
public class WebShopClientService implements CommandLineRunner {

    private RestTemplate restTemplate;

    @Autowired
    WebShopClientService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void addProduct() {
        System.out.println("----------- Add Product Id: 100 -----------------------");
        restTemplate.postForLocation(ServerURLS.PRODUCT.url, ProductDTO.builder().productNumber(100L).price(1234).description("My New Product").stockDto(StockDto.builder().stockNumber(1L).locationCode("ABC Location").build()).build());
    }

    public ProductDTO getProduct(Long id) {
        System.out.println("----------- Get Product : 100 -----------------------");
        ProductDTO productDTO = restTemplate.getForObject(ServerURLS.PRODUCT.url + "/{id}", ProductDTO.class, "100");
        System.out.println(productDTO);
        return productDTO;
    }

    public void callProductApplication() {
        addProduct();
        getProduct(100L);
    }

    public void callShoppingApplication() {
        addToShoppingCart();
        getShoppingCart(10L);
    }

    private void getShoppingCart(long l) {
        System.out.println("----------- Get Shopping Cart -----------------------");
        ShoppingCartDTO shoppingCartDTO = restTemplate.getForObject(ServerURLS.SHOPPING.url + "/{id}", ShoppingCartDTO.class, "1");
        System.out.println(shoppingCartDTO);

    }

    private void addToShoppingCart() {
        System.out.println("----------- Add Product To Shopping Cart -----------------------");
        String url = ServerURLS.SHOPPING.url + "/addProduct/{id}";

        CartLineDTO cartLineDTO = new CartLineDTO(2L, ProductDTO.builder().productNumber(100L).price(1234).description("My New REST-CLIENT Product").build());

        ShoppingCartDTO shoppingCartDTO = restTemplate.postForObject(url, cartLineDTO, ShoppingCartDTO.class, 1);

    }


    @Override
    public void run(String... args) throws Exception {

    }
}
