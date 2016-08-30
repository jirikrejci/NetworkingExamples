package com.JKSoft.nasserver;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by Jirka on 25.8.2016.
 */
public class NasFtp extends NasGeneral{

    public static String readFileFromFtp (String remoteFileName) {
        boolean success = false;
        String output_str;

        FTPClient ftpClient = new FTPClient();
        try {
            ftpClient.connect("192.168.0.10", 21);
            ftpClient.login("trader", "traderpass");
            ftpClient.enterLocalPassiveMode();
            ftpClient.setFileType(FTP.ASCII_FILE_TYPE);

            //System.out.println(ftpClient.getStatus().toString());

            InputStream inputStream = ftpClient.retrieveFileStream(remoteFileName);
            output_str = readStreamToString(inputStream);

/*
            System.out.println("Downloaded file <" + remoteFileName + ">:");
            System.out.println(output_str);
*/
            success = ftpClient.completePendingCommand();
            if (success) {
                System.out.println("File has been downloaded successfully.");
            }

            inputStream.close();
            ftpClient.disconnect();
            return output_str;

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(remoteFileName);
            return "Error reading FTP file";
        }
    }


    public static void writeStringToFtp (String remoteFileName, String textToWrite) {
        boolean success = false;

        FTPClient ftpClient = new FTPClient();
        try {
            ftpClient.connect("192.168.0.10", 21);
            ftpClient.login("jirka", "jirkapass");
            ftpClient.enterLocalPassiveMode();
            ftpClient.setFileType(FTP.ASCII_FILE_TYPE);

            //System.out.println(ftpClient.getStatus().toString());


            OutputStream outputStream = ftpClient.storeFileStream(remoteFileName);

            writeStringToStream(outputStream, textToWrite);
            outputStream.flush();
            outputStream.close();
            success = ftpClient.completePendingCommand();
            ftpClient.disconnect();

            if (success) {
                System.out.println("FIle has been succesfully uploaded to FTP");
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(remoteFileName);
        }


    }


}
