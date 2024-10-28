package ru.vdovmb.spring.database.repository;

import com.querydsl.core.types.dsl.PathBuilder;
import com.querydsl.jpa.impl.JPAQuery;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.vdovmb.spring.database.entity.BaseEntity;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public abstract class RepositoryBase<K extends Serializable, E extends BaseEntity<K>> implements CrudRepository<K, E> {

    private final Class<E> entityClass;
    private final EntityManager entityManager;

    @Transactional
    @Override
    public E save(E entity) {
        entityManager.persist(entity);
        return entity;
    }

    @Transactional
    @Override
    public void update(E entity) {
        entityManager.merge(entity);
    }

    @Transactional
    @Override
    public void delete(K id) {
        entityManager.remove(id);
        entityManager.flush();
    }

    @Override
    public Optional<E> findById(K id) {
        return Optional.ofNullable(entityManager.find(entityClass, id));
    }

    @Override
    public List<E> findAll() {
       var entityPath = new PathBuilder<>(entityClass, entityClass.getSimpleName().toLowerCase());

        return new JPAQuery<E>(entityManager)
                .select(entityPath)
                .from(entityPath)
                .fetch();
    }
}
