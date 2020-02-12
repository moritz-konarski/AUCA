.section .data 
input: .string "%d %d"
output: .string "%d\n"
a: .int 0,0
cond: .int 0,0


.section .text
.global main
main:

    sub $0x8, %rsp

    lea input(%rip), %rdi
    lea a(%rip), %rsi
    lea cond(%rip), %rdx
    xor %eax, %eax
    call scanf@plt

    mov a(%rip), %rsi
    dec %rsi
    mov cond(%rip), %rdx

.loop:
    test %rdx, %rdx
    jle .loop_end

    add %rdx, %rsi
    dec %rdx
    jmp .loop

.loop_end:
    lea output(%rip), %rdi
    xor %eax, %eax
    call printf@plt

    add $0x8, %rsp
    xor %eax, %eax
    ret
