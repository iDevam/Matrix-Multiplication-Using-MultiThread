import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MatrixMultiplication {
	static MatrixBuilder m = new MatrixBuilder();
	static MatrixBuilder n = new MatrixBuilder();
	static MatrixBuilder c = new MatrixBuilder();

	public static void main(String[] args) throws InterruptedException {

		// creating m x m matrices for the test

		m.makeMatrix();
		n.makeMatrix();

		// process with using MultiThread

		// multiplication process using many Threads with using Executors.
		long start = System.currentTimeMillis();
		ExecutorService executor = Executors.newCachedThreadPool();
		for (int x = 0; x < m.getSize(); x++)
			for (int y = 0; y < n.getSize(); y++) {
				final int row = x, col = y;
				executor.submit(() -> multiply(row, col));
			}
		
		executor.shutdown();
		long end = System.currentTimeMillis();
		//executor.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);

		System.out.println("multiplying " +m.getSize()+"X"+n.getSize() + " matrices... the time takes with MultiThread: " + (end - start) + " milliseconds");
		// c.print();

		// process without using MultiThread

		long start1 = System.currentTimeMillis();
		for (int x = 0; x < m.getSize(); x++) {
			for (int y = 0; y < n.getSize(); y++) {
				final int row = x, col = y;
				multiply(row, col);
			}
		}

		long end1 = System.currentTimeMillis();
		System.out.println("multiplying " +m.getSize()+"X"+n.getSize() +" matrices... the time takes without MultiThreading " + (end1 - start1) + " milliseconds");
		// c.print();

	}

	public static void multiply(int row, int col) {
		int sum = 0;
		for (int r = 0; r < m.getSize(); r++)
			sum += n.getMatrix()[r][col] * m.getMatrix()[r][col];
		c.getMatrix()[row][col] = sum;

	}
}