package cccc.vlm.service;

import cccc.vlm.entity.Category;
import cccc.vlm.payload.request.InsertCategoryRequest;
import cccc.vlm.repository.CategoryRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

@SpringBootTest
@Transactional
class CategoryServiceTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void 카테고리_등록() {
        // given
        InsertCategoryRequest request = InsertCategoryRequest.builder()
                .categoryName("장비 1")
                .build();

        request.verify();

        Category category = Category.builder()
                .categoryName(request.getCategoryName())
                .build();

        //when
        Category saveCategory = categoryRepository.save(category);


        //then
        Assertions.assertEquals(saveCategory.getCategoryName(), request.getCategoryName());
    }


}