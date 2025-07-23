package co.istad.mobilebanking.init;

import co.istad.mobilebanking.domain.Role;
import co.istad.mobilebanking.domain.User;
import co.istad.mobilebanking.repository.RoleRepository;
import co.istad.mobilebanking.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class SecurityInit {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @PostConstruct
    void init() {
        if (roleRepository.count() == 0) {
            Role roleUser = new Role();
            roleUser.setName("USER");

            Role roleAdmin = new Role();
            roleAdmin.setName("ADMIN");

            Role roleStaff = new Role();
            roleStaff.setName("STAFF");

            Role roleCustomer = new Role();
            roleCustomer.setName("CUSTOMER");

            roleRepository.saveAll(List.of(roleAdmin, roleStaff, roleCustomer, roleUser));

            User admin = new User();
            admin.setUsername("admin");
            admin.setPassword(passwordEncoder.encode("admin"));
            admin.setIsEnabled(true);
            admin.setRoles(Set.of(roleAdmin,roleUser));
            userRepository.save(admin);
        }
    }

}
