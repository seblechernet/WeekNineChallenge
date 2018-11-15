package com.seb.weekninechallenge.Repository;

import com.seb.weekninechallenge.Model.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post,Long> {
}
