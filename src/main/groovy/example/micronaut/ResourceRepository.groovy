package example.micronaut

import example.micronaut.domain.Resource

interface ResourceRepository {

    void saveResource(Resource resource)

    Optional<Resource> getResource(Long id)

}
