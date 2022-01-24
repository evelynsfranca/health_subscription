package br.com.pipo.facade.dto.partner;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PartnerToSimpleDTO implements Serializable {

    private String id;
}
