.section .data
output_format: .string "%ld\n"

#------------------------------------------------

.section .text

add2:
    mov %rdi, %rax
    add %rsi, %rax
    ret

add3:
    mov %rdi, %rax
    add %rsi, %rax
    add %rdx, %rax
    ret

add6:
    mov %rdi, %rax
    add %rsi, %rax
    add %rdx, %rax
    add %rcx, %rax
    add %r8, %rax
    add %r9, %rax
    ret

add10:
    mov %rdi, %rax
    add %rsi, %rax
    add %rdx, %rax
    add %rcx, %rax
    add %r8, %rax
    add %r9, %rax
    add %r10, %rax
    add %r11, %rax
    add %r12, %rax
    add %r13, %rax
    ret

add10m:
    pop %rax
    pop %rsi
    add %rsi, %rax
    pop %rsi
    add %rsi, %rax
    pop %rax
    add %rsi, %rax
    pop %rsi
    add %rsi, %rax
    pop %rax
    add %rsi, %rax
    pop %rsi
    add %rsi, %rax
    pop %rax
    add %rsi, %rax
    pop %rsi
    add %rsi, %rax
    pop %rax
    add %rsi, %rax
    ret

#------------------------------------------------

.global main
main:

    mov $1, %rdi
    mov $2, %rsi
    call add2

    mov %rax, %rsi
    lea output_format(%rip), %rdi
    xor %eax, %eax
    call printf@plt

#----------------------------

    mov $1, %rdi
    mov $2, %rsi
    mov $3, %rdx
    call add3

    mov %rax, %rsi
    lea output_format(%rip), %rdi
    xor %eax, %eax
    call printf@plt

#----------------------------

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

#----------------------------

    push $1
    push $2
    push $3
    push $4
    push $5
    push $6
    push $7
    push $8
    push $9
    push $10
    call add10m

    mov %rax, %rsi
    lea output_format(%rip), %rdi
    xor %eax, %eax
    call printf@plt


    xor %eax, %eax
    ret
