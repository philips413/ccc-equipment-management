package cccc.vlm.payload.response;

import lombok.Data;

@Data
public class EquipmentResponse {

    private int equipmentId;

    private String name;

    private int category;

    private String description;

    private int status;

    private int qty;

    private int maxUseQty;

    private int minUseQty;

    private String createdAt;

    private int createdId;

}
