package com.seb.weekninechallenge.Repository;

import com.seb.weekninechallenge.Model.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role,Long> {
    Role findByRole(String role);
}
