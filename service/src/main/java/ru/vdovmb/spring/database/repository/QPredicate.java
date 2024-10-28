package ru.vdovmb.spring.database.repository;

import com.querydsl.core.types.ExpressionUtils;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

@Repository
@NoArgsConstructor
public class QPredicate {

    private List<com.querydsl.core.types.Predicate> predicates = new ArrayList<com.querydsl.core.types.Predicate>();

    public static QPredicate builder() {
        return new QPredicate();
    }

    public <T> QPredicate add(T object, Function<T, com.querydsl.core.types.Predicate> function) {
        if (object != null) {
            predicates.add(function.apply(object));
        }
        return this;
    }

    public com.querydsl.core.types.Predicate buildAnd() {
        return ExpressionUtils.allOf( predicates);
    }

    public com.querydsl.core.types.Predicate buildOr() {
        return ExpressionUtils.anyOf((com.querydsl.core.types.Predicate) predicates);
    }

}
