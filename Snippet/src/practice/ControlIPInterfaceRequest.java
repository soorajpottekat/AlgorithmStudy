
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



/**
 * Created by soorajpottekat on 2017/01/24.
 *
 * @author Sooraj Pottekat
 */
public class ControlIPInterfaceRequest 
{
    
    private byte[] enableList;
    private byte[] disableList;

    public byte[] packMessage()
    {
        int listSize = enableList == null ? 0 : enableList.length;
        if(listSize == 0)
        {
            enableList = new byte[]{};
        }
        int enableFillerSize = 4 - listSize;
        if(enableFillerSize > 0)
        {
            byte[] filler = new byte[enableFillerSize];
            enableList = MessageHelper.combine(enableList,filler);
        }
        listSize = disableList == null ? 0 : disableList.length;
        if(listSize == 0)
        {
            disableList = new byte[]{};
        }
        int disableFillerSize = 4 - listSize;
        if(disableFillerSize > 0)
        {
            byte[] filler = new byte[disableFillerSize];
            disableList = MessageHelper.combine(disableList,filler);
        }     
        return MessageHelper.combine(enableList,disableList);
    }

    public void setEnableList(byte[] enableList)
    {
        this.enableList = enableList;
    }
    public void setDisableList(byte[] disableList)
    {
        this.disableList = disableList;
    }
    
    public static void main(String[] args)
    {
        ControlIPInterfaceRequest req = new ControlIPInterfaceRequest();
        req.setDisableList(new byte[]{1,2,3});
        byte[] data = req.packMessage();
        for (byte i : data)
        {
            System.out.print(" " + i );
        }
        
    }
}
