package cccc.vlm.payload.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InsertCategoryRequest implements RequestTemplate{

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
