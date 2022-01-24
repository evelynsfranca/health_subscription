package br.com.pipo.facade.dto.partner;

import br.com.pipo.model.enumeration.PartnerName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PartnerToGetAllDTO implements Serializable {

    private String id;

    private PartnerName name;
}
