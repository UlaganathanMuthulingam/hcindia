package idp.hcIndia.pages;

public class dummy {


	int a=300;
	static int b=100;
	
	void add()
	{
		a++;
		for(int i=0;i<=100;i++)
		{
			if(i%2==1)
			{
				System.out.println(i);
			}

		}
	}
	
	
	void  add1()
	{	
	int i=0;
	do
	{
		System.out.println(i);
		if(i==10)
		{
			System.out.println("PaSS");
		}
	
	}
	while(i<=100);
	}
	
	public static void main(String args[])
	{
		dummy d=new dummy();
		//d.add();
		d.add1();
			
	}
			
}
