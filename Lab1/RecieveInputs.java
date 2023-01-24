class RecieveInputs{
	public static void main(String args[]){
		if(args.length<1)
			System.out.println("No Arguments Found");
		else
		{
			for(int i=0;i<args.length;i++)
				System.out.println(args[i]);
		}
	}
}