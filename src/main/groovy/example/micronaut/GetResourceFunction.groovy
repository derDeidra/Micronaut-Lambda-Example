package example.micronaut

import example.micronaut.domain.Resource
import groovy.transform.Field

import javax.inject.Inject

@Field @Inject ResourceRepository resourceRepository

Resource getResource(Long id) {
    Optional<Resource> res = resourceRepository.getResource(id)
    res.get()
}