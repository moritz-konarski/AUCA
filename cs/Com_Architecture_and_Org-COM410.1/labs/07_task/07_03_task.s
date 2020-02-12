.section .data
input: .string "%d %d %d %d"
output: .string "%d\n"

a: .int 0,0
x: .int 0,0
c: .int 0,0
m: .int 0,0


.section .text

rnd_gen:

.rnd_loop:

.rnd_loop_end:

    ret

.global main:
main:

    lea input(%rip), %rdi
    lea a(%rip), %rsi
    lea x(%rip), %rdx
    lea c(%rip), %rcx
    lea m(%rip), %r8
    xor %eax, %eax
    call scanf@plt

    sub $40, %rsp
    push %rbp
    mov %rsp, %rbp

    mov a(%rip), %rdi
    mov x(%rip), %rsi
    mov c(%rip), %rdx
    mov m(%rip), %rcx
    lea 8(%rbp), %r8
    call rnd_gen

.loop:

.loop_end:

    xor %eax, %eax
    ret
