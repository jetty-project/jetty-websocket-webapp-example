package org.eclipse.jetty.demo;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.eclipse.jetty.websocket.server.WebSocketUpgradeFilter;

@WebListener
public class UpgradeFilterContextListener implements ServletContextListener
{
    @Override
    public void contextInitialized(ServletContextEvent sce)
    {
        WebSocketUpgradeFilter filter = (WebSocketUpgradeFilter)sce.getServletContext().getAttribute("org.eclipse.jetty.websocket.server.WebSocketUpgradeFilter");
        filter.addMapping("/websocket/filter/echo", (req, resp) -> new WebSocketEchoEndpoint());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce)
    {
    }
}
