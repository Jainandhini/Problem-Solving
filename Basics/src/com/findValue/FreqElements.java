package com.findValue;

import java.util.HashMap;
import java.util.Stack;

public class FreqElements {
	
	int[] numbers={1,2,1,1,3,4,2,3};
	HashMap<Integer,Integer> freq=new HashMap<Integer,Integer>();
	HashMap<Integer,Stack<Integer>> bucket=new HashMap<Integer,Stack<Integer>>();
	
	public void calcFreq(int[] numbers){
		for(int i:numbers){
			if(freq.containsKey(i)){
				freq.put(i, freq.get(i)+1);
			}
			else{
				freq.put(i,1);
			}
		}
		/*for(int j : freq.keySet()){
			System.out.println("key: "+j+"freq: "+freq.get(j));
		}*/
	}
	
	public void assignBuckets(HashMap<Integer,Integer> numSet){
		initBucket(numSet);
		int bin=0;
		Stack<Integer> temp=new Stack<Integer>();
		
		for (Integer i : numSet.keySet()){
			bin=numSet.get(i);
				temp=bucket.get(bin);
				//System.out.println("before key: "+i+" value: "+bin+ "stack: "+temp);
				if(temp==null)
					temp=new Stack<Integer>();
				temp.push(i);
				//System.out.println("after key: "+i+" value: "+bin+ "stack: "+temp);
			bucket.put(bin,temp);
				temp=null;			
		}
	}
	void printKtop(int k){
		int count=0;
		int bin=bucket.size()-1;
		while(count<k && bin>=0){
			Stack<Integer> elements= bucket.get(bin);
			
				while(elements!=null && elements.size()>0){
					System.out.println(elements.pop()+" occurs "+(bin+1)+" times");
					count++;
				}
				
				
			bin--;
			
		}
	}
	private void initBucket(HashMap<Integer, Integer> numSet) {
		// TODO Auto-generated method stub
		for(int i=0;i<numbers.length;i++){
			bucket.put(i, null);
		}
		/*System.out.println("initBuckets: ");
		for(int i:bucket.keySet())
			System.out.println(bucket.get(i));*/
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FreqElements fe=new FreqElements();
		fe.calcFreq(fe.numbers);
		fe.assignBuckets(fe.freq);
		fe.printKtop(2);
	}
	

}
