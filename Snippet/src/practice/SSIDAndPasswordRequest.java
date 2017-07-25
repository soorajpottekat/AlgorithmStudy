
/*
 * Copyright (c) Multichoice Technical Operations. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of
 * Multichoice Technical Operations. ("Confidential Information"). You
 * shall not disclose such Confidential Information and shall use it
 * only in accordance with the terms of the license agreement you
 * entered into with Multichoice Technical Operations.
 *
 * MULTICHOICE MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE
 * SUITABILITY OF THE SOFTWARE, EITHER EXPRESS OR IMPLIED, INCLUDING
 * BUT NOT LIMITED TO THE IMPLIED WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE, OR NON-INFRINGEMENT. MULTICHOICE
 * SHALL NOT BE LIABLE FOR ANY DAMAGES SUFFERED BY LICENSEE AS A RESULT
 * OF USING, MODIFYING OR DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES.
 */


import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by soorajpottekat on 2017/01/25.
 *
 * @author Sooraj Pottekat
 */
public class SSIDAndPasswordRequest {
    
    private int messageType;
    private int senderID;
    private int status;

   
    public int getMessageType()
    {
        return messageType;
    }
    
    public int getSenderId()
    {
        return senderID;
    }
    
    public int getStatus()
    {
        return status;
    }
    
    public void retrieveDetails(byte[] data) throws UnsupportedEncodingException
    {
        data = new byte[]{0};
        String message = "myNetwork\0 test \0";        
         byte[] stringByte = message.getBytes();
        data = MessageHelper.combine(data,stringByte);
        System.out.println("====> " + data);
        System.out.println("===>" + data.length);
        ByteBuffer buffer = ByteBuffer.wrap(data);
        status = buffer.get(0);
        if(status == 0)
        {
            System.out.println("Connection success ");
        }
        else if(status == -1)
        {
            System.out.println("Connection failed ");
        }
        else if (status == -2)
        {
            System.out.println("Wrong password ");
        }

        if(status == 0 || status == -2)
        {    
            System.out.println("");
            String nwNames = MessageHelper.getNextNullTerString(buffer, data, 1);            
            System.out.println(nwNames);
            int nextPointer = 1 + (nwNames.length() + 1); 
            nwNames = MessageHelper.getNextNullTerString(buffer, data, nextPointer);
            
            System.out.println(nwNames);
        }


    }
    public int getSenderID()
    {
        return senderID;
    }
    
    public static void main(String[] args)
    {
        try
        {
            new SSIDAndPasswordRequest().retrieveDetails(null);
        }
        catch (UnsupportedEncodingException ex)
        {
            Logger.getLogger(SSIDAndPasswordRequest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
