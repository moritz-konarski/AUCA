.section .data
output_format: .string "%ld\n"

.section .text

# static long add1(int a) { ...
add1:
    mov %edi, %eax
    cltq
    ret

add2:
    mov %rdi, %rax
    add %rsi, %rax
    ret

add3:
    mov %rdi, %rax
    add %rsi, %rax
    add %rdx, %rax
    ret

add4:
    mov %rdi, %rax
    add %rsi, %rax
    add %rdx, %rax
    add %rcx, %rax
    ret

add5:
    mov %rdi, %rax
    add %rsi, %rax
    add %rdx, %rax
    add %rcx, %rax
    add %r8, %rax
    ret

add6:
    mov %rdi, %rax
    add %rsi, %rax
    add %rdx, %rax
    add %rcx, %rax
    add %r8, %rax
    add %r9, %rax
    ret

add7:
    add %rdi, %rax
    add %rsi, %rax
    add %rdx, %rax
    add %rcx, %rax
    add %r8,  %rax
    add %r9,  %rax
    pop %rdx       # return address
    pop %rdi       # 7
    add %rdi, %rax
    push %rdx      # put the return address back

    ret

.global main
main:
    
    # add1
    mov $1, %edi
    call add1

    lea output_format(%rip), %rdi
    mov %rax, %rsi
    xor %eax, %eax
    call printf@plt

#--------------------------------------

    # add2
    mov $1, %rdi
    mov $2, %rsi
    call add2

    lea output_format(%rip), %rdi
    mov %rax, %rsi
    xor %eax, %eax
    call printf@plt

#--------------------------------------

    # add3
    mov $1, %rdi
    mov $2, %rsi
    mov $3, %rdx
    mov $4, %rcx
    call add3

    lea output_format(%rip), %rdi
    mov %rax, %rsi
    xor %eax, %eax
    call printf@plt

#--------------------------------------

    # add4
    mov $1, %rdi
    mov $2, %rsi
    mov $3, %rdx
    mov $4, %rcx
    call add4

    lea output_format(%rip), %rdi
    mov %rax, %rsi
    xor %eax, %eax
    call printf@plt

#--------------------------------------

    # add5
    mov $1, %rdi
    mov $2, %rsi
    mov $3, %rdx
    mov $4, %rcx
    mov $5, %r8
    call add5

    lea output_format(%rip), %rdi
    mov %rax, %rsi
    xor %eax, %eax
    call printf@plt

#--------------------------------------

    # add6
    mov $1, %rdi
    mov $2, %rsi
    mov $3, %rdx
    mov $4, %rcx
    mov $5, %r8
    mov $6, %r9
    call add6

    lea output_format(%rip), %rdi
    mov %rax, %rsi
    xor %eax, %eax
    call printf@plt

#--------------------------------------
    
    # add7
    mov $1, %rdi
    mov $2, %rsi
    mov $3, %rdx
    mov $4, %rcx
    mov $5, %r8
    mov $6, %r9
    push $7
    call add7
    lea output_format(%rip), %rdi
    mov %rax, %rsi
    xor %eax, %eax
    call printf@plt

#--------------------------------------

    # add8...add10
    # ...

    # return 0;
    xor %eax, %eax
    ret


