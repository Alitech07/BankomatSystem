package spring.BankomatSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.BankomatSystem.entity.Bank;
import spring.BankomatSystem.entity.Role;
import spring.BankomatSystem.entity.User;
import spring.BankomatSystem.entity.enums.RoleName;
import spring.BankomatSystem.payload.ApiResponse;
import spring.BankomatSystem.payload.UserDto;
import spring.BankomatSystem.repository.BankRepository;
import spring.BankomatSystem.repository.RoleRepository;
import spring.BankomatSystem.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    BankRepository bankRepository;

    public List<User> getUsersService(){
        return userRepository.findAll();
    }

    public User getUserService(Integer id){
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.orElse(null);
    }

    /**
     * Yangi user qo'shildi.
     * @param userDto
     * @return
     */
    public ApiResponse addUserService(UserDto userDto){
        boolean existsed = userRepository.existsByEmail(userDto.getEmail());
        if (existsed) return new ApiResponse("Email oldin ro'yhatdan o'tgan boshqa email kiriting.",false);
        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setRole(roleRepository.getRoleByRoleName(RoleName.ROLE_NAME_EMPLOYEE));

        Optional<Bank> optionalBank = bankRepository.findById(userDto.getBankId());
        if (!optionalBank.isPresent()) return new ApiResponse("Bunday bank mavjud emas.",false);
        user.setBank(optionalBank.get());
        userRepository.save(user);
        return new ApiResponse("User saqlandi.",true);
    }

    /**
     * Userni o'chirildi.
     * @param id
     * @return
     */
    public ApiResponse deleteUserService(Integer id){
        Optional<User> optionalUser = userRepository.findById(id);
        if (!optionalUser.isPresent()) return new ApiResponse("Bunday user mavjud emas.",false);
        userRepository.deleteById(id);
        return new ApiResponse("User o'chirildi.",true);
    }
}
