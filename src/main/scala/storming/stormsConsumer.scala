package storming

import java.util.Date

import org.apache.camel.Processor
import org.apache.camel.impl.ScheduledPollConsumer

/**
 * The storms consumer.
 */
class stormsConsumer(endpoint: stormsEndpoint, processor: Processor) extends ScheduledPollConsumer(endpoint, processor) {

  override def poll() : Int = {
    val exchange = endpoint.createExchange()

    // create a simple message body
    val now = new Date()
    exchange.getIn().setBody("Hello World! The time is " + now)

    try {
      // send message to next processor in the route
      getProcessor().process(exchange)
      return 1 // number of messages polled
    } finally {
      // log exception if an exception occurred and was not handled
      if (exchange.getException() != null) {
        getExceptionHandler().handleException("Error processing exchange", exchange, exchange.getException())
      }
    }
  }
}
