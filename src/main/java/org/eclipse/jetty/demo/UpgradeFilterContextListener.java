package org.eclipse.jetty.demo;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.eclipse.jetty.websocket.server.NativeWebSocketConfiguration;

@WebListener
public class UpgradeFilterContextListener implements ServletContextListener
{
    @Override
    public void contextInitialized(ServletContextEvent sce)
    {
        NativeWebSocketConfiguration n = (NativeWebSocketConfiguration)sce.getServletContext().getAttribute(NativeWebSocketConfiguration.class.getName());
        n.addMapping("/websocket/filter/echo", WebSocketEchoEndpoint.class);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce)
    {
    }
}
