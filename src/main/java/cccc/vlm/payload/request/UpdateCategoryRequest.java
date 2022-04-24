package cccc.vlm.payload.request;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

@Data
public class UpdateCategoryRequest implements RequestTemplate {

    private String categoryName;

    private String description;

    @Override
    public boolean verify() {
        if (StringUtils.isBlank(this.categoryName)) {
            throw new IllegalArgumentException();
        }
        return true;
    }

}
