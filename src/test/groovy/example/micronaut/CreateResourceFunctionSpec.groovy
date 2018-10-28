package example.micronaut

import io.micronaut.context.ApplicationContext
import io.micronaut.runtime.server.EmbeddedServer
import spock.lang.Specification

class CreateResourceFunctionSpec extends Specification {

    void "Create and retrieve resource"() {
        given:
        String content = "t1"
        EmbeddedServer server = ApplicationContext.run(EmbeddedServer)
        ResourceTestClient client = server.getApplicationContext().getBean(ResourceTestClient)

        when:
        Long id = client.createResource(content).blockingGet()

        then:
        client.getResource(id).blockingGet().content == content

        cleanup:
        server.stop()
        server.close()
    }
}
