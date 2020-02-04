.section .data
number: .int 0x0
input_format: .string "%ld"
output_format: .string "%ld\n"

.section .text
.global main
main:
        
    # align the stack
    push %rbp
    mov %rsp, %rbp

    lea input_format(%rip), %rdi    
    lea number(%rip), %rsi          
    xor %eax, %eax
    call scanf@plt  
        
    mov number(%rip), %rsi  
    inc %rsi               

    lea output_format(%rip), %rdi
    xor %eax, %eax
    call printf@plt

    leave

    xor %eax, %eax
    ret
