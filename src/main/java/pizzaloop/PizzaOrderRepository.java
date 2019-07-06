package pizzaloop;

import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface PizzaOrderRepository extends CrudRepository<PizzaOrderDetails, Integer> {
    /*
     * Find pizza by Id
     */
     List<PizzaOrderDetails> findByOrderId(Integer id);

    /*
     * Delete pizza by Id
     */
     List<PizzaOrderDetails> deleteByOrderId(Integer id);
}

