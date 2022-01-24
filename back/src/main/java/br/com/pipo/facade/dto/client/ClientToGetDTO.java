package br.com.pipo.facade.dto.client;

import br.com.pipo.facade.dto.product.ProductToGetDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientToGetDTO implements Serializable {

    private String id;

    private String name;

    private List<ProductToGetDTO> products;
}
