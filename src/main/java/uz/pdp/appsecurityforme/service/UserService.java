package uz.pdp.appsecurityforme.service;

import uz.pdp.appsecurityforme.dto.AddAdminDTO;
import uz.pdp.appsecurityforme.dto.ChangePasswordDTO;
import uz.pdp.appsecurityforme.dto.UserDTO;

import java.util.List;

public interface UserService {


    UserDTO addAdmin(AddAdminDTO addAdminDTO);

    UserDTO removeAdmin(Long id);

    List<UserDTO> listAllUsers();


    List<UserDTO> getAllAdmins();


    UserDTO getById(Long id);

    UserDTO changePassword(ChangePasswordDTO changePasswordDTO);

}
