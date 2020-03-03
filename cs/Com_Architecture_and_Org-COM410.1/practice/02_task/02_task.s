.section .data
message: .string "Hello, World!"

.section .text
.global main
main:
    lea message(%rip), %rdi
    xor %eax, %eax
    call puts@plt

    xor %eax, %eax
    ret
