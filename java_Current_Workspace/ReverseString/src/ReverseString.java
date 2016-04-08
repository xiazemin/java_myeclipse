
public class ReverseString {
	/**
	 * 反转句子
	 * 
	 * @param sentence 原句子
	 * @return 反转后的句子
	 */
	public static void Reverse(char []b,int length)
	{
		//char []b=a.toCharArray();
		for (int i=0;i<length/2;i++)
		{
			char c=b[i];
			b[i]=b[length-1-i];
			b[length-1-i]=c;

		}
		//return new String(b);
	}	
	public static String reverse(String sentence)
	{		
			
			char []abc=sentence.toCharArray();
			Reverse(abc,sentence.length());
			//System.out.println(abc);
			int j=0;
			for (int i=0;i<sentence.length();i++)
			{  
				if(i==sentence.length()-1)
				{
						char []b=new char[128];
						for(int s=0;s<=j;s++)
						{
							b[s]=abc[i-j+s];
						}
						//sentence.getChars(i-j,j, b, 0);
						//System.out.println(b);
						Reverse(b,j+1);
					//	System.out.println(b);
						//System.out.println(j);
						for(int s=0;s<=j;s++)
						{
							abc[i-j+s]=b[s];
						}
						j=0;
						
				}
				else
				{
					if (abc[i]!=' ')
					{
						j++;
					} 
					else
					{
						char []b=new char[128];
						for(int s=0;s<=j;s++)
						{
							b[s]=abc[i-j+s];
						}
						//sentence.getChars(i-j,j, b, 0);
						//System.out.println(b);
						Reverse(b,j);
						//System.out.println(b);
						//System.out.println(j);
						for(int s=0;s<=j;s++)
						{
							abc[i-j+s]=b[s];
						}
						j=0;
					}
				}
				
			}
			//System.out.println(abc);
          String def=new String(abc);
         // System.out.println(abc+"   "+def);
		return def;
	}
	
	public static void main(String []arsg)		 
	{
		String s1=new String("hello World Everyone");
		String s=reverse(s1);
	    System.out.println(s1+"\n"+s);
	}
}
