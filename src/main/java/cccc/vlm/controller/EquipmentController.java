package cccc.vlm.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/equipment")
public class EquipmentController {

    @GetMapping("/list")
    public String getList() {
        return "TEST";
    }
}
