
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


/**
 * Created by soorajpottekat on 2017/01/25.
 *
 * @author Sooraj Pottekat
 */
public class SetIPParamResponse
{

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

    public void retrieveDetails(byte[] data)
    {

        data = new byte[]
        {
            0, 2, 2
        };
        String message = "192.168.250.203 \0 255.255.255.0 \0 192.168.250.100 \0 192.168.195.100 \0 192.168.194.100 \0 192.168.250.204 \0 255.255.255.0 \0 192.168.250.100 \0 192.168.195.100 \0 192.168.194.100 \0";
        data = MessageHelper.combine(data, message.getBytes());
        System.out.println("====> " + data);
        System.out.println("===>" + data.length);
        ByteBuffer buffer = ByteBuffer.wrap(data);
        status = buffer.get(0);
        if (status == 0)
        {
            System.out.println("Connection success ");
        }
        else if (status == -1)
        {
            System.out.println("Connection failed ");
        }
        else if (status == -2)
        {
            System.out.println("Wrong password ");
        }
        int type = buffer.get(1);
        switch (type)
        {
            case MessageHelper.IP_AUTO:
                System.out.println(" TYPE : == > IP_AUTO ");
                break;
            case MessageHelper.IP_DHCP:
                System.out.println(" TYPE : == > IP_DHCP ");
                break;
            case MessageHelper.IP_MANUAL:
                System.out.println(" TYPE : == > IP_MANUAL ");
                break;
            case MessageHelper.IP_ZERO_CONFIG:
                System.out.println(" TYPE : == > IP_ZERO_CONFIG ");
                break;
        }
        int num_interfaces = buffer.get(2);
        int startPointer = 3;
        int currentPointer = 3;
        System.out.println("num_interfaces" + num_interfaces);
        for (int i = 0; i < num_interfaces; i++)
        {

            String result = null;
            try
            {
                result = MessageHelper.getNextNullTerString(buffer, data, currentPointer);
                System.out.println("1." + result + "  " + currentPointer);
                currentPointer = currentPointer + result.length() + 1;
                result = MessageHelper.getNextNullTerString(buffer, data, currentPointer);
                System.out.println("2." + result + "  " + currentPointer);
                currentPointer = currentPointer + result.length() + 1;
                result = MessageHelper.getNextNullTerString(buffer, data, currentPointer);
                System.out.println("3." + result + "  " + currentPointer);
                currentPointer = currentPointer + result.length() + 1;
                result = MessageHelper.getNextNullTerString(buffer, data, currentPointer);
                System.out.println("4." + result + "  " + currentPointer);
                currentPointer = currentPointer + result.length() + 1;
                result = MessageHelper.getNextNullTerString(buffer, data, currentPointer);
                System.out.println("5." + result + "  " + currentPointer);
                currentPointer = currentPointer + result.length() + 1;
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
        new SetIPParamResponse().retrieveDetails(null);
    }

}
