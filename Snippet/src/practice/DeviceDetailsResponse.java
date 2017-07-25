/**
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
import java.util.HashMap;

/**
 * Created by soorajpottekat on 2017/01/25.
 *
 * @author Sooraj Pottekat
 */
public class DeviceDetailsResponse
{
    private int messageType;
    private int senderID;
    private int status;
    private HashMap<String,String> deviceDetails = new HashMap<String, String>();
    private int device;
  
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

        data = new byte[]{0,2,5};
        String message = "speed\0 100\0 name\0 Explora:USB-Wifi\0 mac_address\0 0a:0b:0c:0d:0e:0f\0 id\0 10810\0 model_num\0 12a72bf\0 serial_num\0 00000001\0";
        data = MessageHelper.combine(data,message.getBytes());
        System.out.println("====> " + data);
        System.out.println("===>" + data.length);
        ByteBuffer buffer = ByteBuffer.wrap(data);
        status = buffer.get(0);
        if(status == 0)
        {
            System.out.println("Request Success");
        }

        int mode = buffer.get(1);
        switch (mode)
        {
            case MessageHelper.IP_UNDEFINED:
                System.out.println(" TYPE : == > IP_UNDEFINED ");
                break;
            case MessageHelper.IP_ONBOARD_ETHERNET:
                System.out.println(" TYPE : == > IP_ONBOARD_ETHERNET ");
                break;
            case MessageHelper.IP_USB_WIFI:
                System.out.println(" TYPE : == > IP_USB_WIFI ");
                break;
            case MessageHelper.IP_USB_ETHERNET:
                System.out.println(" TYPE : == > IP_USB_ETHERNET ");
                break;
        }
        int num_interfaces = buffer.get(2);
        int startPointer = 3;
        int currentPointer  = 3;
        for (int i = 0; i < num_interfaces; i++)
        {

            String key;
            String value;
            try
            {
                key = MessageHelper.getNextNullTerString(buffer, data, currentPointer);
                System.out.println(key);
                currentPointer = currentPointer + key.length() + 1;
                value = MessageHelper.getNextNullTerString(buffer, data, currentPointer);
                System.out.println(value);
                currentPointer = currentPointer + value.length() + 1;
                deviceDetails.put(key.trim(),value.trim());

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
        new DeviceDetailsResponse().retrieveDetails(null);
    }

}

