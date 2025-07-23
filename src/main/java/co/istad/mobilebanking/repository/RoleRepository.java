package co.istad.mobilebanking.repository;

import co.istad.mobilebanking.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
