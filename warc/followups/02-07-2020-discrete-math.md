# Complex numbers

$$ \left\{\begin{array}{ll}
    z_1 + z_2 &= 4(1-i) \\
    z_1 \cdot z_2 &= -10i
    \end{array} \right. $$

# Progressions

$$ a_n = 3 \cdot a_{n-1} + 4 \cdot 7^{n-1} $$

# Taylor Series

$$f(x) = \frac{1-e^{2x}}{x} ; \quad a = 0$$

To find the series at $a=0$ we replace $e^{2x}$ with its Taylor Series. 

$$\sum_{n=0}^{\infty}{\frac{f^{(n)}(a)}{n!}(x-a)^n}$$

The first couple derivatives of $g(x)=e^{2x}$ are

$$ g'(x) = 2 \cdot e^{2x}, \qquad g''(x) = 2 \cdot 2 \cdot e^{2x}, \qquad  g'''(x) = \\ 
2 \cdot 2 \cdot 2 \cdot 2e^{2x}, \quad ...$$ 

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
