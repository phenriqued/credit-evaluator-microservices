package github.phenriqued.user.infra.repository.user.custom.impl;

import github.phenriqued.user.domain.user.UserEntity;
import github.phenriqued.user.infra.repository.user.custom.UserRepositoryCustom;
import github.phenriqued.user.infra.repository.user.custom.param.UserFilterParams;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class UserRepositoryCustomImpl implements UserRepositoryCustom {

    private EntityManager entityManager;


    @Override
    public List<UserEntity> getWithFilter(UserFilterParams params) {

        CriteriaBuilder criteriaBuilder = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<UserEntity> query = criteriaBuilder.createQuery(UserEntity.class);

        Root<UserEntity> user = query.from(UserEntity.class);

        List<Predicate> predicates = new ArrayList<>();

        if (params.getName() != null){
            predicates.add(criteriaBuilder.like(user.get("name"), "%" + params.getName() + "%"));
        }
        if (params.getCpf() != null){
            predicates.add(criteriaBuilder.like(user.get("cpf"), "%" + params.getCpf() + "%"));
        }
        if (params.getAge() != null){
            predicates.add(criteriaBuilder.equal(user.get("age"), params.getAge()));
        }

        if (!predicates.isEmpty()) {
            query.where(criteriaBuilder.and(predicates.toArray(new Predicate[0])));
        }

        TypedQuery<UserEntity> queryResult = this.entityManager.createQuery(query);

        return queryResult.getResultList();
    }


}
