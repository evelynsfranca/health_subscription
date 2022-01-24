package br.com.pipo.facade.dto.client;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientToCreateDTO implements Serializable {

    @NotBlank
    private String name;
}
