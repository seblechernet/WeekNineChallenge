package com.seb.weekninechallenge.Repository;

import com.seb.weekninechallenge.Model.AppUser;
import com.seb.weekninechallenge.Model.Message;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessageRepository extends CrudRepository<Message,Long> {
      List<Message> findAllByTo(AppUser to);
}
