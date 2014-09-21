Weld's Examples
===============

Weld currently comes with a number of examples:

* `jsf/numberguess` (a simple war example for JSF)
* `jsf/login` (a simple war example for JSF)
* `jsf/translator` (a simple EJB example for JSF)
* `jsf/pastecode` (a more complex EJB example for JSF)
* `jsf/permalink` (a more complex war example for JSF)
* `se/numberguess` (the numberguess example for Java SE using Swing)
* `se/helloworld` (a simple example for Java SE)
* `osgi/paint` (a simple OSGi example)

Before running the examples, you'll need to ensure your server supports CDI (WildFly 8 and
GlassFish v4 both have built in support, and Weld provides support for Tomcat, Jetty and
Google App Engine). Weld also supports Java SE and OSGi. 

The examples and Weld are explained in detail in the reference guide, including
how to deploy the examples to WildFly, and how to deploy the examples to Tomcat. Most
examples also have a README which explains how to run the example on all servers it supports. 


Running the functional tests for the JSF examples
------------------------------------------------

Weld's JSF examples come with functional tests, which use Selenium to test each flow a user can 
take through the GUI of the example.

The functional tests can be run on an individual JSF examples or on all examples. WildFly 8
must be installed to run the functional tests. 

Make sure you have set the `JBOSS_HOME` environment property to point to your WildFly distribution.

To run the functional tests:

    mvn -Darquillian=wildfly-managed-8 clean verify

You can run the functional tests against all examples (from the `examples` directory) or against
an individual example (from its sub-directory).

The` jsf/numberguess` example can also be tested in a cluster. Follow these steps for a default configuration:

1. Create two WildFly 8 distributions, so you have, e.g.

        /home/foo/testing/node1/wildfly-8.0.0.Final/

    and

        /home/foo/testing/node2/wildfly-8.0.0.Final/

2. Configure each of the installations' `standalone/configuration/standalone-ha.xml` files

    Edit the `<interfaces/>` element to bind each instance to a different loopback IP address, e.g.

        <loopback-address value="127.0.1.1"/>

    and

        <loopback-address value="127.0.2.1"/>
       
3. Run the test suite, modify the `node{1,2}.jbossHome` properties to match your configuration

        mvn clean verify -Pwildfly-cluster -Darquillian=wildfly-cluster-8 -Dnode1.jbossHome=/home/foo/testing/node1/wildfly-8.0.0.Final/ -Dnode2.jbossHome=/home/foo/testing/node2/wildfly-8.0.0.Final/

   If you have set up a different addresses in the previous step, you also need to add the following system properties:

        -Dnode1.contextPath=http://127.0.1.1:8080/weld-numberguess -Dnode2.contextPath=http://127.0.2.1:8080/weld-numberguess

The `jsf/numberguess` and `jsf/permalink` examples can be also tested with Tomcat and Jetty embedded containers. The following command will execute functional tests with embedded Tomcat container:

    mvn -Ptomcat -Darquillian=tomcat-embedded-6 clean verify 

The following command will execute functional tests with embedded Jetty container:

    mvn -Pjetty -Darquillian=jetty-embedded-7 clean verify

