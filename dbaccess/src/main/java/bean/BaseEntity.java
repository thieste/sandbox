package bean;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by thieste on 17.01.16.
 */

public class BaseEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private Date install;


    public BaseEntity() {
    }

    public BaseEntity(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getInstall() {
        return install;
    }

    public void setInstall(Date install) {
        this.install = install;
    }
}
