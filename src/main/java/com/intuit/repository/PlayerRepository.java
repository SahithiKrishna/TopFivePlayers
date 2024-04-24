package com.intuit.repository;

import com.intuit.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * @author 
 * JPA repository query class
 * Repository is a mechanism for encapsulating storage, retrieval, and search behavior which emulates
 * a collection of objects
 */
@Repository
public interface PlayerRepository  extends JpaRepository<Player, Long>{
}
