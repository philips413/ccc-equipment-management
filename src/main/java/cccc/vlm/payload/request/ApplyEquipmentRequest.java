package cccc.vlm.payload.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApplyEquipmentRequest implements RequestTemplate{

    private int equipmentId;

    private int userId;

    private String name;

    private int category;

    private String propose;

    private int qty;

    private String hp;

    @Override
    public boolean verify() {
        return true;
    }
}
