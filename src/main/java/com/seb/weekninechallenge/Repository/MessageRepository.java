package com.seb.weekninechallenge.Repository;

import com.seb.weekninechallenge.Model.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message,Long> {

}
