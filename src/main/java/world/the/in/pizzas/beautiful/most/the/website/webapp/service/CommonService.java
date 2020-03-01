package world.the.in.pizzas.beautiful.most.the.website.webapp.service;

import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface CommonService<T, ID extends Serializable>{

    CrudRepository<T, ID> getRepository();

    default T save(T entity){return getRepository().save(entity);}

    default Iterable<T> saveAll(Iterable<T> entities){return getRepository().saveAll(entities);}

    default Optional<T> findById(ID id){return getRepository().findById(id);}

    default boolean existsById(ID id){return getRepository().existsById(id);}

    default List<T> findAll(){return (List<T>) getRepository().findAll();}

    default Iterable<T> findAllById(Iterable<ID> id){return getRepository().findAllById(id);}

    default long count(){return getRepository().count();}

    default void deleteById(ID id){getRepository().deleteById(id);}

    default void delete(T entity){getRepository().delete(entity);}

    default void deleteAll(Iterable<? extends T> entities){getRepository().deleteAll(entities);}

    default void deleteAll(){getRepository().deleteAll();}
}
