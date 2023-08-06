package webshop.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import webshop.client.service.WebShopClientService;

@RestController
@RequestMapping("/api/v1/client")
public class RestWebShopClient {

    WebShopClientService webShopClientService;

    @Autowired
    RestWebShopClient(WebShopClientService webShopClientService) {
        this.webShopClientService = webShopClientService;
    }

    @GetMapping
    public void callProductApplicationService() {
        webShopClientService.callProductApplication();
        webShopClientService.callShoppingApplication();
    }
}
