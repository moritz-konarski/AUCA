.section .data 
output: .string "%ld\n"

.section .text
.global main
main:
    mov $1, %rsi
    mov $30, %rdx

.loop:
    dec %rdx
    test %rdx, %rdx
    jle .loop_end

    inc %rsi
    jmp .loop

.loop_end:
    lea output(%rip), %rdi
    xor %eax, %eax
    call printf@plt

    xor %eax, %eax
    ret
