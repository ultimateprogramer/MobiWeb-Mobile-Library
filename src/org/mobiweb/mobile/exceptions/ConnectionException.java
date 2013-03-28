/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.mobiweb.mobile.exceptions;

/**
 *
 * @author Ahmed Maawy
 */
public class ConnectionException extends Exception {

    /**
     * Creates a new instance of <code>ConnectionNotOpenExeption</code> without detail message.
     */
    public ConnectionException() {
    }


    /**
     * Constructs an instance of <code>ConnectionNotOpenExeption</code> with the specified detail message.
     * @param msg the detail message.
     */
    public ConnectionException(String msg) {
        super(msg);
    }
}
