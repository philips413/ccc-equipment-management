package cccc.vlm.controller;

import cccc.vlm.payload.request.ApplyEquipmentRequest;
import cccc.vlm.payload.response.ApplyEquipmentResponse;
import cccc.vlm.service.EquipmentManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/equipment/manage")
public class EquipmentManagerController {

    @Autowired
    private EquipmentManagerService equipmentManagerService;

    @PostMapping(value="/apply", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ApplyEquipmentResponse applyEquipment(ApplyEquipmentRequest request) throws Exception {
        request.verify();
        return equipmentManagerService.apply(request);
    }

}
