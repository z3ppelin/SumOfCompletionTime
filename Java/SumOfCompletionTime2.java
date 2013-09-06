/**
 * Greedy algorithm for minimizing the weighted sum of completion times.
 * The ratio is calculated as weight divided by length. Is always optimal.
 *
 * @author      Bogdan Constantinescu <bog_con@yahoo.com>
 * @since       2013.09.06
 * @version     1.0
 * @link        GitHub   https://github.com/z3ppelin/SumOfCompletionTime
 * @licence     The MIT License (http://opensource.org/licenses/MIT); see LICENCE.txt
 */
import java.io.FileInputStream;
import java.util.*;

public class SumOfCompletionTime2 {

    public static class Job implements Comparable {

        public int length;
        public int weight;

        public Job(int length, int weight) {
            this.length = length;
            this.weight = weight;
        }
        
        
        public int compareTo(Object obj) {
            if (!(obj instanceof Job)) {
                throw new ClassCastException("A Job object expected.");
            }
            
            Job j = (Job) obj;
            if (this.weight * j.length < j.weight * this.length) { // w1/len1 < w2/len2 <=> w1*len2 < w2.len1 
                return 1;
            } else if (this.weight * j.length == j.weight * this.length) {
                if (this.weight < j.weight) {
                    return 1;
                } else if (this.weight == j.weight) {
                    return 0;
                } else {
                    return -1;
                }
            } else {
                return -1;
            }
        }
    }

    /**
     * Main function.
     *
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        System.out.println("------ Begin Greedy Minimizing The Weighted Sum Of Completion Times ------");
        Job[] jobs = null;
        long start, end;
        long sum = 0, completionSum = 0;

        /* read jobs, sorts them and calculate the result */
        start = System.currentTimeMillis();
        try {
            if (args.length == 0) {
                throw new Exception("The input file must be given as an argument.");
            }
            jobs = readJobsFromFile(args[0]);
        } catch (Exception ex) {
            System.out.println("ERR. " + ex.getMessage());
            System.out.println("------- End Greedy Minimizing The Weighted Sum Of Completion Times -------");
            System.exit(-1);
        }
        Arrays.sort(jobs);
        for (int i = 0; i < jobs.length; i++) {
            sum += jobs[i].length;
            completionSum += jobs[i].weight * sum;
        }
        end = System.currentTimeMillis();

        /* print result */
        System.out.println("The weighted sum of completion times = " + completionSum);

        System.out.println("Elapsed: " + ((double) (end - start) / 100) + " seconds with sum calculation.");
        System.out.println("------- End Greedy Minimizing The Weighted Sum Of Completion Times -------");
    }

    /**
     * Reads array of jobs from file.
     *
     * @param   file  The file where to read array from.
     * @return        The read vector.
     * @throws Exception
     */
    public static Job[] readJobsFromFile(String file) throws Exception {
        Scanner sc;
        FileInputStream fis = null;
        int n, weight, length, j;
        Job[] v;
        Job job;
        try {
            fis = new FileInputStream(file);
            sc = new Scanner(fis);
            if (sc.hasNextInt()) {
                n = sc.nextInt();
            } else {
                throw new Exception("Could not read the number of elements vector has.");
            }
            v = new Job[n];
            for (int i = 0; i < n; i++) {
                if (sc.hasNextInt()) {
                    weight = sc.nextInt();
                } else {
                    throw new Exception("Could not read weight for job " + (i + 1));
                }
                if (sc.hasNextInt()) {
                    length = sc.nextInt();
                } else {
                    throw new Exception("Could not read length for job " + (i + 1));
                }
                job = new Job(length, weight);
                v[i] = job;
            }
            fis.close();
        } catch (Exception ex) {
            if (fis != null) {
                try {
                    fis.close();
                } catch (Exception e) {
                }
            }
            throw ex;
        }
        return v;
    }
}
