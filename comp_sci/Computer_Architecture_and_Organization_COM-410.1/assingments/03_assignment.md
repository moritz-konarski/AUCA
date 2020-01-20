# Assignment 3

_After executing the following commands, what values will the flags have?_        
Flags are arranged in the form of `NZCV`. `N` -- negative, `Z` -- equal, `C` --
unsigned greater or equal, `V` -- overflow.

1. Code:
    ```
    00 E3A00205 MOV r0, #0x50000000
    04 E3A01103 MOV r1, #0xC0000000
    08 E0512000 SUBS r2, r1, r0
    ```
    1. `0x4`
    2. `0x6`
    3. `0x2`
    4. `0x5`
    5. `0x3`
    6. other
2. Code:
    ```
    00 E3A00102 MOV r0, #0x80000000
    04 E3A01102 MOV r1, #0x80000000
    08 0512000 SUBS r2, r1, r0
    ```
    1. `0x3`
    2. `0xA`
    3. `0x1`
    4. `0x6`
    5. `0x8`
    6. other
3. Code:
    ```
    00 E3E00003 MOV r0, #0xFFFFFFFC
    04 E3A01020 MOV r1, #0x20
    08 E0512000 SUBS r2, r1, r0
    ```
    1. `0x0`
    2. `0xA`
    3. `0x4`
    4. `0x9`
    5. `0x2`
    6. other
4. Code:
    ```
    00 E3A00020 MOV r0, #0x20
    04 E3A01000 MOV r1, #0
    08 E0512000 SUBS r2, r1, r0
    ```
    1. `0x8`
    2. `0x2`
    3. `0x1`
    4. `0xB`
    5. `0x0`
    6. other
