package spring.BankomatSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.BankomatSystem.entity.Role;
import spring.BankomatSystem.entity.enums.RoleName;

public interface RoleRepository extends JpaRepository<Role,Integer> {
    Role getRoleByRoleName(RoleName roleName);
}
