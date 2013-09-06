Greedy algorithm for minimizing the weighted sum of completion times
===================

About
------------
In this programming problem and the next you 'll code up the greedy algorithms for minimizing the weighted sum of completion times. 
The input file describes a set of jobs with positive and integral weights and lengths. 
It has the format  
[number_of_jobs]  
[job_1_weight] [job_1_length]  
[job_2_weight] [job_2_length]  
...  
You should NOT assume that edge weights or lengths are distinct.  

Question 1:  
Your task in this problem is to run the greedy algorithm that schedules jobs in 
decreasing order of the difference (weight - length). This algorithm is not always optimal.
IMPORTANT: if two jobs have equal difference (weight - length), you should schedule the job 
with higher weight first. 
Beware: if you break ties in a different way, you are likely to get the wrong answer.  

Question 2:
Your task now is to run the greedy algorithm that schedules jobs (optimally) 
in decreasing order of the ratio (weight/length). In this algorithm, it does not 
matter how you break ties. 

You should report the sum of weighted completion times of the resulting schedule  

Running code examples
------------
**C** implementation:

You should compile the source file first.

    cd C/
    gcc -o SumOfCompletionTime1 SumOfCompletionTime1.c (Linux)
    gcc -o SumOfCompletionTime2 SumOfCompletionTime2.c (Linux)
    ./SumOfCompletionTime1 ../in/inputBig.txt (Linux)
    ./SumOfCompletionTime2 ../in/inputBig.txt (Linux)
    
    compile with Visual Studio | MinGW | DevC++ (Windows)
    SumOfCompletionTime1.exe ../in/inputBig.txt (Windows)
    SumOfCompletionTime2.exe ../in/inputBig.txt (Windows)

**Java** implementation:

Used java 1.6.0_33 to compile source files.

    cd Java/
    java SumOfCompletionTime1 ../in/inputBig.txt (Windows & Linux)
    java SumOfCompletionTime2 ../in/inputBig.txt (Windows & Linux)

To compile yourself the source files:

    cd Java/
    javac SumOfCompletionTime1.java SumOfCompletionTime2.java (Windows & Linux)

For the input files in *in/* folder the expected results are:  
*SumOfCompletionTime1*  
 - *inputTiny.txt*: 20000
 - *inputSmall.txt*: 7226993
 - *inputMedium.txt*: 706524469
 - *inputBig.txt*: 69119377652  

*SumOfCompletionTime2*  
 - *inputTiny.txt*: 19400
 - *inputSmall.txt*: 7078040
 - *inputMedium.txt*: 688694325
 - *inputBig.txt*: 67311454237    

