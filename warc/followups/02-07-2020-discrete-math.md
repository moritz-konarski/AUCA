# Progressions

$$ a_n = 3 \cdot a_{n-1} + 4 \cdot 7^{n-1} $$
When we write down the first couple elements of the series we get
$$\begin{split}
a_0 &= 0 \\
a_1 &= 3 \cdot 0 + 4 \cdot 7^0 = 4 \\
a_2 &= 3 \cdot 4 + 4 \cdot 7^1 = 40 \\
a_3 &= 3 \cdot 40 + 4 \cdot 7^2 = 316 \\
a_4 &= 3 \cdot 316 + 4 \cdot 7^3 = 2320
\end{split}$$
When we look at these first 5 elements, we can see that all of them contain $3
\cdot a_{n-1}$ and $4 \cdot 7^{n-1}$. Now we can make a guess that our
progression depends in some way on $7^n$ and $3^n$ (because we multiply by
3 every time, which is analogous to $3^n$). With this in mind we can try to split
our results (the $a_n$s) into $3^n$ and $7^n$
$$\begin{split}
a_0 = 0 &= 1 - 1 = 7^0 - 3^0 \\
a_1 = 4 &= 7 - 3 = 7^1 - 3^1 \\
a_2 = 40 &= 49 - 9 = 7^2 - 3^2 \\
a_3 = 316 &= 343 - 27 = 7^3 - 3^3 \\
a_4 = 2320 &= 2401 - 81 = 7^4 - 3^4
\end{split}$$
From this it is obvious that our progression can also be written as 
$$a_n = 7^n - 3^n.$$

# Taylor Series

$$f(x) = \frac{1-e^{2x}}{x} \quad ; \qquad a = 0$$

To find the series at $a=0$ we replace $e^{2x}$ with its Taylor Series. 
$$\sum_{n=0}^{\infty}{\frac{f^{(n)}(a)}{n!}(x-a)^n}$$
The first couple derivatives of $g(x)=e^{2x}$ are
$$ g'(x) = 2 \cdot e^{2x}, \qquad g''(x) = 2 \cdot 2 \cdot e^{2x}, \qquad  \\
g'''(x) = 2 \cdot 2 \cdot 2 \cdot 2e^{2x}, \quad ...$$ 
Plugging in plugging in $g(x)$ into the formula for the Taylor Series with 
$a=0$ into we get
$$\frac{e^0}{0!}x^0, \quad \frac{2 \cdot e^0}{1!}x^1, \quad \frac{2 \cdot \\
    2 \cdot e^0}{2!}x^2, \quad \frac{2 \cdot 2 \cdot 2 \cdot e^0}{3!}x^3, \\
    ...$$
We see that this can be written as 
$$\sum_{n=0}^\infty\frac{2^n}{n!}x^n.$$
We now put this expression into $f(x)$ and get
$$f(x) = \frac{1 - \sum_{n=0}^\infty\frac{2^n}{n!}x^n}{x}$$
We extract the first element of the series
$$f(x) = \frac{1 - \left(\frac{2^0}{0!}x^0 + \sum_{n=1}^\infty\frac{2^n}{n!} \\
        x^n\right)}{x}$$
which becomes
$$f(x) = \frac{-\sum_{n=1}^\infty\frac{2^n}{n!}x^n}{x}.$$
Dividing by $x$ gives
$$f(x) = -\sum_{n=1}^\infty\frac{2^n}{n!}x^{n-1}.$$

# Multivariable Integrals

$$\int_{0}^{1}\int_{\sqrt{y}}^{1}{y \frac{e^{x^2}}{x^3}}{dx}{dy}$$
The limits of the inner integral $\int_{\sqrt y}^1$ can be changed to
$\int_0^{x^2}$ by changing the order of integration. This yields
$$\int_{0}^{1}\int_{0}^{x^2}{y \frac{e^{x^2}}{x^3}}{dy}{dx}.$$
This is possible because $\sqrt{y} \rightarrow 1$ for $x$ is equivalent to
$0 \rightarrow x^2$ for $y$. The other limit stays $0 \rightarrow 1$. We can
now easily integrate the inner integral
$$\int_{0}^{1}\int_{0}^{x^2}{y \frac{e^{x^2}}{x^3}}{dy}{dx} = \\
\int_0^1{\left[\frac{1}{2}y^2\frac{e^{x^2}}{x^3}\right]_{y=0}^{y=x^2}}{dx} = \\
\int_0^1{\frac{1}{2}x^4\frac{e^{x^2}}{x^3}}{dx} = \\
\frac{1}{2}\int_0^1{xe^{x^2}}{dx}.$$
We can solve the resulting integral by substituting $u=x^2$ and $du=2xdx$ or
$dx=\frac{du}{2x}$ (the limits don't change in this particular case), giving
$$ \frac{1}{2}\int_0^1{xe^u}{\frac{du}{2x}} = \\
\frac{1}{2}\int_0^1{\frac{e^u}{2}}{du} = \\ 
\frac{1}{4}\left[e^u\right]_0^1 = \\
\frac{1}{4}(e^1-e^0) = \frac{e-1}{4}.$$
