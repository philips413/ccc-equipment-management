package cccc.vlm.payload.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApplyEquipmentResponse {

    private String equipmentSerialId;

    private int equipmentId;

    private String equipmentName;

    private int qty;

}
