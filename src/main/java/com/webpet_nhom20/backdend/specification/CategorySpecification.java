package com.webpet_nhom20.backdend.specification;

import com.webpet_nhom20.backdend.entity.Categories;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

public class CategorySpecification {
    public static Specification<Categories> buildWhere(String search) {
        if (!StringUtils.hasText(search)) {
            return (root, query, cb) -> cb.conjunction(); // always true
        }
        search = search.trim();
        return new CustomSpecification("name", search);
    }
}

@RequiredArgsConstructor
class CustomSpecification implements Specification<Categories> {
    @NonNull
    private final String field;
    @NonNull
    private final String value;

    @Override
    public Predicate toPredicate(Root<Categories> root,
                                 CriteriaQuery<?> query,
                                 CriteriaBuilder cb) {
        if (field.equalsIgnoreCase("name")) {
            return cb.like(root.get("name"), "%" + value + "%");
        }
        return cb.conjunction();
    }
}
