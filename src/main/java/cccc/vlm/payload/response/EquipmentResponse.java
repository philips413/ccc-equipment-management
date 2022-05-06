package cccc.vlm.payload.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EquipmentResponse {

    private int equipmentId;

    private String name;

    private int category;

    private String description;

    private int status;

    private int qty;

    private int useQty;

    private LocalDateTime createdAt;

}
