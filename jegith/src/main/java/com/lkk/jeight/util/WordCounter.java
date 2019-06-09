package com.lkk.jeight.util;

public class WordCounter {
	private final int counter;
	private final boolean lastSpace;
	public WordCounter(int counter, boolean lastSpace) {
	this.counter = counter;
	this.lastSpace = lastSpace;
	}
	
	public WordCounter accumulate(Character c) {
		System.out.println("counter = "+counter);
		if(Character.isWhitespace(c)) {
			return lastSpace? this:new WordCounter(counter,true);
		}else {
			return lastSpace?new WordCounter(counter+1, false):this;
		}
	}
	
	public WordCounter combine(WordCounter wordCounter) {
		System.out.println("counter:"+counter+"   wordCounter.counter:"+wordCounter.counter);
		return new WordCounter(counter+wordCounter.counter,wordCounter.lastSpace);
	}
	
	public int getCounter() {
		return counter;
	}

}
