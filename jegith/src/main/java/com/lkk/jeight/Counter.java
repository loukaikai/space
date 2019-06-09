package com.lkk.jeight;

import java.util.Spliterator;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import com.lkk.jeight.util.WordCounter;
import com.lkk.jeight.util.WordCounterSpliterator;

public class Counter {
	public static void main(String[] args) {
		final String SENTENCE =
		" Nel mezzo del cammin di nostra vita " +
		"mi ritrovai in una selva oscura" +
		" ché la dritta via era smarrita ";
		
		/*ss.forEach(c ->{
			System.out.print(c);
		});*/
		
//		long a = ss.count();
//		System.out.println(a);
		
		Spliterator<Character> spliterator = new WordCounterSpliterator(SENTENCE);
		Stream<Character> ss = StreamSupport.stream(spliterator, true);
		
//		  ss = IntStream.range(0, SENTENCE.length())
//				.mapToObj(SENTENCE::charAt);
		
		WordCounter wordCounter = ss.parallel().reduce(new WordCounter(0, true),
				WordCounter::accumulate,
				WordCounter::combine);
		long b = wordCounter.getCounter();
		System.out.println(b);
								
				
	}
}
