.section .data
msg: .string "Test string\n"
msg_len: .int 0xD

.section .text
.global main
main:

    mov     $0x1,           %rax    # determine type of syscall - write
    mov     $0x1,           %rdi    # set output location - std out (terminal)
    lea     msg(%rip),      %rsi    # set variable as source
    mov     msg_len(%rip),  %rdx    # set size of the message
    syscall                         # call write on msg, to stdout, msg_size bytes

    xor     %eax,           %eax    # set return value 0
    ret                             # return
