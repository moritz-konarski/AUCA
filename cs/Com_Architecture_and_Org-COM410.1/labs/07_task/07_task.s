.section .data
read_format: .string "%ld %ld"
write_equal: .string "%ld is equal to %ld\n"
write_greater: .string "%ld is greater than %ld\n"
write_lesser: .string "%ld is less than %ls\n"
a: .int 0, 0
b: .int 0, 0

.section .text



.global main
main:

    sub $0x8, %rsp

    lea read_format(%rip), %rdi
    lea a(%rip), %rsi
    lea b(%rip), %rdx
    xor %eax, %eax
    call scanf@plt

    lea write_equal(%rip), %rdi
    mov a(%rip), %rsi
    mov b(%rip), %rdx
    cmp %rsi, %rdx
    xor %eax, %eax
    call printf@plt


    add $0x8, %rsp

    xor %eax, %eax
    ret
