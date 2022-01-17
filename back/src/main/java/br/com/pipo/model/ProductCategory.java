package br.com.pipo.model;

import br.com.pipo.model.enumeration.ProductCategoryType;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@Document
public class ProductCategory implements Serializable {

    @Id
    private String id;

    private ProductCategoryType name;
}
