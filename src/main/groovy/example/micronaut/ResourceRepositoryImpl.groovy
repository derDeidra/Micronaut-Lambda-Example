package example.micronaut

import example.micronaut.domain.Resource
import groovy.transform.CompileStatic
import io.micronaut.configuration.hibernate.jpa.scope.CurrentSession
import io.micronaut.spring.tx.annotation.Transactional

import javax.inject.Singleton
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

@Singleton
@CompileStatic
class ResourceRepositoryImpl implements ResourceRepository {

    @PersistenceContext
    EntityManager entityManager

    ResourceRepositoryImpl(@CurrentSession EntityManager entityManager){
        this.entityManager = entityManager
    }

    @Transactional
    void saveResource(Resource resource){
        entityManager.persist(resource)
    }

    @Transactional
    Optional<Resource> getResource(Long id){
        Optional.ofNullable(entityManager.find(Resource, id))
    }
}
