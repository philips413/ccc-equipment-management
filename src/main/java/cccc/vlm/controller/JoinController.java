package cccc.vlm.controller;

import cccc.vlm.payload.response.VerifyIdResponse;
import cccc.vlm.service.JoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/join")
public class JoinController {

    @Autowired
    private JoinService joinService;

    @GetMapping("/verifyid")
    public VerifyIdResponse canUsingUserId(@RequestBody VerifyIdRequest request) {
        return joinService.canUsingUserId(request);
    }
}
