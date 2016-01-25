package bean;

import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

/**
 * Created by thieste on 17.01.16.
 */
@MappedSuperclass
@Table(name = "de")
@Entity
public class EntityDE extends BaseEntity {

    public EntityDE(String title) {
        super(title);
    }
}
