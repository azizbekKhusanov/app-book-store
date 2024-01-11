package uz.pdp.appsecurityforme.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.appsecurityforme.dto.AddAdminDTO;
import uz.pdp.appsecurityforme.dto.ChangePasswordDTO;
import uz.pdp.appsecurityforme.dto.UserDTO;
import uz.pdp.appsecurityforme.payload.ApiResult;
import uz.pdp.appsecurityforme.service.UserService;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class UserControllerImpl implements UserController{

    private final UserService userService;

    @Override
    public HttpEntity<ApiResult<UserDTO>> addAdmin(AddAdminDTO addAdminDTO) {
        UserDTO userDTO = userService.addAdmin(addAdminDTO);
        return ResponseEntity.ok(ApiResult.successResponse(userDTO));
    }

    @Override
    public HttpEntity<ApiResult<UserDTO>> removeAdmin(Long id) {
        UserDTO userDTO = userService.removeAdmin(id);
        return ResponseEntity.ok(ApiResult.successResponse(userDTO));
    }

    @Override
    public HttpEntity<ApiResult<List<UserDTO>>> getAllUsers() {
        List<UserDTO> list = userService.listAllUsers();
        return ResponseEntity.ok(ApiResult.successResponse(list));
    }

    @Override
    public HttpEntity<ApiResult<List<UserDTO>>> getAllAdmins() {
        List<UserDTO> listAdmins = userService.getAllAdmins();
        return ResponseEntity.ok(ApiResult.successResponse(listAdmins));
    }

    @Override
    public HttpEntity<ApiResult<UserDTO>> getById(Long id) {
        UserDTO userDTO = userService.getById(id);
        return ResponseEntity.ok(ApiResult.successResponse(userDTO));
    }

    @Override
    public HttpEntity<ApiResult<UserDTO>> changePassword(Long id, ChangePasswordDTO changePasswordDTO) {
        UserDTO userDTO = userService.changePassword(changePasswordDTO);
        return ResponseEntity.ok(ApiResult.successResponse(userDTO));
    }
    
}
