package br.com.pipo.model;

import br.com.pipo.model.enumeration.PartnerName;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

@Data
@Document
public class Partner implements Serializable {

    @Id
    private String id;

    private PartnerName name;

    @DBRef
    private List<Product> products;
}
