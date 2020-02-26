# The $3x+1$ Problem

###

- Moritz Konarski
- Junior, Applied Mathematics Department, AUCA
- 27.02.2020

### Overview

- The $3x+1$ Problem and Collatz Conjecture
- What Makes This Problem Interesting?
- History of the Collatz Conjecture
- Interesting Attributes of the $3x+1$ Problem

### Interesting Attributes

- Cycles of the Function
- Stochastic Approximations
- Stopping Time of the Function

## What is the $3x+1$ Problem?

### The Function

- based on the Collatz function $^{[3]}$
$$C(x)= \left\{
    \begin{array}{ll}
        3x+1 \quad &\text{if } x \equiv 1 \text{ (mod 2),} \\
        x/2 \quad &\text{if } x \equiv 0 \text{ (mod 2).}
    \end{array}
\right.
$$
- equivalent to the $3x+1$ function $^{[3]}$
$$T(x)= \left\{
    \begin{array}{ll}
        (3x+1)/2 \quad &\text{if } x \equiv 1 \text{ (mod 2),} \\
        x/2 \quad &\text{if } x \equiv 0 \text{ (mod 2).}
    \end{array}
\right.
$$

### Details

- it is conjectured that for some $x,k \in \mathbb{N} + 1$ we attain $T^{(k)}(x)=1$ $^{[1]}$
- the $3x+1$ function $T(x)$ maps $\mathbb{N} + 1 \rightarrow \mathbb{N} + 1$ $^{[4]}$
- the function has a _stopping time_, _total stopping time_, and a _trajectory_ 
for each $m$

### Stopping Time for $x$

- check that every positive integer up to $x - 1$ iterates to one $^{[1]}$
- if $T^{(k)}(x) < x$, we know it will iterate to 1
- thus the stopping time is 
$$\sigma(x)=\inf\{k:T^{(k)}(x) < x\}$$ 

### Total Stopping Time for $x$

- total stopping time is the number of steps needed to iterate to 1 $^{[1]}$
$$\sigma_{\infty}(x)=\inf\{k:T^{(k)}(x)=1\}$$ 

### Trajectory of $x$ Under $T$

- also called the _forward orbit_ of $x$ under $T$
- defined as the sequence of it forward iterates $^{[3]}$
$$\{x, T(x), T^{(2)}(x), T^{(3)}(x),\dots\}$$ 

## The Collatz Conjecture

### Possible behaviors of $T$

1. the trivial cycle $\{4,2,1,4,2,1,\dots\}$ (reaching 1)
2. a non-trivial cycle
3. infinity, having a divergent orbit $^{[1]}$

### The Conjecture

- beginning at any positve integer $x$, iterations of $T(x)$ will eventually
reach 1 and enter the trivial cycle $^{[3]}$
- equivalent to stating that the total stopping time 
$\sigma_{\infty}(x)$ are finite $^{[1]}$
- if a trajectory of $T(x)$ does _not_ contain 1 it is infinite $^{[2]}$

## What Makes This Problem Interesting?

###

\begin{quote}Mathematics is not ready for such problems. \newline
\flushright --- Paul Erdös $^{[1]}$\end{quote}

### 

- the problem itself is not important, it has no immediate applications
- represents a class of iterative mappings that are interesting
- it is simple to state but hard to prove
- part of the difficulty comes from its pseudorandom nature of iterations of 
$T(x)$ $^{[3]}$

## History of the Collatz Conjecture

### Beginnings

- also known as Syracuse Problem, Hasse's Algorithm, Kakutani's Problem, and
Ulam's Problem after other people that studied it
- named after Lothar Collatz who formulated similar problems in the 1930s
- academic publishing about it began in the 1970s $^{[3]}$

### Recent Developments

- $>10^{20}$ numbers have been verified to fit the conjecture $^{[4]}$
- a September 2019 paper by Terence Tao "Almost All Orbits of the Collatz Map Attain
Almost Bounded Values" made progress
- research is still actively ongoing

## Interesting Attributes of the $3x+1$ Problem

### Cycles of the Function

- the $3x+1$ function has a trivial cycle $\{4,2,1,4,2,\dots\}$ at 1 $^{[1]}$
- if $T(x)$ is applied to all integers, three more cycles emerge at -1, -5, and -17
- these cycles are conjectured to be the only ones $^{[1]}$
- if non-trivial cycles of the $3x+1$ problem exist, they have been proven to
be at least 10,439,860,591 numbers long $^{[3]}$

### Stochastic Approximations

- number of odd and even integers in an orbit is approximately equal
- behavior is seen as pseudorandom, if the numbers are large enough they almost
behave like random variables $^{[2]}$
- probabilistic models describe the behavior of the $3x+1$ problem
- models describe groups of trajectories, not individual ones $^{[3]}$

### Stopping Time of the Function

- stopping time for odd numbers is $\approx 9.477955$ for $C(x)$ $^{[1]}$
- total stopping time for most trajectories is about $6.95212 \log n$ steps
- number of even integers in an orbit equal to stopping time
- upper bound for total stopping time $41.677647 \log n$, suggests all
sequences are finite $^{[3]}$

## Conclusion

###

- The $3x+1$ Problem and Collatz Conjecture
- What Makes This Problem Interesting?
- History of the Collatz Conjecture
- Interesting Attributes of the $3x+1$ Problem

## Any questions?

### References

1. Marc Chamberland, _An Update on the $3x+1$ Problem_, 
`http://www.math.grinnell.edu/~chamberl/papers/` `3x_survey_eng.pdf`, 2005.
2. R. E. Crandall, _On the "$3x+1$" Problem_, Mathematics of Computation, 
__32__ (1978), no. 144, 1281-1292
3. Jeffrey C. Lagarias, _The $3x+1$ Problem: An Overview_,
`https://pdfs.semanticscholar.org/1000/` `46dd8b4ee901bc71043da7d42f5d87ca0224.pdf`, 2010
4. Terence Tao, _Almost All Orbits of the Collatz Map Attain Almost Bounded
Values_, arXiv:1909.03562v2 [math.PR], 2019
