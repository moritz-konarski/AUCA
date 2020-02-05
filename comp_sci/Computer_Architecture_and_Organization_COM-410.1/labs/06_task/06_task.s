.section .data
output_format: .string "%ld\n"


.section .text

add2:
    mov %edi, %eax
    cltq
    mov %rax, %rdi
    mov %esi, %eax
    cltq
    add %rdi, %rax
    ret

add2m:
    mov %rdi, %rax
    add %rsi, %rax
    ret

add6:
    mov %rdi, %rax
    add %rsi, %rax
    add %rdx, %rax
    add %rcx, %rax
    add %r8, %rax
    add %r9, %rax
    ret

.global main
main:

    mov $1, %edi
    mov $2, %esi
    call add2

    mov %rax, %rsi
    lea output_format(%rip), %rdi
    xor %eax, %eax
    call printf@plt

    

    mov $1, %rdi
    mov $2, %rsi
    call add2m

    mov %rax, %rsi
    lea output_format(%rip), %rdi
    xor %eax, %eax
    call printf@plt



    mov $1, %rdi
    mov $2, %rsi
    mov $3, %rdx
    mov $4, %rcx
    mov $5, %r8
    mov $6, %r9
    call add6

    mov %rax, %rsi
    lea output_format(%rip), %rdi
    xor %eax, %eax
    call printf@plt










    xor %eax, %eax
    ret
