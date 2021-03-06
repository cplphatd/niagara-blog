package com.codeup.repositories;

import com.codeup.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by David on 2/10/17.
 */

@Repository
public interface Users extends CrudRepository <User, Long> {

    User findByUsername (String username);

}
