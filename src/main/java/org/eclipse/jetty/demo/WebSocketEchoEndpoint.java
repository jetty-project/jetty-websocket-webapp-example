//
//  ========================================================================
//  Copyright (c) 1995-2015 Mort Bay Consulting Pty. Ltd.
//  ------------------------------------------------------------------------
//  All rights reserved. This program and the accompanying materials
//  are made available under the terms of the Eclipse Public License v1.0
//  and Apache License v2.0 which accompanies this distribution.
//
//      The Eclipse Public License is available at
//      http://www.eclipse.org/legal/epl-v10.html
//
//      The Apache License v2.0 is available at
//      http://www.opensource.org/licenses/apache2.0.php
//
//  You may elect to redistribute this code under either of these licenses.
//  ========================================================================
//

package org.eclipse.jetty.demo;

import java.io.IOException;
import java.nio.ByteBuffer;

import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.WebSocketException;
import org.eclipse.jetty.websocket.api.WebSocketPartialListener;
import org.eclipse.jetty.websocket.api.WebSocketPingPongListener;

public class WebSocketEchoEndpoint implements WebSocketPartialListener, WebSocketPingPongListener
{
    private Session session;

    @Override
    public void onWebSocketConnect(Session session)
    {
        this.session = session;
    }

    @Override
    public void onWebSocketPartialBinary(ByteBuffer byteBuffer, boolean b)
    {
        try
        {
            session.getRemote().sendPartialBytes(byteBuffer, b);
        }
        catch (IOException e)
        {
            throw new WebSocketException(e);
        }
    }

    @Override
    public void onWebSocketPartialText(String s, boolean b)
    {
        try
        {
            session.getRemote().sendPartialString(s, b);
        }
        catch (IOException e)
        {
            throw new WebSocketException(e);
        }
    }

    @Override
    public void onWebSocketPing(ByteBuffer byteBuffer)
    {
        // The implementation will automatically send back a PONG after receiving a PING message.
    }

    @Override
    public void onWebSocketPong(ByteBuffer byteBuffer)
    {
        // Nothing to do for the echo case.
    }

    @Override
    public void onWebSocketClose(int i, String s)
    {
    }

    @Override
    public void onWebSocketError(Throwable throwable)
    {
        throwable.printStackTrace();
    }

}
