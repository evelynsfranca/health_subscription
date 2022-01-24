package br.com.pipo.facade.dto.address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressToCreateEmployeeDTO implements Serializable {

    private String street;

    private String number;

    private String complement;

    private String neighborhood;

    private String city;

    private String state;
}
