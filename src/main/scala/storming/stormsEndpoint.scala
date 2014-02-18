package storming

import org.apache.camel.{Consumer, Processor, Producer}
import org.apache.camel.impl.DefaultEndpoint

/**
 * Represents a storms endpoint.
 */
class stormsEndpoint(uri:String, component: stormsComponent) extends DefaultEndpoint(uri, component) {

  def createProducer() : Producer = {
    new stormsProducer(this)
  }

  def createConsumer(processor: Processor) : Consumer = {
    new stormsConsumer(this, processor)
  }

  def isSingleton() : Boolean = true

}
