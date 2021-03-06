package ch.softappeal.yass.tutorial.client;

import ch.softappeal.yass.transport.TransportSetup;
import ch.softappeal.yass.transport.ws.WsConnection;
import ch.softappeal.yass.transport.ws.WsEndpoint;
import ch.softappeal.yass.tutorial.server.WsServerSetup;

import javax.websocket.ClientEndpointConfig;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;
import java.net.URI;

public abstract class WsClientSetup extends ClientSetup {

    private static final TransportSetup TRANSPORT_SETUP = createTransportSetup(WsServerSetup.REQUEST_EXECUTOR, ClientSession::new);

    private static final class Endpoint extends WsEndpoint {
        @Override protected WsConnection createConnection(final Session session) throws Exception {
            return WsConnection.create(TRANSPORT_SETUP, session);
        }
    }

    protected static void run(final WebSocketContainer container) throws Exception {
        container.connectToServer(
            new Endpoint(),
            ClientEndpointConfig.Builder.create().build(),
            URI.create("ws://" + WsServerSetup.HOST + ":" + WsServerSetup.PORT + WsServerSetup.PATH)
        );
        System.out.println("started");
    }

}
