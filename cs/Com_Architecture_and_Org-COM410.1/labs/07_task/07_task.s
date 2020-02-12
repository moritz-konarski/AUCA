.section .data
read_format: .string "%ld %ld"
output_format: .string "%ld is greater than %ld\n"
output_equal: .string "%ld and %ld are equal\n"
a: .int 0, 0
b: .int 0, 0

.section .text

.main_ag:
    lea output_format(%rip), %rdi
    lea a(%rip), %rsi
    lea b(%rip), %rdx
    xor %eax, %eax
    call printf@plt

    jmp .main_end

.main_bg:
    lea output_format(%rip), %rdi
    lea b(%rip), %rsi
    lea a(%rip), %rdx
    xor %eax, %eax
    call printf@plt

    jmp .main_end

.main_eq:
    lea output_equal(%rip), %rdi
    lea b(%rip), %rdx
    lea a(%rip), %rsi
    xor %eax, %eax
    call printf@plt

    jmp .main_end

.main_end:
    add $0x8, %rsp
    xor %eax, %eax
    ret

.global main
main:

    sub $0x8, %rsp

    lea read_format(%rip), %rdi
    lea a(%rip), %rsi
    lea b(%rip), %rdx
    xor %eax, %eax
    call scanf@plt

    mov a(%rip), %rsi
    mov b(%rip), %rdx
    cmp %rdx, %rsi
    jg .main_ag
    jl .main_bg
    jmp .main_eq


#xor %eax, %eax
#   ret
