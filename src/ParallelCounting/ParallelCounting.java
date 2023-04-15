import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ParallelCounting {
	/**
	 * Return the number of values equal to v using a parallel algorithm.
	 *
	 * @param values an array of numbers
	 * @param v the value that you want to count
	 * @param nThreads is a value between 1 and values.length
	 * @return the number of elements equal to v in values (or 0 if no values are provided)
	 *
	 * Example: For
	 *     values = [4.5f,3.2f,5.0f,6.6f,7.2f,1.5f,3.7f,5.8f,6.0f,9.0f,1.3f,2.3f,4.5f,1.5f]
	 * and
	 *     v = 4.5
	 * the method returns 2 because the value 4.5 appears two times in the array.
	 *
	 * Try to give all threads more or less the same amount of work!
	 */
	public static int parallelCount (Optional<float[]> values, float v, int nThreads) {
		int[] occurence = new int[nThreads];
		if(values.isPresent()){
			ArrayList<Float> lst = new ArrayList<>();
			for(float i : values.get()){
				lst.add(i);
			}
			Thread[] threadsList = new Thread[nThreads];
			int step = lst.size()/nThreads;
			System.out.println(step);
			if(step==1){
				return simpleCounter(lst,v);
			}
			for (int i = 0; i < nThreads; i++) {
				int start = i*step;
				int stop = (i+1)*step;
				if(i+1==nThreads){
					stop = lst.size();
				}
				int finalStop = stop;
				int finalI = i;
				threadsList[i] = new Thread(() -> occurence[finalI] = simpleCounter(lst.subList(start, finalStop), v));
				threadsList[i].start();
			}
			for (Thread t : threadsList){
				try {
					t.join();
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
			}
			return Arrays.stream(occurence).sum();
		}
		return 0;
	}

	protected static int simpleCounter(List<Float> values, float v){
		int counter = 0;
		for(float i : values){
			if(i==v){
				counter++;
			}
		}
		return counter;
	}
}