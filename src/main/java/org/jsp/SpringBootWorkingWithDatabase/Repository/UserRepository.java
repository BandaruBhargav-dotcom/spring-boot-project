package org.jsp.SpringBootWorkingWithDatabase.Repository;

import org.jsp.SpringBootWorkingWithDatabase.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>
{
	@Query("SELECT u FROM User WHERE u.email=?1")
	public User login(String email);
}
