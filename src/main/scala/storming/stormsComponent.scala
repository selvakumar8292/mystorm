package storming


import org.apache.camel.Endpoint
import org.apache.camel.impl.DefaultComponent
import java.util.Map

/**
 * Represents the component that manages {@link stormsEndpoint}.
 */
class stormsComponent extends DefaultComponent {

  protected def createEndpoint(uri: String, remaining: String, parameters: Map[String, Object]): Endpoint = {

    val endpoint = new stormsEndpoint(uri, this)
    setProperties(endpoint, parameters)

    endpoint
  }
}
