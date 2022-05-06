package cccc.vlm.controller;

import cccc.vlm.payload.request.ApplyEquipmentRequest;
import cccc.vlm.payload.response.ApplyEquipmentResponse;
import cccc.vlm.service.EquipmentManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/equipment/manage")
public class EquipmentManageController {

    @Autowired
    private EquipmentManageService equipmentManageService;

    @PostMapping(value = "/apply", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ApplyEquipmentResponse applyEquipment(ApplyEquipmentRequest request) {
        return equipmentManageService.applyEquipment(request);
    }
}
