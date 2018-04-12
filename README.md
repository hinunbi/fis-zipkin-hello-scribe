# FIS Spring-Boot Zipkin Hello (Scribe)

This example demonstrates how you can use Apache Camel Zipkin component with Spring Boot.

It uses Spring Boot to send zipkin every 10 event messages using thrift protocol, and routes the message to a log.

### Building

The example can be built with

    mvn clean install

### Running the application on local host


The example can be built and run on local host:

The zipkin connection url environment variable, "ZIPKIN_HOST_NAME", "ZIPKIN_PORT" or Java system property should be set when running the example.

    mvn -s configuration/settings.xml spring-boot:run -DZIPKIN_HOST_NAME=zipkinhost -DZIPKIN_PORT=9410


### Running the example in OpenShift

It is assumed that:
- OpenShift platform is already running, if not you can find details how to [Install OpenShift at your site](https://docs.openshift.com/container-platform/3.3/install_config/index.html).
- Your system is configured for Fabric8 Maven Workflow, if not you can find a [Get Started Guide](https://access.redhat.com/documentation/en/red-hat-jboss-middleware-for-openshift/3/single/red-hat-jboss-fuse-integration-services-20-for-openshift/)

The example can be built and run on OpenShift using a single goal:

    mvn -s configuration/settings.xml fabric8:deploy

When the example runs in OpenShift, you can use the OpenShift client tool to inspect the status

To list all the running pods:

    oc get pods

Then find the name of the pod that runs this quickstart, and output the logs from the running pods with:

    oc logs <name of pod>

You can also use the openshift [web console](https://docs.openshift.com/container-platform/3.3/getting_started/developers_console.html#developers-console-video) to manage the
running pods, and view logs and much more.

