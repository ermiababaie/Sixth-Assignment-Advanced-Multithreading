# pi and calculation formula
## what is pi? :pie:
![57581t1](https://github.com/ermiababaie/Sixth-Assignment-Advanced-Multithreading/assets/160699260/c3284b74-c594-43cf-9b47-f798e9633e04)

#### the number π is a mathematical constant that is the ratio of a circle's circumference to its diameter, approximately equal to 3.14159. The number π appears in many formulae across mathematics and physics. It is an irrational number, meaning that it cannot be expressed exactly as a ratio of two integers, although fractions such as 22/7 are commonly used to approximate it. 

## Approximate value and digits : :black_nib:
![pidayImageWeb2](https://github.com/ermiababaie/Sixth-Assignment-Advanced-Multithreading/assets/160699260/fdb7ce99-c06b-4575-a0d7-5f50bca64972)

#### Fractions: Approximate fractions include (in order of increasing accuracy) 22/7, 333/106, 355/113, 52163/16604, 103993/33102, 104348/33215, and 245850922/78256779
#### Digits: The first 50 decimal digits are 3.14159265358979323846264338327950288419716939937510

## how to calculate pi? :memo:

### Buffon's needle problem : :game_die:
 in probability theory, Buffon's needle problem is a question first posed in the 18th century by Georges-Louis Leclerc, Comte de Buffon. The answer to this problem can be used as an approximate solution to obtain the pi number.
#### pros and cons: This formula is not easily simulated by the computer and is not suitable for calculating the pi number
#### learn more: https://en.wikipedia.org/wiki/Buffon%27s_needle_problem

### Leibniz formula : :book:
    π/4 = 1 - 1/3 + 1/5 - 1/7 +...
#### pros and cons: This formula is easy to implement to calculate pi, but it is very slow
#### learn more: https://en.wikipedia.org/wiki/Leibniz_formula_for_π 

### Nilakantha's formula : :open_book:
    (π-3)/4 = 1/2*3*4 - 1/4*5*6 + 1/6*7*8 - ...
#### pros and cons: This formula is easy to implement to calculate pi, But for the number of digits more than a thousand, it requires a lot of calculations and It has low accuracy

#### learn more: http://www.maeckes.nl/Formule%20voor%20pi%20%28Nilakantha%29%20GB.html

### Chudnovsky algorithm : :open_book:
##### The Chudnovsky algorithm is a fast method for calculating the digits of π, based on Ramanujan's π formulae. Published by the Chudnovsky brothers in 1988, it was used to calculate π to a billion decimal places.
##### It was used in the world record calculations of 2.7 trillion digits of π in December 2009, 10 trillion digits in October 2011, 22.4 trillion digits in November 2016, 31.4 trillion digits in September 2018–January 2019, 50 trillion digits on January 29, 2020,[8] 62.8 trillion digits on August 14, 2021, 100 trillion digits on March 21, 2022, and 105 trillion digits on March 14, 2024
#### learn more: https://en.wikipedia.org/wiki/Chudnovsky_algorithm

### my favorite formula : :sparkles:
<img width="245" alt="Screenshot 2024-05-19 at 6 40 59 PM" src="https://github.com/ermiababaie/Sixth-Assignment-Advanced-Multithreading/assets/160699260/4ce539d4-3149-436a-952e-1d259648b3e2">

#### pros and cons: This algorithm is very easy to implement and is very fast and highly accurate. This algorithm has the ability to be implemented with Multithreading

#### learn more: http://ajennings.net/blog/a-million-digits-of-pi-in-9-lines-of-javascript.html


## how to choose an algorithm for this problem? :computer:
#### In choosing the algorithm to solve the problem, we must pay attention to the following:
1. time complexity :stopwatch:
2. space complexity :space_invader:
3. Difficulty of implementation :weight_lifting:
4. Output accuracy :dart:
#### The difference between the stated algorithms is the number of operations required to find a specific number of digits of the pi number. Chudnovsky is the best in this case But it has very large constant numbers And that's why I chose to use another algorithm
#### In my algorithm, it is easier to calculate pi with fewer digits and it has the same time complexity as Chudnovsky(for small numbers)

## Code explanation: 🗒️
### I have used BigDecimal to calculate the results of large operations and divide the interval required to calculate pi into intervals of thousands of numbers and assign each one to a thread.

## Bugs fixing: :wrench:
#### threadPool: In ThreadPool, it is important that all threads finish and do not interfere with each other. For this matter, it is enough to use these: awaitTermination and Synchronization
#### wrong answer: For this problem, I increased the length of the series interval
#### https://stackoverflow.com/questions/1250643/how-to-wait-for-all-threads-to-finish-using-executorservice
#### https://www.geeksforgeeks.org/synchronization-in-java/
