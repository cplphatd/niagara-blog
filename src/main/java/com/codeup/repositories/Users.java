package com.codeup.repositories;

import com.codeup.models.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by David on 2/10/17.
 */
public interface Users extends CrudRepository <User, Long> {

}
