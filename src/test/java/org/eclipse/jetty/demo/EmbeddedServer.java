package org.eclipse.jetty.demo;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.DefaultHandler;
import org.eclipse.jetty.server.handler.HandlerCollection;
import org.eclipse.jetty.toolchain.test.MavenTestingUtils;
import org.eclipse.jetty.util.resource.PathResource;
import org.eclipse.jetty.webapp.Configuration;
import org.eclipse.jetty.webapp.WebAppContext;

public class EmbeddedServer
{
    public static void main(String[] args) throws Exception
    {
        Server server = new Server(8080);
        HandlerCollection handlers = new HandlerCollection();

        Configuration.ClassList.setServerDefault(server)
                .addBefore("org.eclipse.jetty.webapp.JettyWebXmlConfiguration",
                        "org.eclipse.jetty.annotations.AnnotationConfiguration");

        WebAppContext webapp = new WebAppContext();
        webapp.setContextPath("/demo");
        webapp.setBaseResource(new PathResource(MavenTestingUtils.getProjectDirPath("src/main/webapp")));
        webapp.setExtraClasspath(MavenTestingUtils.getTargetPath("classes").toRealPath().toString());

        handlers.addHandler(webapp);
        handlers.addHandler(new DefaultHandler());

        server.setHandler(handlers);

        // server.setDumpAfterStart(true);
        server.start();
        server.join();
    }
}
