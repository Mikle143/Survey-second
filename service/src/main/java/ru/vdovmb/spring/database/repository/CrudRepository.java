package ru.vdovmb.spring.database.repository;

import org.springframework.stereotype.Repository;
import ru.vdovmb.spring.database.entity.BaseEntity;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Repository
public interface CrudRepository<K extends Serializable, E extends BaseEntity<K>> {
    E save(E entity);

    void update(E entity);

    void delete(K id);

    Optional<E> findById(K id);

    List<E> findAll();
}
