package com.lkk.jegith;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;

import com.lkk.jegith.pojo.Trader;
import com.lkk.jegith.pojo.Transaction;

/**
 * Hello world!
 *
 */
public class App 
{
	
	public static long parallelSum(long n) {
		return Stream.iterate(1L, i -> i + 1)
		.limit(n)
		.parallel()
		.reduce(0L, Long::sum);
		
	}
    public static void main( String[] args )
    {
    	
        System.out.println( "Hello World!" );
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");
        List<Transaction> transactions = Arrays.asList(
        new Transaction(brian, 2011, 300),
        new Transaction(raoul, 2012, 1000),
        new Transaction(raoul, 2011, 400),
        new Transaction(mario, 2012, 710),
        new Transaction(mario, 2012, 700),
        new Transaction(alan, 2012, 950)
        );
    }
}
