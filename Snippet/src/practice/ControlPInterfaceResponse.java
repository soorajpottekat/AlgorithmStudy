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



import java.nio.ByteBuffer;

/**
 * Created by soorajpottekat on 2017/01/24.
 *
 * @author Sooraj Pottekat
 */
public class ControlPInterfaceResponse
{
    private int messageType;
    private int senderID;
    private int status;
    private boolean wifiAvailable;
    private boolean ethernetAvailable;
    private boolean usbEthernetAvailable;

   
    public int getMessageType()
    {
        return 0;
    }

  
    public int getSenderId()
    {
        return 0;
    }

    public int getStatus()
    {
        return status;
    }

    public void retrieveDetails(byte[] data)
    {
        data = new byte[]{0, 2, 0, 0, 0, 1, 0, 0, 0};
        ByteBuffer buffer = ByteBuffer.wrap(data);
        status = buffer.get(0);
        for (int i = 1; i <= MessageHelper.MAX_DEVICES; i++)
        {
            byte nwInteface = buffer.get(i);
            switch (nwInteface)
            {
                case MessageHelper.IP_UNDEFINED:
                    System.out.println("Undefined");
                    break;
                case MessageHelper.IP_ONBOARD_ETHERNET:
                    System.out.println("Enable : IP_ONBOARD_ETHERNET");
                    ethernetAvailable = true;
                    break;
                case MessageHelper.IP_USB_WIFI:
                    System.out.println("Enable : IP_USB_WIFI");
                    wifiAvailable = true;
                    break;
                case MessageHelper.IP_USB_ETHERNET:
                    usbEthernetAvailable = true;
                    System.out.println("Enable : IP_USB_ETHERNET");
                    break;
            }
        }
        int disableListStart = 1 + MessageHelper.MAX_DEVICES;
        int disableListEnd = disableListStart + MessageHelper.MAX_DEVICES;

        for (int i = disableListStart; i < disableListEnd; i++)
        {
            byte nwInteface = buffer.get(i);
            switch (nwInteface)
            {
                case MessageHelper.IP_UNDEFINED:
                    System.out.println("Undefined");
                    break;
                case MessageHelper.IP_ONBOARD_ETHERNET:
                    System.out.println("Disable : IP_ONBOARD_ETHERNET");
                    ethernetAvailable = false;
                    break;
                case MessageHelper.IP_USB_WIFI:
                    System.out.println("Disable : IP_USB_WIFI");
                    wifiAvailable = false;
                    break;
                case MessageHelper.IP_USB_ETHERNET:
                    usbEthernetAvailable = false;
                    System.out.println("Disable : IP_USB_ETHERNET");
                    break;
            }
        }


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
    
    public static void main(String[] args)
    {
        new ControlPInterfaceResponse().retrieveDetails(null);
    }


}
