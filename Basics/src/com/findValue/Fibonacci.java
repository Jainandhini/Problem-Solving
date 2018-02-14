package com.findValue;

public class Fibonacci {
	
	//Find the fibonacci no at index n
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fibonacci f=new Fibonacci();
		System.out.println("Recursive ans: "+f.fibonacci(10));
		System.out.println("\nIterative ans: "+f.fibonacciIterative(10));
	}
	
	int fibonacci(int n){
		
		if(n<=1){
			return n;
		}
		
		return (fibonacci(n-1)+fibonacci(n-2));
	}
	int fibonacciIterative(int n){
		int[] fibo= new int[n+1];
		fibo[0]=0;fibo[1]=1;
		for(int i=2;i<=n;i++){
			fibo[i]=fibo[i-1]+fibo[i-2];
		}
		for (Integer i:fibo)
			System.out.print(i+"\t");
		return fibo[n];
	}

}
