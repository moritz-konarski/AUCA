.section .data
input: .string "%ld %ld"
output: .string "%ld\n"

.section .text

.global main
main:
    
    sub $0x18, %rsp   

    lea input(%rip), %rdi
    lea 0x8(%rsp), %rsi
    lea (%rsp), %rdx
    xor %eax, %eax
    call scanf@plt

    mov 0x8(%rsp), %rsi
    mov (%rsp), %rdi

.gcd_loop:

    test %rdi, %rdi
    jz .gcd_end

    mov %rsi, %rax
    cqo
    mov %rdi, %rsi
    div %rdi
    mov %rdx, %rdi
    jmp .gcd_loop

.gcd_end:

    lea output(%rip), %rdi
    xor %eax, %eax
    call printf@plt

    add $0x18, %rsp   
    xor %eax, %eax
    ret
