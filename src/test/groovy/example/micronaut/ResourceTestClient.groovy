package example.micronaut

import example.micronaut.domain.Resource
import io.micronaut.function.client.FunctionClient
import io.reactivex.Single

import javax.inject.Named

@FunctionClient
interface ResourceTestClient {

    @Named("create-resource")
    Single<Long> createResource(String content)

    @Named("get-resource")
    Single<Resource> getResource(Long id)
}
