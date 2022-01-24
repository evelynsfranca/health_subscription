package br.com.pipo.facade.dto.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductToCreateEmployeeDTO implements Serializable {

    @NotBlank
    private String id;
}
