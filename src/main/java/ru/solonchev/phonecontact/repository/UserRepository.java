package ru.solonchev.phonecontact.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.solonchev.phonecontact.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
}
