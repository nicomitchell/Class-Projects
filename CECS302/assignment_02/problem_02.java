/*******************
 * Nicolas Mitchell
 * CECS 302
 * Assignment 02
 * Problem 02
 ******************/



import java.time.Instant;
import java.time.temporal.Temporal;
import java.time.temporal.ChronoUnit;
import java.time.LocalDateTime;
import java.util.Scanner;

public class problem_02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("N?\n");
        long n = scan.nextInt();
        LocalDateTime start = LocalDateTime.now();        
        Sums s = new Sums();
        long sum = s.sum_a(n);
        LocalDateTime end = LocalDateTime.now();
        long elapsed = ChronoUnit.MILLIS.between(start,end);
        System.out.println("N = " + n + "\tTime Elapsed: " + elapsed + "ms\n");
    }
    
}

class Sums {
    long sum_a(long n) {
        long sum = 0;
        for(int i=0; i < n; ++i) {
            ++sum;
        }
        return sum;
    }
    long sum_b(long n) {
        long sum = 0; 
        for( int i = 0; i < n; ++i ) {
            for( int j = 0; j < n; ++j ) { 
                ++sum;        
            }
        }
        return sum;
    }
    long sum_c(long n) {
        long sum = 0;
        for( int i = 0; i < n; ++i ) {
            for( int j = 0; j < n * n; ++j ) {
                ++sum;
            }
        }
        return sum;
    }
    long sum_d(long n) {
        long sum = 0;
        for( int i = 0; i < n; ++i ) {
            for( int j = 0; j < i; ++j ) {
                ++sum; 
            }
        }
        return sum;
    }
    long sum_e(long n) {
        long sum = 0;
        for( int i = 0; i < n; ++i ){
            for( int j = 0; j < i * i; ++j ) {
                for( int k = 0; k < j; ++k ) {
                    ++sum;
                }
            }
        }
        return sum;
    }
    long sum_f(long n) {
        long sum = 0; 
        for( int i = 1; i < n; ++i ){
            for( int j = 1; j < i * i; ++j ){
                if( j % i == 0 ){
                    for( int k = 0; k < j; ++k ){
                        ++sum;
                    }
                }
            }
        }
        return sum;
    }
}