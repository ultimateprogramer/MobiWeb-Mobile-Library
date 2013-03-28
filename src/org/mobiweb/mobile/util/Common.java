package org.mobiweb.mobile.util;


import java.util.Date;
import java.util.Random;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ahmed Maawy
 */
public class Common {
    public static String generateBoundary()
    {
        // Generate the boundary for post request with Content-Type multipart/form-data

        String boundary ="";
        Random random = new Random();
        Date date = new Date();
        random.setSeed(date.getTime());

        boundary += Integer.toHexString(random.nextInt());
        boundary += Integer.toHexString(random.nextInt());

        return "---------------------------" + boundary.substring(4);
    }
}
