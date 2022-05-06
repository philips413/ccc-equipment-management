package cccc.vlm.payload.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.security.InvalidParameterException;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InsertEquipmentRequest implements RequestTemplate {

    private String name;

    private Integer category;

    private String description;

    private Integer qty;

    @Override
    public boolean verify() {
        if (StringUtils.isBlank(this.name)) {
            throw new InvalidParameterException();
        } else if (this.category == null || this.category <= 0) {
            throw new InvalidParameterException();
        } else if (this.qty == null || this.qty <= 0) {
            throw new IllegalArgumentException();
        }
        return true;
    }
}
