/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.mobiweb.mobile.exceptions;

/**
 *
 * @author Ahmed Maawy
 */
public class MessageException extends Exception {

    /**
     * Creates a new instance of <code>MessageException</code> without detail message.
     */
    public MessageException() {
    }


    /**
     * Constructs an instance of <code>MessageException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public MessageException(String msg) {
        super(msg);
    }
}
