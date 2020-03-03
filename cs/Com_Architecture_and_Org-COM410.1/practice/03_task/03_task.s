.section .data
message: .string "Hello, World!\n"

.section .text
.global main
main:

    mov $1, %rax
    mov $1, %rdi
    mov $14, %rdx
    lea message(%rip), %rsi
    syscall

    xor %eax, %eax
    ret
