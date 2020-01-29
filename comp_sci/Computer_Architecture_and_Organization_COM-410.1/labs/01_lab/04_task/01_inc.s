.section .data
number: .int 0, 0
input_format: .string "%ld"
output_format: .string "%ld\n"

.section .text
.global main
main:
        
    # push basepointer
    push %rbp
    # move stuff somewhere
    mov %rsp, %rbp

    # load something somewhere
    lea input_format(%rip), %rdi    
    # load the number
    lea number(%rip), %rsi          
    # move 0 to somewhere
    xor %eax, %eax
#mov $0, %rax
    # call scanf
    call scanf@plt  
        
    # move a number to %rsi
    mov number(%rip), %rsi  
    # increment the number in %rsi
    inc %rsi               

    lea output_format(%rip), %rdi
    # move 0 somewhere
    xor %eax, %eax
#mov $0, %rax
    call printf@plt

    leave

#mov $0, %rax
    xor %eax, %eax
    ret
