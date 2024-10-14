package ru.vdovmb.dao;

import com.querydsl.core.types.dsl.PathBuilder;
import com.querydsl.jpa.impl.JPAQuery;
import jakarta.persistence.EntityManager;
import lombok.Cleanup;
import lombok.RequiredArgsConstructor;
import org.hibernate.SessionFactory;
import ru.vdovmb.entity.BaseEntity;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public abstract class RepositiryBase<K extends Serializable, E extends BaseEntity<K>> implements Repositiry<K, E> {

    private final Class<E> entityClass;
    private final EntityManager entityManager;

    @Override
    public E save(E entity) {
        entityManager.persist(entity);
        return entity;
    }

    @Override
    public void update(E entity) {
        entityManager.merge(entity);
    }

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
