package webshop.client.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@Getter
@NoArgsConstructor
public class CartLineDTO {

    private Long quantity;
    private ProductDTO productDto;
}
