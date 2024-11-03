import java.util.Scanner;
public class primeno {
    public static void main(String[] args) {
        Scanner scn =  new Scanner(System.in);
        System.out.print("enter a number ");
        int n = scn.nextInt();
        boolean isprime = true;

        if(n<=1){
            isprime = false;
      }else{
        for(int i = 2 ;i<=Math.sqrt(n); i++){//square root of n
            if(n% i ==0){
                isprime = false;
                break;
            }
        }

      }
      if(isprime){
        System.out.println( n +" is a prime number");
      }else{
        System.out.println(n + " is not a prime number");
      }
      scn.close();

    }
}
/*
 This program checks if a given number \( N \) is prime. Here’s a step-by-step dry run with an explanation of the logic.

### Logic of Prime Number Check
A **prime number** is a number greater than 1 that has no divisors other than 1 and itself. For instance, 2, 3, 5, and 7 are prime numbers. The code checks if \( N \) is prime by testing divisibility from 2 up to \( \sqrt{N} \). If any number in this range divides \( N \) evenly (with no remainder), \( N \) is not prime.

### Code Breakdown and Explanation

1. **Input**: The program starts by taking input from the user.
   ```java
   int N = scanner.nextInt();
   ```
   Here, \( N \) is the number the user enters to check for primality.

2. **Initial Check for Small Values**:
   ```java
   if (N <= 1) {
       isPrime = false;
   }
   ```
   - If \( N \leq 1 \), it is not prime. So `isPrime` is set to `false`, and the program will eventually output that \( N \) is not prime.

3. **Loop to Check Divisors**:
   ```java
   for (int i = 2; i <= Math.sqrt(N); i++) {
       if (N % i == 0) {
           isPrime = false;
           break;
       }
   }
   ```
   - The loop starts from \( i = 2 \) and goes up to \( \sqrt{N} \).
   - For each \( i \) in this range:
     - If \( N \% i == 0 \), \( N \) is divisible by \( i \), meaning \( N \) is not prime. So, `isPrime` is set to `false`, and the loop breaks to stop further checks.

   **Why \( \sqrt{N} \)?**
   - If \( N \) has any divisor greater than \( \sqrt{N} \), the corresponding divisor would already have been checked as a smaller divisor (since divisors come in pairs). This optimization reduces the loop iterations, making the code more efficient.

4. **Output the Result**:
   ```java
   if (isPrime) {
       System.out.println(N + " is a prime number.");
   } else {
       System.out.println(N + " is not a prime number.");
   }
   ```
   - After the loop, if `isPrime` is still `true`, \( N \) is a prime number, and the program outputs that. Otherwise, it outputs that \( N \) is not prime.

### Step-by-Step Dry Run
Let’s test the code with \( N = 29 \).

1. **User Input**: Suppose the user enters \( N = 29 \).
   - `isPrime` is initialized to `true`.

2. **Check for Small Values**:
   - Since \( 29 \) is greater than 1, we skip the condition `N <= 1`.

3. **Loop Execution**:
   - We loop from \( i = 2 \) up to \( \sqrt{29} \approx 5.39 \) (so \( i \) goes up to 5).
   - **Iteration 1**: \( i = 2 \)
     - \( 29 \% 2 \neq 0 \), so `isPrime` remains `true`.
   - **Iteration 2**: \( i = 3 \)
     - \( 29 \% 3 \neq 0 \), so `isPrime` remains `true`.
   - **Iteration 3**: \( i = 4 \)
     - \( 29 \% 4 \neq 0 \), so `isPrime` remains `true`.
   - **Iteration 4**: \( i = 5 \)
     - \( 29 \% 5 \neq 0 \), so `isPrime` remains `true`.
   - The loop completes without finding any divisors, so `isPrime` stays `true`.

4. **Result Output**:
   - Since `isPrime` is `true`, the program outputs:
     ```plaintext
     29 is a prime number.
     ```

### Summary
The program efficiently checks for primality by iterating only up to \( \sqrt{N} \), marking `isPrime` as `false` if a divisor is found. If no divisors are found, `isPrime` remains `true`, indicating that the number is prime. 
 
  
 */