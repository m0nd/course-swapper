package edu.mum.users.dao;

import edu.mum.users.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserDao extends JpaRepository<User, Long> {
}
