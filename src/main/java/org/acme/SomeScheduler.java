package org.acme;

import io.quarkus.runtime.StartupEvent;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.transaction.Transactional;
import java.util.UUID;

@ApplicationScoped
@Transactional
public class SomeScheduler {

    @Inject
    EntityManager em;

    public void onStart(@Observes StartupEvent e) {
        SomeEntity entity = new SomeEntity();
        entity.setName(UUID.randomUUID().toString());

        em.persist(entity);
    }
}
