package cccc.vlm.controller;

import cccc.vlm.payload.request.InsertEquipmentRequest;
import cccc.vlm.payload.response.EquipmentResponse;
import cccc.vlm.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipment")
public class EquipmentController {

    @Autowired
    private EquipmentService equipmentService;

    @PostMapping
    public EquipmentResponse insertEquipment(@RequestBody InsertEquipmentRequest request) {
        request.verify();
        EquipmentResponse equipmentResponse = equipmentService.insertEquipment(request);
        return equipmentResponse;
    }

    @GetMapping("/list")
    public List<EquipmentResponse> getList() {
        return equipmentService.getList();
    }

    @PatchMapping("/{equipmentId}")
    public EquipmentResponse updateEquipment(@PathVariable("equipmentId") Integer equipmentId, InsertEquipmentRequest request) throws NoSuchMethodException {
        request.verify();
        EquipmentResponse response = equipmentService.updateEquipment(equipmentId, request);
        return response;
    }
}
