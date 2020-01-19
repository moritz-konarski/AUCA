# Assignment 2

_After executing the following commands, what values will the flags have?_        
Flags are arranged in the form of `NZCV`. `N` -- negative, `Z` -- equal, `C` --
unsigned greater or equal, `V` -- overflow.

1. Code:
    ```
    00 E3A00020 MOV r0,#0x20
    04 E3A01020 MOV r1,#0x20
    08 E0512000 SUBS r2,r1,r0
    ```
    1. `0x0`
    2. `0xA`
    3. `0x6`
    4. `0x2`
    5. `0x9`
    6. other
2. Code:
    ```
    00 E3A00103 MOV r0, #0xC0000000
    04 E3A0120F MOV r1, #0xF0000000
    08 E0513000 SUBS r3, r1, r0
    ```
    1. `0x5`
    2. `0x2`
    3. `0x9`
    4. `0x1`
    5. `0x6`
    6. other
3. Code:
    ```
    00 E3A00102 MOV r0, #0x80000000
    04 E3A01101 MOV r1, #0x40000000
    08 E0517000 SUBS r7, r1, r0
    ```
    1. `0x1`
    2. `0x9`
    3. `0xD`
    4. `0xB`
    5. `0x4`
    6. other
4. Code:
    ```
    00 E3A0020A MOV r0, #0xA0000000
    04 E3A0120F MOV r1, #0xF0000000
    08 E0913000 ADDS r3, r1, r0
    0c E0432000 SUB r2, r3, r0
    ```
    1. `0xA`
    2. `0x3`
    3. `0xC`
    4. `0x2`
    5. `0x1`
    6. other
