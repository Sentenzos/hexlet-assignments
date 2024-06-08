package exercise.specification;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import exercise.dto.ProductParamsDTO;
import exercise.model.Product;

// BEGIN
@Component // Для возможности автоматической инъекции
public class ProductSpecification {
    // Генерация спецификации на основе параметров внутри DTO
    // Для удобства каждый фильтр вынесен в свой метод
    public Specification<Product> build(ProductParamsDTO params) {
        return withRating(params.getRatingGt())
                .and(withHigherPrice(params.getPriceGt()))
                .and(withLowerPrice(params.getPriceLt()))
                .and(withCategoryId(params.getCategoryId()))
                .and(withTitle((params.getTitleCont())));
    }


    private Specification<Product> withCategoryId(Long categoryId) {
        return (root, query, cb) -> {
            return categoryId == null ? cb.conjunction() : cb.equal(root.get("category").get("id"), categoryId);
        };
    }

    private Specification<Product> withHigherPrice(Integer price) {
        return (root, query, cb) -> price == null ? cb.conjunction() : cb.greaterThan(root.get("price"), price);
    }

    private Specification<Product> withLowerPrice(Integer price) {
        return (root, query, cb) -> price == null ? cb.conjunction() : cb.lessThan(root.get("price"), price);
    }

    private Specification<Product> withRating(Double rating) {
        return (root, query, cb) -> {
            return rating == null ? cb.conjunction() : cb.greaterThanOrEqualTo(root.get("rating"), rating);
        };
    }

    private Specification<Product> withTitle(String title) {
        return (root, query, cb) -> {
            return title == null ? cb.conjunction() : cb.like(root.get("title".toLowerCase()), title.toLowerCase());
        };
    }
}
// END
