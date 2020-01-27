# Assignment 4

_After executing the following commands, what value will register ... have?_        

1. _r4_
    ```
    00 E59F0008 LDR r0, =0xF185
    04 E59F1008 LDR r1, =0x8AC4
    08 E0014000 AND r4, r1, r0
    ```
    1. `0x0000250B`
    2. `0x00008084`
    3. `0x00000856`
    4. `0x00000006`
    5. `0x00000008`
    6. other
2. _r4_
    ```
    00 E59F0008 LDR  r0, =0x7A48
    04 E59F1008 LDR  r1, =0xA7A
    08 E1914200 ORRS r4, r1, r0, LSL #4
    ```
    1. `0x00000003`
    2. `0x000AF647`
    3. `0x000982DA`
    4. `0x00021A4C`
    5. `0x0007AEFA`
    6. other
3. _r2_
    ```
    00 E3A02000 MOV  r2, #0x0
    04 E3A010BE LDR  r1, =0xBE
    08 E1B010A1 MOVS r1, r1, LSR #1
    0c E2A22000 ADC  r2, r2, #0
    10 E1B010A1 MOVS r1, r1, LSR #1
    14 E2A22000 ADC  r2, r2, #0
    ```
    1. `0x00000001`
    2. `0x00000019`
    3. `0x00000014`
    4. `0x00000007`
    5. `0x00000005`
    6. other
4. _r4_
    ```
    00 E59F0008 LDR r0, =0x37D1
    04 E59F1008 LDR r1, =0x56D4
    08 E0214360 EOR r4, r1, r0, ROR #6
    ```
    1. `0x28F8DC40`
    2. `0x00000004`
    3. `0x4400560B`
    4. `0x84CCB5C7`
    5. `0x00000001`
    6. other
