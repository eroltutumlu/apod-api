package com.astronomy.nasa.subscriber;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
interface SubscriberRepository extends CrudRepository<Subscriber, Long> {

    @Query("from Subscriber WHERE email = ?1 AND is_deleted = false")
    List<Subscriber> findActiveSubscriberByEmail(String email);

    @Query("from Subscriber WHERE is_deleted = false")
    List<Subscriber> getActiveSubscribers();

}
