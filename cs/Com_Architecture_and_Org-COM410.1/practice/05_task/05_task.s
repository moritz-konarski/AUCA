.section .data
in_format: .string "%ld %ld"
out_format: .string "%ld + %ld = %ld\n"
a: .int 0, 0
b: .int 0, 0

.section .text
.global main
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
    add %rsi, %rcx
    add %rdx, %rcx
    lea out_format(%rip), %rdi
    xor %eax, %eax
    call printf@plt

    leave
    xor %eax, %eax
    ret
