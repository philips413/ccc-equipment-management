package cccc.vlm.controller;

import cccc.vlm.payload.request.InsertEquipmentRequest;
import cccc.vlm.payload.request.UpdateEquipmentRequest;
import cccc.vlm.payload.response.EquipmentResponse;
import cccc.vlm.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipment")
public class EquipmentController {

    @Autowired
    private EquipmentService equipmentService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public EquipmentResponse insertEquipment(InsertEquipmentRequest request) {
        request.verify();
        EquipmentResponse equipmentResponse = equipmentService.insertEquipment(request);
        return equipmentResponse;
    }

    @GetMapping("/list")
    public List<EquipmentResponse> getList() {
        return equipmentService.getList();
    }

    @PatchMapping("/{equipmentId}")
    public EquipmentResponse updateEquipment(@PathVariable("equipmentId") Integer equipmentId, UpdateEquipmentRequest request) throws NoSuchMethodException {
        request.verify();
        EquipmentResponse response = equipmentService.updateEquipment(equipmentId, request);
        return response;
    }
}
