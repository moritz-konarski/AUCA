.section .data
a: .int 0, 0
b: .int 0, 0 
in_format: .string "%ld %ld"
greater_out: .string "\n%ld is greater than %ld\n"
smaller_out: .string "\n%ld is smaller than %ld\n"
equal_out: .string "\n%ld and %ld are equal\n"

.section .text
.global main

.smaller:
    lea smaller_out(%rip), %rdi
    jmp .end

.greater:
    lea greater_out(%rip), %rdi
    jmp .end

.equal:
    lea equal_out(%rip), %rdi
    jmp .end

main:
    push %rbp
    mov %rsp, %rbp

    lea in_format(%rip), %rdi
    lea a(%rip), %rsi
    lea b(%rip), %rdx
    xor %eax, %eax
    call scanf@plt

    mov a(%rip), %rsi
    mov b(%rip), %rdx

    cmp %rdx, %rsi
    jl .smaller
    jg .greater
    je .equal
    
.end:
    xor %eax, %eax
    call printf@plt
    leave
    xor %eax, %eax
    ret
