package uz.pdp.appsecurityforme.service;

import org.springframework.stereotype.Service;
import uz.pdp.appsecurityforme.dto.AddAdminDTO;
import uz.pdp.appsecurityforme.dto.ChangePasswordDTO;
import uz.pdp.appsecurityforme.dto.UserDTO;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public UserDTO addAdmin(AddAdminDTO addAdminDTO) {
        return null;
    }

    @Override
    public UserDTO removeAdmin(Long id) {
        return null;
    }

    @Override
    public List<UserDTO> listAllUsers() {
        return null;
    }

    @Override
    public List<UserDTO> getAllAdmins() {
        return null;
    }

    @Override
    public UserDTO getById(Long id) {
        return null;
    }

    @Override
    public UserDTO changePassword(ChangePasswordDTO changePasswordDTO) {
        return null;
    }
}
