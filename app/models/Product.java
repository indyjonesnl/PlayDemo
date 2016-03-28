package models;

import javax.persistence.*;

import com.avaje.ebean.*;

/**
 * Created by Indy on 27-3-2016.
 */
@Entity
public class Product extends Model {

    private static final long serialVersionUID = 1L;

    @Id
    public Integer id;

    public String name;

    public Product() {}

    public Product(String name) {
        this.name = name;
    }
}
