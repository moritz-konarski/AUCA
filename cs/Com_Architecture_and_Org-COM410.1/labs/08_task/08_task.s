.section .data
input: .string "%ld"
output: .string "%ld\n"

.section .text

.global main
main:

    sub $0x8, %rsp

    lea input(%rip), %rdi
    lea (%rsp), %rsi        # we want the value, not the address that is in the
                            # register
    xor %eax, %eax
    call scanf@plt

    mov (%rsp), %rdx        # number is in %rdx
    xor %rdi, %rdi
    mov $0x1, %rsi
    

.fib_loop:

   dec %rdx
   test %rdx, %rdx
   jle .fib_end

   mov %rsi, %rcx
   add %rdi, %rsi
   mov %rcx, %rdi
   jmp .fib_loop

.fib_end:

    lea output(%rip), %rdi
    xor %eax, %eax
    call printf@plt

    add $0x8, %rsp
    
    xor %eax, %eax
    ret
