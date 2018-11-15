package com.seb.weekninechallenge.Repository;

import com.seb.weekninechallenge.Model.AppUser;
import org.springframework.data.repository.CrudRepository;

public interface AppUserRepository extends CrudRepository<AppUser,Long> {
    AppUser findByUserName(String username);
    AppUser findByEmail(String email);
    AppUser findByUserId(String userId);
    Long countByEmail(String email);
    Long countByUserName(String Username);

}
