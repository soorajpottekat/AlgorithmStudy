
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

/**
 * Created by soorajpottekat on 2017/01/24.
 *
 * @author Sooraj Pottekat
 */
public class MessageHelper
{
    public static final int IP_UNDEFINED = 0;
    public static final int IP_ONBOARD_ETHERNET = 1;
    public static final int IP_USB_WIFI = 2;
    public static final int IP_USB_ETHERNET = 3;
    public static final int MAX_DEVICES = 4;

    public static final int IP_AUTO=0;
    public static final int IP_MANUAL=1;
    public static final int IP_DHCP=2;
    public static final int IP_ZERO_CONFIG=3;

    public static final byte[] combine(byte[] a, byte[] b)
    {
        int length = a.length + b.length;
        byte[] result = new byte[length];
        System.arraycopy(a, 0, result, 0, a.length);
        System.arraycopy(b, 0, result, a.length, b.length);
        return result;
    }

    public static final byte[] convertCharArrToByteArr(char[] arr)
    {
        byte[] result = new byte[arr.length*2];
        ByteBuffer.wrap(result).asCharBuffer().put(arr);
        return result;
    }
    
    public static final String getNextNullTerString(ByteBuffer buffer, byte[] data, int currentPointer) throws UnsupportedEncodingException
    {
        int start = currentPointer;
        while (buffer.get(currentPointer) != '\0')
        {
            currentPointer++;
        }
        return new String(Arrays.copyOfRange(data, start, currentPointer));
    }


}
