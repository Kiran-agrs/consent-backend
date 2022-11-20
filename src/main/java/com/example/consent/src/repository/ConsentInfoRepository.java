package com.example.consent.src.repository;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

@Repository
public class ConsentInfoRepository {
    public <T>List<Object> fetch(EntityManager entityManager, T entityClass, String filterKey, Object filterValue) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> cq = (CriteriaQuery<T>) cb.createQuery(entityClass.getClass());

        Root<T> root = (Root<T>) cq.from(entityClass.getClass());
        Predicate filterDataPredicate = cb.equal(root.get(filterKey), filterValue);
        cq.where(filterDataPredicate);

        TypedQuery<T> query = entityManager.createQuery(cq);
        return (List<Object>) query.getResultList();
    }

    public <T>void update(
            EntityManager entityManager, T entityClass,
            String filterKey, Object filterValue,
            String keyToUpdate,
            Object valueToUpdate
    ) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaUpdate<T> q = (CriteriaUpdate<T>) cb.createCriteriaUpdate(entityClass.getClass());
        Root<T> root = q.from((Class<T>) entityClass.getClass());
        q.set(root.get(keyToUpdate), valueToUpdate)
                .where(cb.equal(root.get(filterKey), filterValue));

        entityManager.createQuery(q).executeUpdate();
    }
}
