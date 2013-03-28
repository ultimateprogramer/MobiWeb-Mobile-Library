/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.mobiweb.mobile;

import org.mobiweb.mobile.exceptions.ConnectionException;
import org.mobiweb.mobile.util.ServerCommunicationStatus;

/**
 *
 * @author Ahmed Maawy
 */
public class ServerCommunicationThread implements Runnable {

    private Message message;
    private String url;

    public ServerCommunicationThread(Message message, String url) {
        this.message = message;
        this.url = url;
    }

    public void run() {
        // Run server interface as thread
        ServerCommunication serverCommunication = new ServerCommunication(url, true);

        try {
            ServerCommunicationStatus.setResponseStatus(false);
            ServerCommunicationStatus.writeServerResponse(serverCommunication.sendPostMessage(message));
            ServerCommunicationStatus.setResponseStatus(true);
        } catch (ConnectionException ex) {
            ex.printStackTrace();
        }

        serverCommunication.closeConnection();
    }

}
