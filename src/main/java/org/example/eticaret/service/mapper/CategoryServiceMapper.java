import org.example.eticaret.dto.CategoryDto;
import org.example.eticaret.dto.ProductDto;
import org.example.eticaret.entity.Category;
import org.example.eticaret.entity.Product;
import org.example.eticaret.service.CategoryService;

import java.util.List;
import java.util.stream.Collectors;

public class CategoryServiceMapper {

    public static Category toEntity(CategoryDto categoryDto) {
        return Category.builder()
                .id(categoryDto.getId())
                .name(categoryDto.getName())
                .description(categoryDto.getDescription())
                .products(convertProductDtosToEntities(categoryDto.getProductDtos()))
                .build();
    }

    public static CategoryDto toDto(Category category) {
        return CategoryDto.builder()
                .id(category.getId())
                .name(category.getName())
                .description(category.getDescription())
                .productDtos(convertProductsToDtos(category.getProducts()))
                .build();
    }

    private static List<Product> convertProductDtosToEntities(List<ProductDto> productDtos) {
        return productDtos == null ?
                null :
                productDtos.stream()
                        .map(dto -> Product.builder()
                                .id(dto.getId())
                                .name(dto.getName())
                                .description(dto.getDescription())
                                .price(dto.getPrice())
                                .category(new Category(dto.getCategoryId())) // categoryId ile Category nesnesi oluşturuluyor
                                .build())
                        .collect(Collectors.toList());
    }

    private static List<ProductDto> convertProductsToDtos(List<Product> products) {
        return products == null ?
                null :
                products.stream()
                        .map(entity -> ProductDto.builder()
                                .id(entity.getId())
                                .name(entity.getName())
                                .description(entity.getDescription())
                                .price(entity.getPrice())
                                .categoryId(entity.getCategory() != null ? entity.getCategory().getId() : null) // categoryId ile ProductDto oluşturuluyor
                                .build())
                        .collect(Collectors.toList());
    }
}
