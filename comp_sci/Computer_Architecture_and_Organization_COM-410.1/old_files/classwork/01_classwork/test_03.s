	AREA test_03, CODE, READONLY
	LDR r1, Q ; load r1 with Q
	LDR r2, R ; load r2 with R
	LDR r3, S ; load r3 with S
	ADD r0, r1, r2 ; add Q to R
	ADD r0, r3 ; add in S
	STR r0, Q ; store result in Q
Stop B Stop

	AREA test_03, CODE, READWRITE
P 	SPACE 4 ; save one word of storage
Q 	DCD 2 ; create variable Q with initial value 2
R 	DCD 4 ; create variable R with initial value 4
S 	DCD 5 ; create variable S with initial value 5
	END