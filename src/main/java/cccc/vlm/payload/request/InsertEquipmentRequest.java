package cccc.vlm.payload.request;

import cccc.vlm.payload.RequestTemplate;
import lombok.Builder;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.security.InvalidParameterException;

@Data
@Builder
public class InsertEquipmentRequest implements RequestTemplate {

    private Integer equipmentId;
    private String name;

    private Integer category;

    private String description;

    private Integer qty;

    private Integer maxUseQty;

    private Integer minUseQty;

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
