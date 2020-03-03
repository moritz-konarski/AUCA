.section .data
input: .string "%ld"
output: .string "%ld\n"
integer: .int 0, 0

.section .text
.global main
main:

    push %rbp
    mov %rsp, %rbp

    lea input(%rip), %rdi
    lea integer(%rip), %rsi
    xor %eax, %eax
    call scanf@plt


    lea output(%rip), %rdi
    mov integer(%rip), %rsi
    inc %rsi
    xor %eax, %eax
    call printf@plt

    leave
    xor %eax, %eax
    ret
