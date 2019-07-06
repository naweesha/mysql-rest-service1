package pizzaloop;

import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface UserRepository extends CrudRepository<UserDetails, Integer> {
    
     List<UserDetails> findByUserId(Integer id);

    
     List<UserDetails> deleteByUserId(Integer id);
}
