class MaxMin{

	public static void main(String args[]){
		long start = System.nanoTime();
		int numbers[] = new int[1000];
		int max = -1 ,min = 101;
		for(int i = 0; i< numbers.length ; i++){
			numbers[i] = (int) (Math.floor(Math.random() * 100));
			if(numbers[i] < min) 
				min = numbers[i];
			if(numbers[i] > max) 
				max = numbers[i];
		}
		long end = System.nanoTime();
		System.out.println("Min Number is : " + min);
		System.out.println("Max Number is :  " + max);
		System.out.println("Time Diffeerence is : " + (end - start));
	}

}