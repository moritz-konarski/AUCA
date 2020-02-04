.section .data
int_a: .int 0x0
int_b: .int 0x0
prompt_msg: .string "Enter a number: "
read_format: .string "%ld"
write_format: .string "sum: %ld\n"

.section .text
.global main
main:
    push %rbp
    mov %rsp, %rbp

# ask user for input
    lea prompt_msg(%rip), %rdi
    xor %eax, %eax
    call printf@plt

# read the users input
    lea read_format(%rip), %rdi
    lea int_a(%rip), %rsi
    xor %eax, %eax
    call scanf@plt

# ask user for input
    lea prompt_msg(%rip), %rdi
    xor %eax, %eax
    call printf@plt

# read the users input
    lea read_format(%rip), %rdi
    lea int_b(%rip), %rsi
    xor %eax, %eax
    call scanf@plt

# add r8 to r9, store in r8

    xor %r9, %r9
    xor %r10, %r10
    mov int_a(%rip), %r9
    mov int_b(%rip), %r10
    ADD %r9, %r10
    MOV %r9, %rsi

# print the result

    lea write_format(%rip), %rdi
    xor %eax, %eax
    call printf@plt

    leave
    xor %eax, %eax
    ret
    
