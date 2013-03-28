/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.mobiweb.mobile.util;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Vector;
import javax.microedition.io.Connector;
import javax.microedition.io.file.FileConnection;
import javax.microedition.io.file.FileSystemRegistry;

/**
 *
 * @author Ahmed Maawy
 */
public class FileBrowser {
    private final static String UP_DIRECTORY = "..";
    private final static String MEGA_ROOT = "/";
    private final static char   SEP = '/';

    public final static String DIRECTORY = "Directory";
    public final static String FILE = "File";
    public final static String FILE_NOT_EXISTING = "File Does not Exist";

    public Vector getCurrDir(String currDirName) throws IOException
    {
        Enumeration e;
        FileConnection currDir = null;
        Vector browser;

        browser = new Vector();
        
        try {
            // Directory listing
            
            if(MEGA_ROOT.equals(currDirName)) {
                // Display root elements
                e = FileSystemRegistry.listRoots();
            }
            else {
                // Display folder elements
                currDir = (FileConnection)Connector.open("file:///" + currDirName);
                e = currDir.list();
            }

            while (e.hasMoreElements()) {
                String fileName = (String)e.nextElement();
                if (fileName.charAt(fileName.length()-1) == SEP) {
                    browser.addElement(fileName);
                }
                else {
                    browser.addElement(fileName);
                }
            }
        }
        catch (IOException ioe) {
            // Error encountered
            ioe.printStackTrace();
            return null;
        }
        
        return browser;
    }

    public String getAttributes(String filePath) throws IOException {
        String fileType = "";
        FileConnection currDir = null;

        try {
            currDir = (FileConnection) Connector.open("file:///" + filePath);

            if(currDir.exists()) {
                // File exists in the file system

                if(filePath.endsWith("/")) {
                    fileType = DIRECTORY;
                }
                else {
                    if(currDir.isDirectory()) {
                        fileType = DIRECTORY;
                    }

                    fileType = FILE;
                }
            }
            else {
                // File non existent
                return FILE_NOT_EXISTING;
            }
        } catch (IOException ex) {
            // Error encountered
            ex.printStackTrace();
            return null;
        }

        return fileType;
    }
}
