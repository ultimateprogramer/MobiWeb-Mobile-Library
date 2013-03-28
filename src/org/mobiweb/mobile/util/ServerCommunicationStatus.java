/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.mobiweb.mobile.util;

/**
 *
 * @author Ahmed Maawy
 */
public class ServerCommunicationStatus {
    public static ServerResponse serverResponse;
    public static boolean responseStatus;

    public static synchronized void writeServerResponse(ServerResponse myResponse) {
        serverResponse = myResponse;
    }

    public static synchronized void setResponseStatus(boolean synchronizationStatus) {
        responseStatus = synchronizationStatus;
    }
}
