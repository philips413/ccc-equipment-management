package cccc.vlm.controller;

import cccc.vlm.payload.request.InsertEquipmentRequest;
import cccc.vlm.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/equipment")
public class EquipmentController {

    @Autowired
    private EquipmentService equipmentService;

    @GetMapping("/insert")
    public String insertEquipment(@RequestAttribute InsertEquipmentRequest request) {
        request.verify();
        equipmentService.insertEquipment(request);
        return "TEST";
    }
}
