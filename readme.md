
Example of using WebSocket on Jetty.

This project uses maven.
This checkout is a valid ${jetty.base} directory too.

To build:

  $ mvn clean install

  This should have created a webapps/root.war file for you

To run in jetty distribution:

  $ java -jar /path/to/jetty-distribution-9.4.6.v20170531/start.jar

To test:

  1) Open http://localhost:8080/ in your websocket capable web browser


