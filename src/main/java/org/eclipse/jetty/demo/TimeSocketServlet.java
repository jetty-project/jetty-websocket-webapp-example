package org.eclipse.jetty.demo;

import javax.servlet.annotation.WebServlet;

import org.eclipse.jetty.websocket.servlet.WebSocketServlet;
import org.eclipse.jetty.websocket.servlet.WebSocketServletFactory;

@WebServlet(name = "TimeSocketServlet", urlPatterns = "/timews/")
public class TimeSocketServlet extends WebSocketServlet
{
    @Override
    public void configure(WebSocketServletFactory factory)
    {
        factory.register(TimeSocket.class);
    }
}
