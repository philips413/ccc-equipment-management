package cccc.vlm.payload.request;

import lombok.Data;

@Data
public class UsingEquipmentRequest implements RequestTemplate{

    private Integer equipmentId;

    private String name;

    private String hp;

    private String propose;

    private Integer qty;

    private Integer userId;

    private Integer category;

    @Override
    public boolean verify() {
        return false;
    }
}
