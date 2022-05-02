package cccc.vlm.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApplyEquipmentResponse {

    private String equipmentSerialId;

    private String equipmentId;

    private String equipmentName;

    private String qty;

}
