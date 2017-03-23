
public class BubbleSort
{
	public static void main(String args[])
	{
		int a[]= {10,9,8,7,5};
		
		int i,j,temp;
		
		for(i=0;i<a.length-1;i++)
		{ 
			for (j=0;j<a.length-i-1;j++)
			{
				if (a[j]>a[j+1])
				{
					temp=a[j+1];
					a[j+1]=a[j];
					a[j]=temp;
				}
											
			}
		}
		
        for (i=0;i<a.length;i++)
        {
        	System.out.println(a[i]);
        }
		
		
		
	}

}
