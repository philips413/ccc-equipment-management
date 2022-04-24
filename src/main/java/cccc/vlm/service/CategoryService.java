package cccc.vlm.service;

import cccc.vlm.entity.Category;
import cccc.vlm.payload.request.InsertCategoryRequest;
import cccc.vlm.payload.request.UpdateCategoryRequest;
import cccc.vlm.payload.response.CategoryResponse;
import cccc.vlm.repository.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CategoryRepository categoryRepository;

    public CategoryResponse insertCategory(InsertCategoryRequest insertCategory) {

        Category request = Category.builder()
                .categoryName(insertCategory.getCategoryName())
                .description(insertCategory.getDescription())
                .build();
        Category category = categoryRepository.save(request);
        CategoryResponse response = modelMapper.map(category, CategoryResponse.class);
        return response;
    }

    public List<CategoryResponse> getCategoryList() {
        List<Category> list = categoryRepository.findAll();
        List<CategoryResponse> categoryList = list.stream()
                .map(item -> modelMapper.map(item, CategoryResponse.class))
                .collect(Collectors.toList());
        return categoryList;
    }


    public CategoryResponse updateCategory(Integer categoryId, UpdateCategoryRequest updateCategoryRequest) {
        Category category = categoryRepository.findById(categoryId).get();
        category.setCategoryName(updateCategoryRequest.getCategoryName());
        category.setDescription(updateCategoryRequest.getDescription());
        Category updateCategory = categoryRepository.save(category);
        return modelMapper.map(updateCategory, CategoryResponse.class);
    }
}
