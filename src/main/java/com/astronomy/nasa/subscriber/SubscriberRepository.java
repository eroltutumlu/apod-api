package com.astronomy.nasa.subscriber;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface SubscriberRepository extends CrudRepository<Subscriber, Long> {

}
