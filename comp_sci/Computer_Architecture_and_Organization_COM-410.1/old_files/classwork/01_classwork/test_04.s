	AREA test_04, CODE, READWRITE
	ENTRY
	ADR r4, TheData ; r4 points to the data area
	LDR r1, [r4, #Q] ; load Q into r1
	LDR r2, [r4, #R] ; load R into r2
	LDR r3, [r4, #S] ; load S into r3
	ADD r0, r1, r2 ; add Q and R
	ADD r0, r0, r3 ; add S to the total
	STR r0, [r4, #P] ; save the result in memory
Stop B Stop
P 	EQU 0 ; offset for P
Q 	EQU 4 ; offset for Q
R 	EQU 8 ; offset for R
S 	EQU 12 ; offset for S

	AREA test_04, CODE, READWRITE
TheData SPACE 4 ; save one word of storage for P
	DCD 2 ; create variable Q with initial value 2
	DCD 4 ; create variable R with initial value 4
	DCD 5 ; create variable S with initial value 5
	END