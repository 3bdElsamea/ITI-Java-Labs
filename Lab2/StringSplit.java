import java.util.StringTokenizer;
class StringSplit {
	public static void main (String args[]){
		String sentence ="ITI stands for ITI information technology ITI institute";
		String seprator="ITI";
		//First Way 
		int counter = 0;
		int index = 0;
		while(sentence.indexOf(seprator,index)!= -1){
			index = sentence.indexOf(seprator,index)+1;
			counter += 1;
		}
		System.out.println("Number of Occurence for the Seperator : " + counter);
		
		//Second Way
		String splittedArr[] = sentence.split(" ");
		int ocurs = 0;
		for (String x:splittedArr)
		{
			if (seprator.equals(x))
				ocurs+=1;
		}
		System.out.println("Number of Occurence for the Seperator : " + ocurs);
		
		//Using String Tokenizer
		StringTokenizer tknz =new StringTokenizer(sentence);
		while(tknz.hasMoreTokens())
		{
			System.out.println(tknz.nextToken("ITI"));
		}
	}
	
}