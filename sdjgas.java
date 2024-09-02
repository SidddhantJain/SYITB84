import java.util.concurrent.*;
public class MatrixAddition {
// Size of Matrix
final static int MAX = 2;
// matrix A used for muliplication
static int[][] matA = { { 3, 7 },
{ 9, 2 } };
// matrix B used for multiplication
static int[][] matB = { { 6, 5 },
{ 1, 7 } };
// matAdd to store results
static int[][] matAdd = new int[MAX][MAX];

// Function to print matrix in readable format
static void printMatrix(int[][] mat)
{
for (int i = 0; i &lt; MAX; i++) {
for (int j = 0; j &lt; MAX; j++) {
System.out.print(mat[i][j] + &quot; &quot;);
}
System.out.println();
}
System.out.println();
}

// Function to perform matrix Addition
static void add(int i)
{
// Each thread computes 1/4th of matrix addition
int start = i * (MAX / 2);
int end = (i + 1) * (MAX / 2);
for (int j = start; j &lt; end; j++) {
for (int k = 0; k &lt; MAX; k++) {
matAdd[j][k] = matA[j][k] + matB[j][k];
}
}
}
public static void main(String[] args)
{
System.out.println(&quot;Matrix A:&quot;);
printMatrix(matA);
System.out.println(&quot;Matrix B:&quot;);
printMatrix(matB);
// Creating MAX_THEAD number of threads
ExecutorService executor
= Executors.newFixedThreadPool(4);
for (int i = 0; i &lt; 2; i++) {
int finalI = i;
executor.submit(() -&gt; {
add(finalI);
});
}

// Waiting for all threads to finish

executor.shutdown();
while (!executor.isTerminated()) {
// wait for all threads to complete
}
// Printing the resultant matrices
System.out.println(&quot;Sum of Matrix A and B:&quot;);
printMatrix(matAdd);
}
}