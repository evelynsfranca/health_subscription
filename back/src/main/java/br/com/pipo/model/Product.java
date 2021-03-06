package br.com.pipo.model;

import br.com.pipo.model.enumeration.ProductCategoryType;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

@Data
@Document
public class Product implements Serializable {

    @Id
    private String id;

    private String name;

    private ProductCategoryType category;

    @DBRef
    private Partner partner;

    @DBRef
    private List<Client> clients;
}
