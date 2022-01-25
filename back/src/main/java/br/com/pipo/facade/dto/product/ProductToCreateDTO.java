package br.com.pipo.facade.dto.product;

import br.com.pipo.facade.dto.partner.PartnerToSimpleDTO;
import br.com.pipo.model.enumeration.ProductCategoryType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductToCreateDTO implements Serializable {

    @NotBlank
    private String name;

    private ProductCategoryType category;

    private PartnerToSimpleDTO partner;
}
