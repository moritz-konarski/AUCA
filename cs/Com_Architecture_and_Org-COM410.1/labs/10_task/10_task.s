.section .data
input: .string "%ld"
output: .string "%ld\n"

.section .text

.global main
main:
    
    sub $0x18, %rsp

    lea input(%rip), %rdi
    lea (%rsp), %rsi
    xor %eax, %eax
    call scanf@plt

    mov (%rsp), %rdi
    mov $0x1, %rsi
    cqo
    mov $0x2, %rcx

.factorial:

    cmp %rcx, %rdi
    jl .factorial_end
    mul %rcx
    inc %rcx

    jmp .factorial
     

.factorial_end:

    mov %rax, %rsi
    lea output(%rip), %rdi
    xor %eax, %eax
    call printf@plt

    add $0x18, %rsp

    xor %eax, %eax
    ret
