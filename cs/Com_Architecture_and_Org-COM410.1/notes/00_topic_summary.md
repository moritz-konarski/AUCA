# Topic Summary

## Architecture

- registers
- program counter
- condition codes
- status codes
- processing cycle
- pipelining
- forwarding
- cutting in line
- out-of-order execution

## Assembly

### Labels

- `.global` labels
- `%eax` being set to zero
- section of assembly code (`.section`)

### Program Basics

- why we need `push %rbp` to `call puts@plt`
- `push %rbp` and then `mov %rsp, %rbp`
- subtracting 8 from base pointer and then adding it back at the end
- what does `lea var(%rip)` do exactly
- what does `leave` do
- what does `ret` do
- order of registers for arguments to functions
- multi-register operations

### Variables

- `int x 0, 0`
- plt
- position independent code
- got (global offset table)

### Important Commands

- syscall vs call
- call functions
- jumps
- loops using labels
