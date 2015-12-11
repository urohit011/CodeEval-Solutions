import java.io.*;
import java.util.*;

class RomanNumerals
{
	public static void main(String[] args)throws Exception
	{
		File file = new File(args[0]);
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line;
		
		while((line = br.readLine()) != null)
		{
			new RomanNumerals().storeAndCalculate(Integer.parseInt(line), line.length());
		}
	}
	
	public void storeAndCalculate(int num, int size)
	{
		int[] list = new int[size];
		int index = 0;
		StringBuffer[] symbols = {new StringBuffer("I"), new StringBuffer("X"), new StringBuffer("C"), new StringBuffer("M")};
		StringBuffer ans = new StringBuffer("");
		
		HashMap<Integer, String> exceptions = new HashMap<>();
		
		exceptions.put(9, "IX");
		exceptions.put(90, "XC");
		exceptions.put(900, "CM");
		exceptions.put(4, "IV");
		exceptions.put(40, "XL");
		exceptions.put(400, "CD");
		exceptions.put(5, "V");
		exceptions.put(50, "L");
		exceptions.put(500, "D");
		
		while(num > 0)
		{
			list[index] = num%10;
			num /= 10;
			index++;
		}
		
		for(int i = 0; i < size; i++)
		{
			StringBuffer temp = new StringBuffer("");
			
			if(list[i] == 4 || list[i] == 9 || list[i] == 5)
			{
				int multiplier = (i == 0) ? 1 : 10;
				for(int j = 0; j < i-1; j++)
				{
					multiplier *= multiplier;
				}
				 
				temp = new StringBuffer(exceptions.get(list[i]*multiplier) + temp);
			}
			
			else
			{
				for(int p = 0; p < list[i] / 5; p++)
				{
					int val = (i == 0) ? 5: (i == 1) ? 50 : (i == 2) ? 500 : 0;
					temp = new StringBuffer( exceptions.get(val) + temp);
				}
				
				for(int q = 0; q < list[i] % 5; q++)
				{
						temp = new StringBuffer("" + temp + symbols[i]);	
				}
			}
			ans = new StringBuffer(temp + "" + ans);
		}
		
		System.out.println(ans);
	}
}
