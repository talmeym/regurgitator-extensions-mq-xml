# regurgitator-extensions-mq-xml

regurgitator is a lightweight, modular, extendable java framework that you configure to 'regurgitate' canned or clever responses to incoming requests; useful for quickly mocking or prototyping services without writing any code. simply configure, deploy and run.

start your reading here: [regurgitator-all](http://github.com/talmeym/regurgitator-all#regurgitator)

## extension mq steps in xml

### create-jms-response

a create-jms-response step returns a response from regurgitator, allowing ``response-metadata`` parameters to be set for ``jms-destination``, ``correlation-id`` and ``jms-type``:

```xml
<rgw:create-http-response source="response" jms-message-id="message-id" jms-type="my-jms-type" jms-destination="queue://my-destination" correlation-id="52908d79-b7c6-4e18-ab13-e991d1b67d8b" jms-delivery-mode=4 jms-expiration="" jms-redelivered=true jms-reply-to="queue://other-destination" jms-timestamp=123456789 />
```
