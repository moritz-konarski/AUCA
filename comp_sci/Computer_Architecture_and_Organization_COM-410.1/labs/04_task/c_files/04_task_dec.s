	.file	"04_task_dec.c"
	.text
	.section	.rodata
.LC0:
	.string	"%ld"
	.section	.data.rel.local,"aw",@progbits
	.align 4
	.type	input_format, @object
	.size	input_format, 4
input_format:
	.long	.LC0
	.section	.rodata
.LC1:
	.string	"%ld\n"
	.section	.data.rel.local
	.align 4
	.type	output_format, @object
	.size	output_format, 4
output_format:
	.long	.LC1
	.local	number
	.comm	number,4,4
	.text
	.globl	main
	.type	main, @function
main:
.LFB0:
	.cfi_startproc
	leal	4(%esp), %ecx
	.cfi_def_cfa 1, 0
	andl	$-16, %esp
	pushl	-4(%ecx)
	pushl	%ebp
	.cfi_escape 0x10,0x5,0x2,0x75,0
	movl	%esp, %ebp
	pushl	%ebx
	pushl	%ecx
	.cfi_escape 0xf,0x3,0x75,0x78,0x6
	.cfi_escape 0x10,0x3,0x2,0x75,0x7c
	call	__x86.get_pc_thunk.bx
	addl	$_GLOBAL_OFFSET_TABLE_, %ebx
	movl	input_format@GOTOFF(%ebx), %eax
	subl	$8, %esp
	leal	number@GOTOFF(%ebx), %edx
	pushl	%edx
	pushl	%eax
	call	__isoc99_scanf@PLT
	addl	$16, %esp
	movl	number@GOTOFF(%ebx), %eax
	subl	$1, %eax
	movl	%eax, number@GOTOFF(%ebx)
	movl	number@GOTOFF(%ebx), %edx
	movl	output_format@GOTOFF(%ebx), %eax
	subl	$8, %esp
	pushl	%edx
	pushl	%eax
	call	printf@PLT
	addl	$16, %esp
	movl	$0, %eax
	leal	-8(%ebp), %esp
	popl	%ecx
	.cfi_restore 1
	.cfi_def_cfa 1, 0
	popl	%ebx
	.cfi_restore 3
	popl	%ebp
	.cfi_restore 5
	leal	-4(%ecx), %esp
	.cfi_def_cfa 4, 4
	ret
	.cfi_endproc
.LFE0:
	.size	main, .-main
	.section	.text.__x86.get_pc_thunk.bx,"axG",@progbits,__x86.get_pc_thunk.bx,comdat
	.globl	__x86.get_pc_thunk.bx
	.hidden	__x86.get_pc_thunk.bx
	.type	__x86.get_pc_thunk.bx, @function
__x86.get_pc_thunk.bx:
.LFB1:
	.cfi_startproc
	movl	(%esp), %ebx
	ret
	.cfi_endproc
.LFE1:
	.ident	"GCC: (Ubuntu 7.4.0-1ubuntu1~18.04.1) 7.4.0"
	.section	.note.GNU-stack,"",@progbits
