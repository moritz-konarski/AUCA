	AREA test_01, CODE, READONLY
	MOV r1, #0x2
	MOV r2, #0x4
	MOV r3, #0x5
	ADD r0, r1, r2
	ADD r0, r3
Stop B Stop
	END