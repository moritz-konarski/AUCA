.section .data
in_format: .string "%ld"
out_format: .string "%ld! = %ld\n"
n: .int 0, 0

.section .text

factorial:
    cmp %rcx, %rdx
    je .fac_end
    mul %rcx
    inc %rcx
    call factorial

.fac_end:
    ret

.end:
    mov %rax, %rsi
    lea out_format(%rip), %rdi
    xor %eax, %eax
    call printf@plt
    add $0x20, %rsp
    leave
    xor %eax, %eax
    ret

.global main
main:
    push %rbp
    mov %rsp, %rbp

    sub $0x20, %rsp
    
#lea in_format(%rip), %rdi
#lea n(%rip), %rsi
#xor %eax, %eax
#call scanf@plt

#mov n(%rip), %rdx   # 
    mov $3, %rdx
    mov $1, %rsi
    mov $1, %rcx
    mov $1, %rax

    call factorial

    jmp .end

    # if n = 0 return 1
    # else return n * fac(n-1)
