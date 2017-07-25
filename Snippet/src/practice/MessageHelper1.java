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
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by soorajpottekat on 2017/01/24.
 *
 * @author Sooraj Pottekat
 */
public class MessageHelper1
{
    public static final char NULL_CHAR = '\0';
    public static final String EQUALS_STRING = "=";
    public static final String IP_DELIMITER = ".";
    public static final String APPEND_STRING = "000";

    private MessageHelper1()
    {
        
    }

    public static final byte[] combine(byte[] a, byte[] b)
    {
        int length = a.length + b.length;
        byte[] result = new byte[length];
        System.arraycopy(a, 0, result, 0, a.length);
        System.arraycopy(b, 0, result, a.length, b.length);
        return result;
    }


    public static final String getNextNullTerString(ByteBuffer buffer, byte[] data, int currentPointer)
    {
        int start = currentPointer;
        int movingPointer = currentPointer;
        while (buffer.get(movingPointer) != NULL_CHAR)
        {
            movingPointer++;
        }
        return new String(Arrays.copyOfRange(data, start, movingPointer));
    }


    public static final byte[] getEmptyArray()
    {
        return new byte[] {};
    }

    public static String convertToOctet(String string)
    {
        StringBuffer buffer = new StringBuffer("");
        final StringTokenizer tokenizer = new StringTokenizer(string, IP_DELIMITER);
        while (tokenizer.hasMoreTokens())
        {
            final String str = APPEND_STRING + tokenizer.nextToken();
            buffer.append((str).substring(str.length() - 3, str.length()));
            if(tokenizer.hasMoreTokens())
            {
                buffer.append(IP_DELIMITER);
            } 
        }
        System.out.println("   ==== >>> " + buffer);
        return buffer.toString();
    }

    public static void main(String[] args)
    {
        convertToOctet("192.18.2.10");
    }
}

