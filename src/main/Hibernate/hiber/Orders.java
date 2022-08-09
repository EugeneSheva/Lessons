package hiber;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "orders")
public class Orders implements Serializable {
    @Id
    private int or_id;
    @Id
    private int or_product;

    @Override
    public String toString() {
        return "\n" + "id order" + or_id  + " product" + or_product;
    }
}
