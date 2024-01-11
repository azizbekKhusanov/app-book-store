package uz.pdp.appsecurityforme.controller;

import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.appsecurityforme.dto.AddAdminDTO;
import uz.pdp.appsecurityforme.dto.ChangePasswordDTO;
import uz.pdp.appsecurityforme.dto.UserDTO;
import uz.pdp.appsecurityforme.payload.ApiResult;

import java.util.List;

@RequestMapping("/api/users")
public interface UserController {

    @PostMapping("/add-admin")
    HttpEntity<ApiResult<UserDTO>> addAdmin(@RequestBody AddAdminDTO addAdminDTO);


    @PostMapping("/remove-admin{id}")
    HttpEntity<ApiResult<UserDTO>> removeAdmin(@PathVariable Long id);


    @GetMapping("/list-users")
    HttpEntity<ApiResult<List<UserDTO>>> getAllUsers();

    @GetMapping("list-admins")
    HttpEntity<ApiResult<List<UserDTO>>> getAllAdmins();


    @GetMapping("/{id}")
    HttpEntity<ApiResult<UserDTO>> getById(@PathVariable Long id);

    @PostMapping("change-password/{id}")
    HttpEntity<ApiResult<UserDTO>> changePassword(@PathVariable Long id,
                                                  @RequestBody ChangePasswordDTO changePasswordDTO);

}
