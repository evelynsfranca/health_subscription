package br.com.pipo.facade.dto.partner;

import br.com.pipo.model.enumeration.PartnerName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PartnerToCreateDTO implements Serializable {

    @NotBlank
    private PartnerName name;
}
