	AREA a01_4, CODE, READONLY
	MOV r1, #0x5
	MUL r0, r1, r1
	LDR r2, =4
	MUL r0, r2, r0
	LDR r2, =3
	MUL r2, r1, r2
	ADD r0, r0, r2
S	B	S
	END