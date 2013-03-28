/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.mobiweb.mobile.util;

/**
 *
 * @author Ahmed Maawy
 */
public class ServerResponse {
    private StringBuffer responseMessage;
    private StringBuffer mainMessage;
    private String statusMessage;

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public ServerResponse() {
        // Do nothing
        this.responseMessage = new StringBuffer("");
        this.mainMessage = new StringBuffer("");
        statusMessage = "null";
    }

    public ServerResponse(String responseMessage) {
        // Initialize responseMessage
        this.responseMessage = new StringBuffer(responseMessage);
        this.mainMessage = new StringBuffer("");
        statusMessage = "null";
    }

    public StringBuffer getMainMessage() {
        return mainMessage;
    }

    public void setMainMessage(StringBuffer mainMessage) {
        this.mainMessage = mainMessage;
    }

    public StringBuffer getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(StringBuffer responseMessage) {
        this.responseMessage = responseMessage;
    }
}
