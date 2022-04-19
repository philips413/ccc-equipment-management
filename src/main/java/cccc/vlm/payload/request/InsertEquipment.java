package cccc.vlm.payload.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InsertEquipment {

    private String name;

    private String category;

    private String description;

    private String status;

    private int qty;

    private String maxUseQty;

    private String minUseQty;

    private String createdId;
}
