.section .data
in_format: .string "%ld"
out_format: .string "Fibonacci number at place %ld is: %ld\n"
n: .int 0, 0

.section .text

fib_recursion:
    cmp $0, %rax  # check if counter is less than n
    dec %rax
    # if rax is greater 0
    jl .end
    mov %rdx, %rcx  # save a in temp variable
    add %r8, %rdx   # add r8 to rdx and store in rdx
    mov %rcx, %r8   # put temp variable back in a
    call fib_recursion # jump back to fib_check
    
.end:
    lea out_format(%rip), %rdi
    xor %eax, %eax
    call printf@plt

    leave
    xor %eax, %eax
    ret

.global main
main:

    push %rbp
    mov %rsp, %rbp

    lea in_format(%rip), %rdi
    lea n(%rip), %rsi
    xor %eax, %eax
    call scanf@plt
    
    mov n(%rip), %rsi
    mov n(%rip), %rax # counter variable
    mov $0, %rdx # var a
    mov $0, %rcx # temp variable
    mov $1, %r8  # var b
    call fib_recursion
