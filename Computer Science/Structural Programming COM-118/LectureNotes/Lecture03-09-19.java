//Lecture on the 19th of September
//Professor Toksaitov

--> Read the second chapter of the book for Friday

#Comments
	//	line comment

	/*
		Block comment
	*/

#Functions of certain symbols
	{} - braces 			- denote enclosed statement
	() - parenthesis 		- used with methods, also in math operations
	[] - brackets 			- denote an array
	"" - quotation marks 	- enclose a string
	;  - semicolon 			- marks end of statement

#Some inportant parts of the code
	public static void main(String[] args) - the part where the program starts

#Errors
	#Syntax Errors - caught before compiling - ok type of error, easily fixed
		missing braces, parenthesis, brackets
		missing semicolons
		missing quotation marks
		misspelled names
		using protected names
	#Runtime Errors - happen while the program runs - not good, but solvable
		division by zero
	#Logic Errors - it does not crash but works incorrectly - really bad, might not be found
		wrong calculations (missing parenthesis or signs)
		wrong variable types (int vs double)

#Programming Style
	Spacing		- making it easier to read - use tabs  			\\
	Indentation	- relations between individual blocks are clear  --> It seriously improves the readability
	Naming      - making it easy to understand what stuff does  //
	--> BE CONSISTENT, that is key
	
#Identifiers
	letters
	digits - do not start with them
	underscores
	dollar signs
	- DO NOT use reserved words like "Class", "True", "False" etc.

#Variables
	declaration: <data type> <name> (= <value>);
		start with lower case
		maybe <data type> <var 1>, <var 2>, <var 3> for multiple variables
	initialization: <variable> = <value>
		same stringing together like in declaration
	<=> is an assingment operator, <variables> are assigned <expressions>
		they always return one thing: numbers, results of calculations, strings
	variables can be used on both sides of <=>, even the same ones
	can also be used like .println(x = 1); both prints and assigns the value
	also like k = l = j = 1; all get assgigned 1
	expression is generally a calculation, like 'y + 1'	

#Constants
	final <data type> <constant name> = <name>, this creates a value that can not be changed afterwards
	the name should be upper case only, for stylistic purposes, not syntax as java does not care

--> try to create descriptive names for your variables, exceptions can be made for common stuff like x, y, i, j...
	ALL UPPER CASE = constant
	all lower case / camelCase = variables
	starting with Upper Case = Class

#Data Types
	#Integers
		#Byte
			8 Bits, signed
		#Short
			16 Bit, signed
		#Integer	
			32 Bit, signed
		#Long 
			64 Bit, signed
	#Floating Points - the decimal point can float to give more precision to the parts that matter
		#Float 
			32 Bit, IEEE 754
		#Double - a double floating point number
			64 Bit, IEEE 754

#Operators
	+ ~ addition
	- ~ subtraction
	* ~ multiplication
	/ ~ division, division with integers truncates the decimal points
	% ~ modulo (remainder of the division) -> the remainder is negative only if the dividend is negative, not the divisor

#Math functions
	Math.pow(a,b), Math.sin(a), Math.ceil(a), Math.floor(a), Math.round(a)...
	
#Numeric Literals
	42		- int
	42L		- long
	0.5		- double
	0.5D	- double
	0.5F	- float
	0B1011	- binary, leading 0B
	0X9AE	- hexadicimal, leading 0X 
	0557	- octal, leading 0
	2.1364E2- scientific notation, in floating point numbers
	12_334	- it is possible to use underscores between numbers for better readability

#Order of Operation
	1. ()
	2. * or / or %
	3. + or -
	with equal importance it goes from left to right, parenthesis from the inside out

#Assignement Operations
	i += 3 - i = i + 3
	i -= 3 - i = i - 3
	i *= 3 - i = i * 3
	i /= 3 - i = i / 3
	i %= 3 - i = i % 3

#Integrated Operations
	i++ - i used and then incremented
	i-- - i used and then decremented
	++i - i incremented and then used
	--i - i decremented and then used