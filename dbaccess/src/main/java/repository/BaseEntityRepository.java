package repository;

import bean.EntityDE;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * Created by thieste on 17.01.16.
 */
@NoRepositoryBean
public interface BaseEntityRepository extends CrudRepository<EntityDE, Long> {

}
