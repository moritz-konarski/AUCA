	AREA test_05, CODE, READWRITE
	ENTRY
	ADR r0, P ; r4 points to the data area
	LDR r1, [r0, #4] ; load Q into r1
	LDR r2, [r0, #8] ; load R into r2
	ADD r2, r1, r2 ; add Q and R
	LDR r1, [r0, #12] ; load S into r3
	ADD r2, r2, r1 ; add S to the total
	STR r1, [r2] ; save the result in memory
Stop B Stop

	AREA test_05, CODE, READWRITE
P 	SPACE 4 ; save one word of storage for P
Q 	DCD 2 ; create variable Q with initial value 2
R 	DCD 4 ; create variable R with initial value 4
S 	DCD 5 ; create variable S with initial value 5
	END