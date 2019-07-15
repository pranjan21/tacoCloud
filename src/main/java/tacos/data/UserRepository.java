package tacos.data;

import org.springframework.data.repository.CrudRepository;
import tacos.domains.User;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);
}
