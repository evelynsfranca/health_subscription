package br.com.pipo.facade.dto.employee;

import br.com.pipo.facade.dto.address.AddressToCreateEmployeeDTO;
import br.com.pipo.facade.dto.client.ClientToCreateEmployeeDTO;
import br.com.pipo.facade.dto.product.ProductToCreateEmployeeDTO;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class EmployeeToGetDTO implements Serializable {

    private String id;

    private String cpf;

    private String name;

    private LocalDate admissionDate;

    private String email;

    private String weight;

    private String height;

    private BigDecimal meditationHours;

    private AddressToCreateEmployeeDTO address;

    @Valid
    @NotNull
    private ClientToCreateEmployeeDTO client;

    @Valid
    @NotEmpty
    private List<ProductToCreateEmployeeDTO> products;
}
