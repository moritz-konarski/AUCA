.section .data
out_format: .string "sum = %ld\n"

.section .text

sum10:
    pop %rdx
    mov $0, %rsi
    pop %rcx
    add %rcx, %rsi
    pop %rcx
    add %rcx, %rsi
    pop %rcx
    add %rcx, %rsi
    pop %rcx
    add %rcx, %rsi
    pop %rcx
    add %rcx, %rsi
    pop %rcx
    add %rcx, %rsi
    pop %rcx
    add %rcx, %rsi
    pop %rcx
    add %rcx, %rsi
    pop %rcx
    add %rcx, %rsi
    pop %rcx
    add %rcx, %rsi
    push %rdx
    ret

.global main
main:

    push %rbp
    mov %rsp, %rbp

    push $10
    push $10
    push $10
    push $10
    push $10
    push $10
    push $10
    push $10
    push $10
    push $10
    call sum10
    
    lea out_format(%rip), %rdi
    xor %eax, %eax
    call printf@plt

    leave
    xor %eax, %eax
    ret
