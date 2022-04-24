package cccc.vlm.controller;

import cccc.vlm.payload.request.InsertCategoryRequest;
import cccc.vlm.payload.request.UpdateCategoryRequest;
import cccc.vlm.payload.response.CategoryResponse;
import cccc.vlm.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_FORM_URLENCODED;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public CategoryResponse insertCategory(InsertCategoryRequest insertCategory) {
        insertCategory.verify();
        return categoryService.insertCategory(insertCategory);
    }

    @GetMapping("/list")
    public List<CategoryResponse> getList() {
        return categoryService.getCategoryList();
    }

    @PatchMapping("/{categoryId}")
    public CategoryResponse updateCategory(@PathVariable("categoryId") Integer categoryId, UpdateCategoryRequest updateCategoryRequest) {
        updateCategoryRequest.verify();
        return categoryService.updateCategory(categoryId, updateCategoryRequest);
    }
}
