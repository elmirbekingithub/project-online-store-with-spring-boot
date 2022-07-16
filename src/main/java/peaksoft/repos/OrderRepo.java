package peaksoft.repos;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import peaksoft.entities.Order;
import peaksoft.entities.User;

import java.util.List;

@Repository
public interface OrderRepo extends JpaRepository<Order, Integer> {
    List<Order> findAllByUser(User user);
}
