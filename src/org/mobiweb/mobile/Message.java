/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.mobiweb.mobile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.mobiweb.mobile.util.Common;
import org.mobiweb.mobile.exceptions.MessageException;

/**
 *
 * @author Ahmed Maawy
 */
public class Message {

    private String messageContent;
    private String boundary;

    private byte[] postBytes = null;
    private ByteArrayOutputStream bos = new ByteArrayOutputStream();

    private boolean messageClosed = false;

    public String getBoundary() {
        return boundary;
    }

    public Message() {
        // Initialize the message content

        messageContent = "";
        boundary = Common.generateBoundary();
        messageClosed = false;
    }

    public boolean isMessageClosed() {
        return messageClosed;
    }

    public String getMessageContent() {
        // Getter: Message Content
        
        return messageContent;
    }

    public void addParameter(String paramName, String param) throws MessageException {
        // Adds a parameter to the message

        String messageToAppend = "";

        if(messageClosed) {
            throw new MessageException();
        }

        messageToAppend =
            "--" + boundary + "\r\n" +
            "Content-Disposition: form-data; name=\"param_" + paramName + "\"\r\n\r\n" +
            param + "\r\n";

        messageContent += messageToAppend;

        try {
            bos.write(messageToAppend.getBytes());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void addPhoto(String photoName, byte[] photoData) throws MessageException {
        // Adds a photograph to the message

        String messageToAppend;

        if(messageClosed) {
            throw new MessageException();
        }

        messageToAppend = "--" + boundary + "\r\n" +
            "Content-Disposition: form-data; name=\"photo_"+ photoName +"\"; filename=\""+ photoName +"\"\r\n" +
            "Content-Type: image/png\r\n\r\n";

        messageContent += messageToAppend;
        
        String imageString = new String(photoData);

        messageContent += imageString;
        messageContent += "\r\n";
        
        try {
            bos.write(messageToAppend.getBytes());
            bos.write(photoData);
            bos.write("\r\n".getBytes());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void addFile(String fileName, byte[] fileData) throws MessageException {
        // Adds a file to the message

        String messageToAppend;

        if(messageClosed) {
            throw new MessageException();
        }

        messageToAppend = "--" + boundary + "\r\n" +
            "Content-Disposition: form-data; name=\"file_"+ fileName +"\"; filename=\""+ fileName +"\"\r\n\r\n";

        messageContent += messageToAppend;
        messageContent += new String(fileData);
        messageContent += "\r\n";
        
        try {
            bos.write(messageToAppend.getBytes());
            bos.write(fileData);
            bos.write("\r\n".getBytes());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void closeMessage() {
        // Close the entire message

        String messageToAppend;

        messageToAppend = "\r\n--" + boundary + "--\r\n";
        messageContent += messageToAppend;

        try {
            bos.write(messageToAppend.getBytes());
            bos.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        messageClosed = true;
    }

    public ByteArrayOutputStream getOutputStream() {
        return bos;
    }
}