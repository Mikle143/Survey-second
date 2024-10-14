package ru.vdovmb.dao;

import com.querydsl.core.types.ExpressionUtils;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class QPredicate {

    private List<Predicate> predicates = new ArrayList<Predicate>();

    public static QPredicate builder() {
        return new QPredicate();
    }

    public <T> QPredicate add(T object, Function<T, Predicate> function) {
        if (object != null) {
            predicates.add(function.apply(object));
        }
        return this;
    }

    public com.querydsl.core.types.Predicate buildAnd() {
        return ExpressionUtils.allOf((com.querydsl.core.types.Predicate) predicates);
    }

    public com.querydsl.core.types.Predicate buildOr() {
        return ExpressionUtils.anyOf((com.querydsl.core.types.Predicate) predicates);
    }

}
