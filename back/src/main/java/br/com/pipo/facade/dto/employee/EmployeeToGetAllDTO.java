package br.com.pipo.facade.dto.employee;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class EmployeeToGetAllDTO implements Serializable {

    private String id;

    private String cpf;

    private String name;
}
