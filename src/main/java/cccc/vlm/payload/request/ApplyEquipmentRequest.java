package cccc.vlm.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApplyEquipmentRequest implements RequestTemplate{

    private int equipmentId;

    private int qty;

    private String description;

    private int userId;

    @Override
    public boolean verify() {
        return true;
    }
}
