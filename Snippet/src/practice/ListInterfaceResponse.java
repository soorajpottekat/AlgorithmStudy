package com.mca.mwapi.messaging.networkMessages;/*
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



import java.nio.ByteBuffer;

/**
 * Created by soorajpottekat on 2017/01/24.
 *
 * @author Sooraj Pottekat
 */
public class ListInterfaceResponse 
{
    int messageType;
    int senderID;
    int status;
    boolean wifiAvailable;    
    boolean ethernetAvailable;
    boolean usbEthernetAvailable;
    int numberOfUsbEthernet;
    
    
    public static final int IP_UNDEFINED = 0;
    public static final int IP_ONBOARD_ETHERNET = 1;
    public static final int IP_USB_WIFI = 2;
    public static final int IP_USB_ETHERNET = 3;
    public static final int MAX_DEVICES = 4;
    
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
        data = new byte[]{0, 2, 1, 0, 0};        
        
        System.out.println("====> " + data);
        ByteBuffer buffer = ByteBuffer.wrap(data);
        status = buffer.get(0);
        for (int i = 1; i <= MAX_DEVICES; i++)
        {
        byte interfaceName =  buffer.get(i);
        System.out.println(" == >" + interfaceName);
         
        switch (interfaceName)
        {
            case IP_UNDEFINED:
                System.out.println("Undefined");
                break;
            case IP_ONBOARD_ETHERNET:
                System.out.println("IP_ONBOARD_ETHERNET");
                break;
            case IP_USB_WIFI:
                System.out.println("IP_USB_WIFI");
                break;
            case IP_USB_ETHERNET:
                System.out.println("IP_USB_ETHERNET");
                break;
        }
            
        }
        
    }
    public int getSenderID()
    {
        return senderID;
    }

    public boolean isWifiAvailable()
    {
        return wifiAvailable;
    }

    public boolean isEthernetAvailable()
    {
        return ethernetAvailable;
    }

    public boolean isUsbEthernetAvailable()
    {
        return usbEthernetAvailable;
    }

    public int getNumberOfUsbEthernet()
    {
        return numberOfUsbEthernet;
    }

    public static void main(String[] args)
    {
        new ListInterfaceResponse().retrieveDetails(null);
    }
}
