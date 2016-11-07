package com.andro.future;

import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class HelloFuture {

   /* @Test
    public void test_accept_either_async_nested_finishes_first() throws Exception {

        CompletableFuture<String> callingCompletable = CompletableFuture.supplyAsync(simulatedTask(2, "calling"), service);
        CompletableFuture<String> nestedCompletable = CompletableFuture.supplyAsync(simulatedTask(1, "nested"), service);

        CompletableFuture<Void> collector = callingCompletable.acceptEither(nestedCompletable, results::add);

        pauseSeconds(2);
        assertThat(collector.isDone(), is(true));
        assertThat(results.size(), is(1));
        assertThat(results.contains("nested"), is(true));
    }*/

    public static void main(String[] args) {
        CompletableFuture completableFutureToBeCompleted2 = CompletableFuture.supplyAsync(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("i " + i);
            }
            return 10;
        });

        CompletableFuture completor = CompletableFuture.supplyAsync( ( ) -> {
            System.out.println( "completing the other" );
            completableFutureToBeCompleted2.complete( 222 );
            return 10;
        } );
        System.out.println( completor.getNow(200) );
       /* try {
            //System.out.println( completor.getNow(10) );
            //System.out.println( completableFutureToBeCompleted2.getNow() );
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }*/

    }
}
