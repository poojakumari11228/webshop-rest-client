package webshop.client;

public enum ServerURLS {
    PRODUCT("http://localhost:8080/api/v1/product-catalog"),
    SHOPPING("http://localhost:8081/api/v1/shopping")
    ;

    public final String url;
    ServerURLS(String url) {
        this.url = url;
    }
}
