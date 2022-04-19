package cccc.vlm.controller;

import cccc.vlm.payload.request.InsertEquipmentRequest;
import cccc.vlm.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/equipment")
public class EquipmentController {

    @Autowired
    private EquipmentService equipmentService;

    @PostMapping("/insert")
    public String insertEquipment(@RequestBody InsertEquipmentRequest request) {
        request.verify();
        equipmentService.insertEquipment(request);
        return "TEST";
    }
}
