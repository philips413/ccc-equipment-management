package cccc.vlm.payload.request;

import cccc.vlm.payload.RequestTemplate;
import lombok.Builder;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.security.InvalidParameterException;

@Data
@Builder
public class InsertEquipmentRequest implements RequestTemplate {

    private String name;

    private Integer category;

    private String description;

    private String status;

    private Integer qty;

    private Integer maxUseQty;

    private Integer minUseQty;

    private String createdId;

    @Override
    public boolean verify() {
        if (StringUtils.isBlank(this.name)) {
            throw new InvalidParameterException();
        } else if (this.category == null || this.category <= 0) {
            throw new InvalidParameterException();
        } else if (this.qty == null || this.qty <= 0) {
            throw new IllegalArgumentException();
        } else if (this.maxUseQty == null || this.maxUseQty <= 0) {
            throw new IllegalArgumentException();
        }
        return true;
    }
}
