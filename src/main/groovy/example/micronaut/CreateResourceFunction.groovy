package example.micronaut

import example.micronaut.domain.Resource
import groovy.transform.Field

import javax.inject.Inject

@Field @Inject ResourceRepository resourceRepository

Long createResource(String content) {
    Resource res = new Resource(content: content)
    resourceRepository.saveResource(res)
    res.id
}