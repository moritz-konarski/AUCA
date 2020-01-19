# Assignment 1

_After executing the following commands_

1. what value will _r11_ have?
    ```
    00 E3A0001D MOV r0, #0x1D
    04 E3A01008 MOV r1, #0x8
    08 E081B000 ADD r11, r1, r0
    ```
    1. `0x00000025`
    2. `0x0000032E`
    3. `0x00000172`
    1. `0x0000001B`
    1. `0x00000001`
    1. other 
2. what value will _r3_ have?
    ```
    00 E3A00007 MOV r0, #0x7
    04 E3A0100E MOV r1, #0xE
    08 E0413000 SUB r3, r1, r0
    ```
    1. `0x0000002A` 
    2. `0x00000001`
    3. `0x00000007`
    1. `0x00000002`
    1. `0x0000000D`
    1. other 
3. what value will _r3_ have?
    ```
    00 E3A0000B MOV r0, #0xB
    04 E3A01009 MOV r1, #0x9
    08 E0020091 MUL r2, r1, r0
    ```
    1. `0x00000063` 
    2. `0x000000B0`
    3. `0x00000003`
    1. `0x0000005B`
    1. `0x000013B9`
    1. other 
4. what value will _r0_ have?
    ```
    00 E3A01005 MOV r1, #0x5
    04 E0000191 MUL r0, r1, r1
    08 E3A02004 LDR r2, =4
    0c E0000092 MUL r0, r2, r0
    10 E3A02003 LDR r2, =3
    14 E0020291 MUL r2, r1, r2
    18 E0800002 ADD r0, r0, r2
    ```
    1. `0x00000002` 
    2. `0x00000073`
    3. `0x0000175C`
    1. `0x0000007A`
    1. `0x00000B3B`
    1. other 
