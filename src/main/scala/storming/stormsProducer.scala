package storming

import org.apache.camel.Exchange
import org.apache.camel.impl.DefaultProducer


/**
 * The storms producer.
 */
class stormsProducer(endpoint: stormsEndpoint) extends DefaultProducer(endpoint) {

  def process(exchange: Exchange) : Unit = {
    println(exchange.getIn().getBody())
  }

}
