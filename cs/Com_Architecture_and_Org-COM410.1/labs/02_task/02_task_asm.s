.section .data
output_text: .string "Test string"

.section .text
.global main
main:
    push %rbp
    mov %rsp, %rbp

    lea output_text(%rip), %rdi
    xor %eax, %eax
    call puts@plt

    leave
    xor %eax, %eax
    ret
