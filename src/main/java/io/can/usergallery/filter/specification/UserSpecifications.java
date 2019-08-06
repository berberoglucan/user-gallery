package io.can.usergallery.filter.specification;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;

import io.can.usergallery.enums.EmailFilterPattern;
import io.can.usergallery.model.User;

public class UserSpecifications {

	public static Specification<User> findFilteredUsersByEmail(Set<String> filterParams,
			EmailFilterPattern filterPattern) {

		return (root, query, criteriaBuilder) -> {
			List<Predicate> predicates = new ArrayList<>();

			for (String filterParam : filterParams) {
				String pattern = filterPattern.getPattern().replace("?", filterParam);
				Predicate likePredicate = criteriaBuilder.like(criteriaBuilder.lower(root.get("email")), pattern);
				predicates.add(likePredicate);
			}

			return criteriaBuilder.or(predicates.toArray(new Predicate[predicates.size()]));
		};
	}

	private UserSpecifications() {}

}
