import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*
class IpSplit{
	public static void main(String args[])
	{
		if (args.length>0){
			for(int i=0 ; i<args.length ;i++)
			{
				String str = args[i]; 
				Pattern pattern = Pattern.compile("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}");
				Matcher matcher = pattern.matcher(str.trim());
				if (matcher.matches()){
					String ip_splited[] = str.trim().split("\\.");
					int counter =0;
					for(String x: ip_splited)
					{
						int parsed=Integer.parseInt(x);
						if(parsed>=0 && parsed<255)
							counter++;
					}
					if (counter==4){
						for (String x : ip_splited)
							System.out.println(x);
					}
					else{
						System.out.println("Enter a Valid ipv4");
					}
				}else
					System.out.println("Enter a Valid IP");
	 
			}
		}
		else
			System.out.println("You Must Enter at least one IP to Split");
	}
}*/
class IpSplit{
	public static void main(String args[])
	{
		if (args.length>0){
			for(int i=0 ; i<args.length ;i++)
			{
				String str = args[i]; 
				String value = "(\\d{1,2}|(0|1)\\d{2}|2[0-4]\\d|25[0-5])";
				Pattern pattern = Pattern.compile(value + "\\." + value + "\\." + value + "\\." + value);
				Matcher matcher = pattern.matcher(str.trim());
				if (matcher.matches()){
					String ip_splited[] = str.trim().split("\\.");
					for (String x : ip_splited)
						System.out.println(x);
				}else{
					System.out.println("Enter a Valid IP");
				}
			}
		}
		else
			System.out.println("You Must Enter at least one IP to Split");
	}
}