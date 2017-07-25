
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
;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.HashMap;

/**
 * Created by soorajpottekat on 2017/01/25.
 *
 * @author Sooraj Pottekat
 */
public class ListSSIDResponse
{
    private int messageType;
    private int senderID;
    private int status;
    //private SSIDItem[] ssids;
    
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

    public void retrieveDetails(byte[] data)
    {

        data = new byte[]{0,5};
        String message = "networkOne\0";
        data = MessageHelper.combine(data,message.getBytes());
        data = MessageHelper.combine(data,new byte[]{63});
        message = "networkTwo\0";
        data = MessageHelper.combine(data,message.getBytes());
        data = MessageHelper.combine(data,new byte[]{100});
        message = "networkThree\0";
        data = MessageHelper.combine(data,message.getBytes());
        data = MessageHelper.combine(data,new byte[]{19});
        message = "networkFour\0";
        data = MessageHelper.combine(data,message.getBytes());
        data = MessageHelper.combine(data,new byte[]{32});
        message = "networkFive\0";
        data = MessageHelper.combine(data,message.getBytes());
        data = MessageHelper.combine(data,new byte[]{1});
        System.out.println("====> " + data);
        System.out.println("===>" + data.length);
        ByteBuffer buffer = ByteBuffer.wrap(data);
        status = buffer.get(0);
        if(status == 0)
        {
            System.out.println("Request Success");
        }
        int num_interfaces = buffer.get(1);
        //ssids = new SSIDItem[num_interfaces];
        int startPointer = 2;
        int currentPointer  = 2;
        for (int i = 0; i < num_interfaces; i++)
        {
            try
            {
                String ssid = MessageHelper.getNextNullTerString(buffer, data, currentPointer);
                currentPointer = currentPointer + ssid.length() + 1;
                int strength = buffer.get(currentPointer);
                currentPointer++;
                System.out.println("SSID ==> " + ssid + "Strength == > " + strength);
                //ssids[i] = new SSIDItem(ssid, strength);
            }
            catch (UnsupportedEncodingException e)
            {
                e.printStackTrace();
            }

        }


    }
    public int getSenderID()
    {
        return senderID;
    }
    
    public static void main(String[] args)
    {
        new ListSSIDResponse().retrieveDetails(null);
    }

}
