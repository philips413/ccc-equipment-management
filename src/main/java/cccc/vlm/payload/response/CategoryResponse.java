package cccc.vlm.payload.response;

import lombok.Data;

@Data
public class CategoryResponse {

    private Integer categoryId;

    private String categoryName;

    private String description;

    private String createdAt;

    private String createdId;
}
