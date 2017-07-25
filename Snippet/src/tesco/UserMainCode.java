/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tesco;

/**
 *
 * @author soorajpottekat
 */
class UserMainCode
{
        
	public int SearchLetter(String input1,String input2){
            // Read only region end
            int distance = 0;
            int firstPos = -1;
            int count = 0;
            // Safely assuming we are searching for a letter not a sequence of String;
            int key = input2.charAt(0);
            for (int i = 0; i < input1.length(); i++)
            {
                if(input1.charAt(i) == key)
                {
                    if(firstPos == -1)
                    {
                        firstPos = i;
                        count=0;
                    }
                    else
                    {
                        distance = distance + count;
                        count = 0;
                    }
                }
                else if(input1.charAt(i) != " ".charAt(0))
                {
                    count++;
                }
                
            }
            return distance;
           
	}
       
        public static void main(String[] args)
        {
            System.out.println(System.getProperty("os.arch"));
            System.out.println(new UserMainCode().SearchLetter("my naame is garanara", "a"));
           
        }
}