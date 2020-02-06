.section .data
number: .int 0x0
input_format: .string "%ld"
output_format: .string "%ld\n"

.section .text
.global main
main:
        
    push %rbp
    mov %rsp, %rbp

    lea input_format(%rip), %rdi    
    lea number(%rip), %rsi          
    mov $0, %rax
    call scanf@plt  
        
    mov number(%rip), %rsi  
    dec %rsi               

    lea output_format(%rip), %rdi
    mov $0, %rax
    call printf@plt

    leave

    mov $0, %rax
    ret
