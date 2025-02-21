package ua.pudgecorporation.zxctube.user.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.pudgecorporation.zxctube.core.controller.CommonController;
import ua.pudgecorporation.zxctube.user.dto.UserDTO;
import ua.pudgecorporation.zxctube.user.service.UserService;

@RestController
@RequestMapping("/api/v1/user")
public class UserController extends CommonController<UserDTO> {

    public UserController(UserService service) {
        super(service);
    }
}
