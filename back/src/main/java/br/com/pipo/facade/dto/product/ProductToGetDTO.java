package br.com.pipo.facade.dto.product;

import br.com.pipo.facade.dto.partner.PartnerToGetDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductToGetDTO implements Serializable {

    private String id;

    private String name;

    private PartnerToGetDTO partner;
}
