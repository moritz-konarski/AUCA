.section .data
number: .int 0x0
input_format: .string "%ld"
output_format: .string "%ld\n"

.section .text
.global main
main:
        
    # align the stack
    push %rbp      # save address of the previous stack frame (frame pointer)
    mov %rsp, %rbp # move current stack frame address to frame pointer
                   # enter function

    lea input_format(%rip), %rdi    
    lea number(%rip), %rsi          
    xor %eax, %eax
    call scanf@plt  
        
    mov number(%rip), %rsi  
    inc %rsi               

    lea output_format(%rip), %rdi
    xor %eax, %eax
    call printf@plt

#leave
    # equivalent to 
    mov %rbp, %rsp # undo the steps from above
    pop %rbp

    xor %eax, %eax
    ret
