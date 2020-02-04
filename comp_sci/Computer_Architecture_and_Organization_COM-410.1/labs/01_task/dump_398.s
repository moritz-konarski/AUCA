
./01_task:     file format elf64-x86-64


Disassembly of section .interp:

0000000000000238 <.interp>:
 238:	2f                   	(bad)  
 239:	6c                   	insb   (%dx),%es:(%rdi)
 23a:	69 62 36 34 2f 6c 64 	imul   $0x646c2f34,0x36(%rdx),%esp
 241:	2d 6c 69 6e 75       	sub    $0x756e696c,%eax
 246:	78 2d                	js     275 <_init-0x273>
 248:	78 38                	js     282 <_init-0x266>
 24a:	36 2d 36 34 2e 73    	ss sub $0x732e3436,%eax
 250:	6f                   	outsl  %ds:(%rsi),(%dx)
 251:	2e 32 00             	xor    %cs:(%rax),%al

Disassembly of section .note.ABI-tag:

0000000000000254 <.note.ABI-tag>:
 254:	04 00                	add    $0x0,%al
 256:	00 00                	add    %al,(%rax)
 258:	10 00                	adc    %al,(%rax)
 25a:	00 00                	add    %al,(%rax)
 25c:	01 00                	add    %eax,(%rax)
 25e:	00 00                	add    %al,(%rax)
 260:	47                   	rex.RXB
 261:	4e 55                	rex.WRX push %rbp
 263:	00 00                	add    %al,(%rax)
 265:	00 00                	add    %al,(%rax)
 267:	00 03                	add    %al,(%rbx)
 269:	00 00                	add    %al,(%rax)
 26b:	00 02                	add    %al,(%rdx)
 26d:	00 00                	add    %al,(%rax)
 26f:	00 00                	add    %al,(%rax)
 271:	00 00                	add    %al,(%rax)
	...

Disassembly of section .note.gnu.build-id:

0000000000000274 <.note.gnu.build-id>:
 274:	04 00                	add    $0x0,%al
 276:	00 00                	add    %al,(%rax)
 278:	14 00                	adc    $0x0,%al
 27a:	00 00                	add    %al,(%rax)
 27c:	03 00                	add    (%rax),%eax
 27e:	00 00                	add    %al,(%rax)
 280:	47                   	rex.RXB
 281:	4e 55                	rex.WRX push %rbp
 283:	00 04 bf             	add    %al,(%rdi,%rdi,4)
 286:	4f a8 56             	rex.WRXB test $0x56,%al
 289:	93                   	xchg   %eax,%ebx
 28a:	16                   	(bad)  
 28b:	40 c0 a2 11 8f c2 7c 	rex shlb $0xd,0x7cc28f11(%rdx)
 292:	0d 
 293:	fc                   	cld    
 294:	2a 3e                	sub    (%rsi),%bh
 296:	6d                   	insl   (%dx),%es:(%rdi)
	...

Disassembly of section .gnu.hash:

0000000000000298 <.gnu.hash>:
 298:	01 00                	add    %eax,(%rax)
 29a:	00 00                	add    %al,(%rax)
 29c:	01 00                	add    %eax,(%rax)
 29e:	00 00                	add    %al,(%rax)
 2a0:	01 00                	add    %eax,(%rax)
	...

Disassembly of section .dynsym:

00000000000002b8 <.dynsym>:
	...
 2d0:	3d 00 00 00 20       	cmp    $0x20000000,%eax
	...
 2e5:	00 00                	add    %al,(%rax)
 2e7:	00 0b                	add    %cl,(%rbx)
 2e9:	00 00                	add    %al,(%rax)
 2eb:	00 12                	add    %dl,(%rdx)
	...
 2fd:	00 00                	add    %al,(%rax)
 2ff:	00 1f                	add    %bl,(%rdi)
 301:	00 00                	add    %al,(%rax)
 303:	00 12                	add    %dl,(%rdx)
	...
 315:	00 00                	add    %al,(%rax)
 317:	00 59 00             	add    %bl,0x0(%rcx)
 31a:	00 00                	add    %al,(%rax)
 31c:	20 00                	and    %al,(%rax)
	...
 32e:	00 00                	add    %al,(%rax)
 330:	68 00 00 00 20       	pushq  $0x20000000
	...
 345:	00 00                	add    %al,(%rax)
 347:	00 10                	add    %dl,(%rax)
 349:	00 00                	add    %al,(%rax)
 34b:	00 22                	add    %ah,(%rdx)
	...

Disassembly of section .dynstr:

0000000000000360 <.dynstr>:
 360:	00 6c 69 62          	add    %ch,0x62(%rcx,%rbp,2)
 364:	63 2e                	movslq (%rsi),%ebp
 366:	73 6f                	jae    3d7 <_init-0x111>
 368:	2e 36 00 70 75       	cs add %dh,%ss:0x75(%rax)
 36d:	74 73                	je     3e2 <_init-0x106>
 36f:	00 5f 5f             	add    %bl,0x5f(%rdi)
 372:	63 78 61             	movslq 0x61(%rax),%edi
 375:	5f                   	pop    %rdi
 376:	66 69 6e 61 6c 69    	imul   $0x696c,0x61(%rsi),%bp
 37c:	7a 65                	jp     3e3 <_init-0x105>
 37e:	00 5f 5f             	add    %bl,0x5f(%rdi)
 381:	6c                   	insb   (%dx),%es:(%rdi)
 382:	69 62 63 5f 73 74 61 	imul   $0x6174735f,0x63(%rdx),%esp
 389:	72 74                	jb     3ff <_init-0xe9>
 38b:	5f                   	pop    %rdi
 38c:	6d                   	insl   (%dx),%es:(%rdi)
 38d:	61                   	(bad)  
 38e:	69 6e 00 47 4c 49 42 	imul   $0x42494c47,0x0(%rsi),%ebp
 395:	43 5f                	rex.XB pop %r15
 397:	32 2e                	xor    (%rsi),%ch
 399:	32 2e                	xor    (%rsi),%ch
 39b:	35 00 5f 49 54       	xor    $0x54495f00,%eax
 3a0:	4d 5f                	rex.WRB pop %r15
 3a2:	64 65 72 65          	fs gs jb 40b <_init-0xdd>
 3a6:	67 69 73 74 65 72 54 	imul   $0x4d547265,0x74(%ebx),%esi
 3ad:	4d 
 3ae:	43 6c                	rex.XB insb (%dx),%es:(%rdi)
 3b0:	6f                   	outsl  %ds:(%rsi),(%dx)
 3b1:	6e                   	outsb  %ds:(%rsi),(%dx)
 3b2:	65 54                	gs push %rsp
 3b4:	61                   	(bad)  
 3b5:	62                   	(bad)  
 3b6:	6c                   	insb   (%dx),%es:(%rdi)
 3b7:	65 00 5f 5f          	add    %bl,%gs:0x5f(%rdi)
 3bb:	67 6d                	insl   (%dx),%es:(%edi)
 3bd:	6f                   	outsl  %ds:(%rsi),(%dx)
 3be:	6e                   	outsb  %ds:(%rsi),(%dx)
 3bf:	5f                   	pop    %rdi
 3c0:	73 74                	jae    436 <_init-0xb2>
 3c2:	61                   	(bad)  
 3c3:	72 74                	jb     439 <_init-0xaf>
 3c5:	5f                   	pop    %rdi
 3c6:	5f                   	pop    %rdi
 3c7:	00 5f 49             	add    %bl,0x49(%rdi)
 3ca:	54                   	push   %rsp
 3cb:	4d 5f                	rex.WRB pop %r15
 3cd:	72 65                	jb     434 <_init-0xb4>
 3cf:	67 69 73 74 65 72 54 	imul   $0x4d547265,0x74(%ebx),%esi
 3d6:	4d 
 3d7:	43 6c                	rex.XB insb (%dx),%es:(%rdi)
 3d9:	6f                   	outsl  %ds:(%rsi),(%dx)
 3da:	6e                   	outsb  %ds:(%rsi),(%dx)
 3db:	65 54                	gs push %rsp
 3dd:	61                   	(bad)  
 3de:	62                   	.byte 0x62
 3df:	6c                   	insb   (%dx),%es:(%rdi)
 3e0:	65                   	gs
	...

Disassembly of section .gnu.version:

00000000000003e2 <.gnu.version>:
 3e2:	00 00                	add    %al,(%rax)
 3e4:	00 00                	add    %al,(%rax)
 3e6:	02 00                	add    (%rax),%al
 3e8:	02 00                	add    (%rax),%al
 3ea:	00 00                	add    %al,(%rax)
 3ec:	00 00                	add    %al,(%rax)
 3ee:	02 00                	add    (%rax),%al

Disassembly of section .gnu.version_r:

00000000000003f0 <.gnu.version_r>:
 3f0:	01 00                	add    %eax,(%rax)
 3f2:	01 00                	add    %eax,(%rax)
 3f4:	01 00                	add    %eax,(%rax)
 3f6:	00 00                	add    %al,(%rax)
 3f8:	10 00                	adc    %al,(%rax)
 3fa:	00 00                	add    %al,(%rax)
 3fc:	00 00                	add    %al,(%rax)
 3fe:	00 00                	add    %al,(%rax)
 400:	75 1a                	jne    41c <_init-0xcc>
 402:	69 09 00 00 02 00    	imul   $0x20000,(%rcx),%ecx
 408:	31 00                	xor    %eax,(%rax)
 40a:	00 00                	add    %al,(%rax)
 40c:	00 00                	add    %al,(%rax)
	...

Disassembly of section .rela.dyn:

0000000000000410 <.rela.dyn>:
 410:	b8 0d 20 00 00       	mov    $0x200d,%eax
 415:	00 00                	add    %al,(%rax)
 417:	00 08                	add    %cl,(%rax)
 419:	00 00                	add    %al,(%rax)
 41b:	00 00                	add    %al,(%rax)
 41d:	00 00                	add    %al,(%rax)
 41f:	00 30                	add    %dh,(%rax)
 421:	06                   	(bad)  
 422:	00 00                	add    %al,(%rax)
 424:	00 00                	add    %al,(%rax)
 426:	00 00                	add    %al,(%rax)
 428:	c0 0d 20 00 00 00 00 	rorb   $0x0,0x20(%rip)        # 44f <_init-0x99>
 42f:	00 08                	add    %cl,(%rax)
 431:	00 00                	add    %al,(%rax)
 433:	00 00                	add    %al,(%rax)
 435:	00 00                	add    %al,(%rax)
 437:	00 f0                	add    %dh,%al
 439:	05 00 00 00 00       	add    $0x0,%eax
 43e:	00 00                	add    %al,(%rax)
 440:	08 10                	or     %dl,(%rax)
 442:	20 00                	and    %al,(%rax)
 444:	00 00                	add    %al,(%rax)
 446:	00 00                	add    %al,(%rax)
 448:	08 00                	or     %al,(%rax)
 44a:	00 00                	add    %al,(%rax)
 44c:	00 00                	add    %al,(%rax)
 44e:	00 00                	add    %al,(%rax)
 450:	08 10                	or     %dl,(%rax)
 452:	20 00                	and    %al,(%rax)
 454:	00 00                	add    %al,(%rax)
 456:	00 00                	add    %al,(%rax)
 458:	d8 0f                	fmuls  (%rdi)
 45a:	20 00                	and    %al,(%rax)
 45c:	00 00                	add    %al,(%rax)
 45e:	00 00                	add    %al,(%rax)
 460:	06                   	(bad)  
 461:	00 00                	add    %al,(%rax)
 463:	00 01                	add    %al,(%rcx)
	...
 46d:	00 00                	add    %al,(%rax)
 46f:	00 e0                	add    %ah,%al
 471:	0f 20 00             	mov    %cr0,%rax
 474:	00 00                	add    %al,(%rax)
 476:	00 00                	add    %al,(%rax)
 478:	06                   	(bad)  
 479:	00 00                	add    %al,(%rax)
 47b:	00 03                	add    %al,(%rbx)
	...
 485:	00 00                	add    %al,(%rax)
 487:	00 e8                	add    %ch,%al
 489:	0f 20 00             	mov    %cr0,%rax
 48c:	00 00                	add    %al,(%rax)
 48e:	00 00                	add    %al,(%rax)
 490:	06                   	(bad)  
 491:	00 00                	add    %al,(%rax)
 493:	00 04 00             	add    %al,(%rax,%rax,1)
	...
 49e:	00 00                	add    %al,(%rax)
 4a0:	f0 0f 20 00          	lock mov %cr0,%rax
 4a4:	00 00                	add    %al,(%rax)
 4a6:	00 00                	add    %al,(%rax)
 4a8:	06                   	(bad)  
 4a9:	00 00                	add    %al,(%rax)
 4ab:	00 05 00 00 00 00    	add    %al,0x0(%rip)        # 4b1 <_init-0x37>
 4b1:	00 00                	add    %al,(%rax)
 4b3:	00 00                	add    %al,(%rax)
 4b5:	00 00                	add    %al,(%rax)
 4b7:	00 f8                	add    %bh,%al
 4b9:	0f 20 00             	mov    %cr0,%rax
 4bc:	00 00                	add    %al,(%rax)
 4be:	00 00                	add    %al,(%rax)
 4c0:	06                   	(bad)  
 4c1:	00 00                	add    %al,(%rax)
 4c3:	00 06                	add    %al,(%rsi)
	...

Disassembly of section .rela.plt:

00000000000004d0 <.rela.plt>:
 4d0:	d0 0f                	rorb   (%rdi)
 4d2:	20 00                	and    %al,(%rax)
 4d4:	00 00                	add    %al,(%rax)
 4d6:	00 00                	add    %al,(%rax)
 4d8:	07                   	(bad)  
 4d9:	00 00                	add    %al,(%rax)
 4db:	00 02                	add    %al,(%rdx)
	...

Disassembly of section .init:

00000000000004e8 <_init>:
 4e8:	48 83 ec 08          	sub    $0x8,%rsp
 4ec:	48 8b 05 f5 0a 20 00 	mov    0x200af5(%rip),%rax        # 200fe8 <__gmon_start__>
 4f3:	48 85 c0             	test   %rax,%rax
 4f6:	74 02                	je     4fa <_init+0x12>
 4f8:	ff d0                	callq  *%rax
 4fa:	48 83 c4 08          	add    $0x8,%rsp
 4fe:	c3                   	retq   

Disassembly of section .plt:

0000000000000500 <.plt>:
 500:	ff 35 ba 0a 20 00    	pushq  0x200aba(%rip)        # 200fc0 <_GLOBAL_OFFSET_TABLE_+0x8>
 506:	ff 25 bc 0a 20 00    	jmpq   *0x200abc(%rip)        # 200fc8 <_GLOBAL_OFFSET_TABLE_+0x10>
 50c:	0f 1f 40 00          	nopl   0x0(%rax)

0000000000000510 <puts@plt>:
 510:	ff 25 ba 0a 20 00    	jmpq   *0x200aba(%rip)        # 200fd0 <puts@GLIBC_2.2.5>
 516:	68 00 00 00 00       	pushq  $0x0
 51b:	e9 e0 ff ff ff       	jmpq   500 <.plt>

Disassembly of section .plt.got:

0000000000000520 <__cxa_finalize@plt>:
 520:	ff 25 d2 0a 20 00    	jmpq   *0x200ad2(%rip)        # 200ff8 <__cxa_finalize@GLIBC_2.2.5>
 526:	66 90                	xchg   %ax,%ax

Disassembly of section .text:

0000000000000530 <_start>:
 530:	31 ed                	xor    %ebp,%ebp
 532:	49 89 d1             	mov    %rdx,%r9
 535:	5e                   	pop    %rsi
 536:	48 89 e2             	mov    %rsp,%rdx
 539:	48 83 e4 f0          	and    $0xfffffffffffffff0,%rsp
 53d:	50                   	push   %rax
 53e:	54                   	push   %rsp
 53f:	4c 8d 05 8a 01 00 00 	lea    0x18a(%rip),%r8        # 6d0 <__libc_csu_fini>
 546:	48 8d 0d 13 01 00 00 	lea    0x113(%rip),%rcx        # 660 <__libc_csu_init>
 54d:	48 8d 3d e6 00 00 00 	lea    0xe6(%rip),%rdi        # 63a <main>
 554:	ff 15 86 0a 20 00    	callq  *0x200a86(%rip)        # 200fe0 <__libc_start_main@GLIBC_2.2.5>
 55a:	f4                   	hlt    
 55b:	0f 1f 44 00 00       	nopl   0x0(%rax,%rax,1)

0000000000000560 <deregister_tm_clones>:
 560:	48 8d 3d a9 0a 20 00 	lea    0x200aa9(%rip),%rdi        # 201010 <__TMC_END__>
 567:	55                   	push   %rbp
 568:	48 8d 05 a1 0a 20 00 	lea    0x200aa1(%rip),%rax        # 201010 <__TMC_END__>
 56f:	48 39 f8             	cmp    %rdi,%rax
 572:	48 89 e5             	mov    %rsp,%rbp
 575:	74 19                	je     590 <deregister_tm_clones+0x30>
 577:	48 8b 05 5a 0a 20 00 	mov    0x200a5a(%rip),%rax        # 200fd8 <_ITM_deregisterTMCloneTable>
 57e:	48 85 c0             	test   %rax,%rax
 581:	74 0d                	je     590 <deregister_tm_clones+0x30>
 583:	5d                   	pop    %rbp
 584:	ff e0                	jmpq   *%rax
 586:	66 2e 0f 1f 84 00 00 	nopw   %cs:0x0(%rax,%rax,1)
 58d:	00 00 00 
 590:	5d                   	pop    %rbp
 591:	c3                   	retq   
 592:	0f 1f 40 00          	nopl   0x0(%rax)
 596:	66 2e 0f 1f 84 00 00 	nopw   %cs:0x0(%rax,%rax,1)
 59d:	00 00 00 

00000000000005a0 <register_tm_clones>:
 5a0:	48 8d 3d 69 0a 20 00 	lea    0x200a69(%rip),%rdi        # 201010 <__TMC_END__>
 5a7:	48 8d 35 62 0a 20 00 	lea    0x200a62(%rip),%rsi        # 201010 <__TMC_END__>
 5ae:	55                   	push   %rbp
 5af:	48 29 fe             	sub    %rdi,%rsi
 5b2:	48 89 e5             	mov    %rsp,%rbp
 5b5:	48 c1 fe 03          	sar    $0x3,%rsi
 5b9:	48 89 f0             	mov    %rsi,%rax
 5bc:	48 c1 e8 3f          	shr    $0x3f,%rax
 5c0:	48 01 c6             	add    %rax,%rsi
 5c3:	48 d1 fe             	sar    %rsi
 5c6:	74 18                	je     5e0 <register_tm_clones+0x40>
 5c8:	48 8b 05 21 0a 20 00 	mov    0x200a21(%rip),%rax        # 200ff0 <_ITM_registerTMCloneTable>
 5cf:	48 85 c0             	test   %rax,%rax
 5d2:	74 0c                	je     5e0 <register_tm_clones+0x40>
 5d4:	5d                   	pop    %rbp
 5d5:	ff e0                	jmpq   *%rax
 5d7:	66 0f 1f 84 00 00 00 	nopw   0x0(%rax,%rax,1)
 5de:	00 00 
 5e0:	5d                   	pop    %rbp
 5e1:	c3                   	retq   
 5e2:	0f 1f 40 00          	nopl   0x0(%rax)
 5e6:	66 2e 0f 1f 84 00 00 	nopw   %cs:0x0(%rax,%rax,1)
 5ed:	00 00 00 

00000000000005f0 <__do_global_dtors_aux>:
 5f0:	80 3d 19 0a 20 00 00 	cmpb   $0x0,0x200a19(%rip)        # 201010 <__TMC_END__>
 5f7:	75 2f                	jne    628 <__do_global_dtors_aux+0x38>
 5f9:	48 83 3d f7 09 20 00 	cmpq   $0x0,0x2009f7(%rip)        # 200ff8 <__cxa_finalize@GLIBC_2.2.5>
 600:	00 
 601:	55                   	push   %rbp
 602:	48 89 e5             	mov    %rsp,%rbp
 605:	74 0c                	je     613 <__do_global_dtors_aux+0x23>
 607:	48 8b 3d fa 09 20 00 	mov    0x2009fa(%rip),%rdi        # 201008 <__dso_handle>
 60e:	e8 0d ff ff ff       	callq  520 <__cxa_finalize@plt>
 613:	e8 48 ff ff ff       	callq  560 <deregister_tm_clones>
 618:	c6 05 f1 09 20 00 01 	movb   $0x1,0x2009f1(%rip)        # 201010 <__TMC_END__>
 61f:	5d                   	pop    %rbp
 620:	c3                   	retq   
 621:	0f 1f 80 00 00 00 00 	nopl   0x0(%rax)
 628:	f3 c3                	repz retq 
 62a:	66 0f 1f 44 00 00    	nopw   0x0(%rax,%rax,1)

0000000000000630 <frame_dummy>:
 630:	55                   	push   %rbp
 631:	48 89 e5             	mov    %rsp,%rbp
 634:	5d                   	pop    %rbp
 635:	e9 66 ff ff ff       	jmpq   5a0 <register_tm_clones>

000000000000063a <main>:
 63a:	55                   	push   %rbp
 63b:	48 89 e5             	mov    %rsp,%rbp
 63e:	48 83 ec 10          	sub    $0x10,%rsp
 642:	89 7d fc             	mov    %edi,-0x4(%rbp)
 645:	48 89 75 f0          	mov    %rsi,-0x10(%rbp)
 649:	48 8d 3d 94 00 00 00 	lea    0x94(%rip),%rdi        # 6e4 <_IO_stdin_used+0x4>
 650:	e8 bb fe ff ff       	callq  510 <puts@plt>
 655:	b8 00 00 00 00       	mov    $0x0,%eax
 65a:	c9                   	leaveq 
 65b:	c3                   	retq   
 65c:	0f 1f 40 00          	nopl   0x0(%rax)

0000000000000660 <__libc_csu_init>:
 660:	41 57                	push   %r15
 662:	41 56                	push   %r14
 664:	49 89 d7             	mov    %rdx,%r15
 667:	41 55                	push   %r13
 669:	41 54                	push   %r12
 66b:	4c 8d 25 46 07 20 00 	lea    0x200746(%rip),%r12        # 200db8 <__frame_dummy_init_array_entry>
 672:	55                   	push   %rbp
 673:	48 8d 2d 46 07 20 00 	lea    0x200746(%rip),%rbp        # 200dc0 <__init_array_end>
 67a:	53                   	push   %rbx
 67b:	41 89 fd             	mov    %edi,%r13d
 67e:	49 89 f6             	mov    %rsi,%r14
 681:	4c 29 e5             	sub    %r12,%rbp
 684:	48 83 ec 08          	sub    $0x8,%rsp
 688:	48 c1 fd 03          	sar    $0x3,%rbp
 68c:	e8 57 fe ff ff       	callq  4e8 <_init>
 691:	48 85 ed             	test   %rbp,%rbp
 694:	74 20                	je     6b6 <__libc_csu_init+0x56>
 696:	31 db                	xor    %ebx,%ebx
 698:	0f 1f 84 00 00 00 00 	nopl   0x0(%rax,%rax,1)
 69f:	00 
 6a0:	4c 89 fa             	mov    %r15,%rdx
 6a3:	4c 89 f6             	mov    %r14,%rsi
 6a6:	44 89 ef             	mov    %r13d,%edi
 6a9:	41 ff 14 dc          	callq  *(%r12,%rbx,8)
 6ad:	48 83 c3 01          	add    $0x1,%rbx
 6b1:	48 39 dd             	cmp    %rbx,%rbp
 6b4:	75 ea                	jne    6a0 <__libc_csu_init+0x40>
 6b6:	48 83 c4 08          	add    $0x8,%rsp
 6ba:	5b                   	pop    %rbx
 6bb:	5d                   	pop    %rbp
 6bc:	41 5c                	pop    %r12
 6be:	41 5d                	pop    %r13
 6c0:	41 5e                	pop    %r14
 6c2:	41 5f                	pop    %r15
 6c4:	c3                   	retq   
 6c5:	90                   	nop
 6c6:	66 2e 0f 1f 84 00 00 	nopw   %cs:0x0(%rax,%rax,1)
 6cd:	00 00 00 

00000000000006d0 <__libc_csu_fini>:
 6d0:	f3 c3                	repz retq 

Disassembly of section .fini:

00000000000006d4 <_fini>:
 6d4:	48 83 ec 08          	sub    $0x8,%rsp
 6d8:	48 83 c4 08          	add    $0x8,%rsp
 6dc:	c3                   	retq   

Disassembly of section .rodata:

00000000000006e0 <_IO_stdin_used>:
 6e0:	01 00                	add    %eax,(%rax)
 6e2:	02 00                	add    (%rax),%al
 6e4:	48                   	rex.W
 6e5:	65 6c                	gs insb (%dx),%es:(%rdi)
 6e7:	6c                   	insb   (%dx),%es:(%rdi)
 6e8:	6f                   	outsl  %ds:(%rsi),(%dx)
 6e9:	2c 20                	sub    $0x20,%al
 6eb:	57                   	push   %rdi
 6ec:	6f                   	outsl  %ds:(%rsi),(%dx)
 6ed:	72 6c                	jb     75b <__GNU_EH_FRAME_HDR+0x67>
 6ef:	64 21 0a             	and    %ecx,%fs:(%rdx)
	...

Disassembly of section .eh_frame_hdr:

00000000000006f4 <__GNU_EH_FRAME_HDR>:
 6f4:	01 1b                	add    %ebx,(%rbx)
 6f6:	03 3b                	add    (%rbx),%edi
 6f8:	38 00                	cmp    %al,(%rax)
 6fa:	00 00                	add    %al,(%rax)
 6fc:	06                   	(bad)  
 6fd:	00 00                	add    %al,(%rax)
 6ff:	00 0c fe             	add    %cl,(%rsi,%rdi,8)
 702:	ff                   	(bad)  
 703:	ff 84 00 00 00 2c fe 	incl   -0x1d40000(%rax,%rax,1)
 70a:	ff                   	(bad)  
 70b:	ff ac 00 00 00 3c fe 	ljmp   *-0x1c40000(%rax,%rax,1)
 712:	ff                   	(bad)  
 713:	ff 54 00 00          	callq  *0x0(%rax,%rax,1)
 717:	00 46 ff             	add    %al,-0x1(%rsi)
 71a:	ff                   	(bad)  
 71b:	ff c4                	inc    %esp
 71d:	00 00                	add    %al,(%rax)
 71f:	00 6c ff ff          	add    %ch,-0x1(%rdi,%rdi,8)
 723:	ff e4                	jmpq   *%rsp
 725:	00 00                	add    %al,(%rax)
 727:	00 dc                	add    %bl,%ah
 729:	ff                   	(bad)  
 72a:	ff                   	(bad)  
 72b:	ff 2c 01             	ljmp   *(%rcx,%rax,1)
	...

Disassembly of section .eh_frame:

0000000000000730 <__FRAME_END__-0x104>:
 730:	14 00                	adc    $0x0,%al
 732:	00 00                	add    %al,(%rax)
 734:	00 00                	add    %al,(%rax)
 736:	00 00                	add    %al,(%rax)
 738:	01 7a 52             	add    %edi,0x52(%rdx)
 73b:	00 01                	add    %al,(%rcx)
 73d:	78 10                	js     74f <__GNU_EH_FRAME_HDR+0x5b>
 73f:	01 1b                	add    %ebx,(%rbx)
 741:	0c 07                	or     $0x7,%al
 743:	08 90 01 07 10 14    	or     %dl,0x14100701(%rax)
 749:	00 00                	add    %al,(%rax)
 74b:	00 1c 00             	add    %bl,(%rax,%rax,1)
 74e:	00 00                	add    %al,(%rax)
 750:	e0 fd                	loopne 74f <__GNU_EH_FRAME_HDR+0x5b>
 752:	ff                   	(bad)  
 753:	ff 2b                	ljmp   *(%rbx)
	...
 75d:	00 00                	add    %al,(%rax)
 75f:	00 14 00             	add    %dl,(%rax,%rax,1)
 762:	00 00                	add    %al,(%rax)
 764:	00 00                	add    %al,(%rax)
 766:	00 00                	add    %al,(%rax)
 768:	01 7a 52             	add    %edi,0x52(%rdx)
 76b:	00 01                	add    %al,(%rcx)
 76d:	78 10                	js     77f <__GNU_EH_FRAME_HDR+0x8b>
 76f:	01 1b                	add    %ebx,(%rbx)
 771:	0c 07                	or     $0x7,%al
 773:	08 90 01 00 00 24    	or     %dl,0x24000001(%rax)
 779:	00 00                	add    %al,(%rax)
 77b:	00 1c 00             	add    %bl,(%rax,%rax,1)
 77e:	00 00                	add    %al,(%rax)
 780:	80 fd ff             	cmp    $0xff,%ch
 783:	ff 20                	jmpq   *(%rax)
 785:	00 00                	add    %al,(%rax)
 787:	00 00                	add    %al,(%rax)
 789:	0e                   	(bad)  
 78a:	10 46 0e             	adc    %al,0xe(%rsi)
 78d:	18 4a 0f             	sbb    %cl,0xf(%rdx)
 790:	0b 77 08             	or     0x8(%rdi),%esi
 793:	80 00 3f             	addb   $0x3f,(%rax)
 796:	1a 3b                	sbb    (%rbx),%bh
 798:	2a 33                	sub    (%rbx),%dh
 79a:	24 22                	and    $0x22,%al
 79c:	00 00                	add    %al,(%rax)
 79e:	00 00                	add    %al,(%rax)
 7a0:	14 00                	adc    $0x0,%al
 7a2:	00 00                	add    %al,(%rax)
 7a4:	44 00 00             	add    %r8b,(%rax)
 7a7:	00 78 fd             	add    %bh,-0x3(%rax)
 7aa:	ff                   	(bad)  
 7ab:	ff 08                	decl   (%rax)
	...
 7b5:	00 00                	add    %al,(%rax)
 7b7:	00 1c 00             	add    %bl,(%rax,%rax,1)
 7ba:	00 00                	add    %al,(%rax)
 7bc:	5c                   	pop    %rsp
 7bd:	00 00                	add    %al,(%rax)
 7bf:	00 7a fe             	add    %bh,-0x2(%rdx)
 7c2:	ff                   	(bad)  
 7c3:	ff 22                	jmpq   *(%rdx)
 7c5:	00 00                	add    %al,(%rax)
 7c7:	00 00                	add    %al,(%rax)
 7c9:	41 0e                	rex.B (bad) 
 7cb:	10 86 02 43 0d 06    	adc    %al,0x60d4302(%rsi)
 7d1:	5d                   	pop    %rbp
 7d2:	0c 07                	or     $0x7,%al
 7d4:	08 00                	or     %al,(%rax)
 7d6:	00 00                	add    %al,(%rax)
 7d8:	44 00 00             	add    %r8b,(%rax)
 7db:	00 7c 00 00          	add    %bh,0x0(%rax,%rax,1)
 7df:	00 80 fe ff ff 65    	add    %al,0x65fffffe(%rax)
 7e5:	00 00                	add    %al,(%rax)
 7e7:	00 00                	add    %al,(%rax)
 7e9:	42 0e                	rex.X (bad) 
 7eb:	10 8f 02 42 0e 18    	adc    %cl,0x180e4202(%rdi)
 7f1:	8e 03                	mov    (%rbx),%es
 7f3:	45 0e                	rex.RB (bad) 
 7f5:	20 8d 04 42 0e 28    	and    %cl,0x280e4204(%rbp)
 7fb:	8c 05 48 0e 30 86    	mov    %es,-0x79cff1b8(%rip)        # ffffffff86301649 <_end+0xffffffff86100631>
 801:	06                   	(bad)  
 802:	48 0e                	rex.W (bad) 
 804:	38 83 07 4d 0e 40    	cmp    %al,0x400e4d07(%rbx)
 80a:	72 0e                	jb     81a <__GNU_EH_FRAME_HDR+0x126>
 80c:	38 41 0e             	cmp    %al,0xe(%rcx)
 80f:	30 41 0e             	xor    %al,0xe(%rcx)
 812:	28 42 0e             	sub    %al,0xe(%rdx)
 815:	20 42 0e             	and    %al,0xe(%rdx)
 818:	18 42 0e             	sbb    %al,0xe(%rdx)
 81b:	10 42 0e             	adc    %al,0xe(%rdx)
 81e:	08 00                	or     %al,(%rax)
 820:	10 00                	adc    %al,(%rax)
 822:	00 00                	add    %al,(%rax)
 824:	c4                   	(bad)  
 825:	00 00                	add    %al,(%rax)
 827:	00 a8 fe ff ff 02    	add    %ch,0x2fffffe(%rax)
 82d:	00 00                	add    %al,(%rax)
 82f:	00 00                	add    %al,(%rax)
 831:	00 00                	add    %al,(%rax)
	...

0000000000000834 <__FRAME_END__>:
 834:	00 00                	add    %al,(%rax)
	...

Disassembly of section .init_array:

0000000000200db8 <__frame_dummy_init_array_entry>:
  200db8:	30 06                	xor    %al,(%rsi)
  200dba:	00 00                	add    %al,(%rax)
  200dbc:	00 00                	add    %al,(%rax)
	...

Disassembly of section .fini_array:

0000000000200dc0 <__do_global_dtors_aux_fini_array_entry>:
  200dc0:	f0 05 00 00 00 00    	lock add $0x0,%eax
	...

Disassembly of section .dynamic:

0000000000200dc8 <_DYNAMIC>:
  200dc8:	01 00                	add    %eax,(%rax)
  200dca:	00 00                	add    %al,(%rax)
  200dcc:	00 00                	add    %al,(%rax)
  200dce:	00 00                	add    %al,(%rax)
  200dd0:	01 00                	add    %eax,(%rax)
  200dd2:	00 00                	add    %al,(%rax)
  200dd4:	00 00                	add    %al,(%rax)
  200dd6:	00 00                	add    %al,(%rax)
  200dd8:	0c 00                	or     $0x0,%al
  200dda:	00 00                	add    %al,(%rax)
  200ddc:	00 00                	add    %al,(%rax)
  200dde:	00 00                	add    %al,(%rax)
  200de0:	e8 04 00 00 00       	callq  200de9 <_DYNAMIC+0x21>
  200de5:	00 00                	add    %al,(%rax)
  200de7:	00 0d 00 00 00 00    	add    %cl,0x0(%rip)        # 200ded <_DYNAMIC+0x25>
  200ded:	00 00                	add    %al,(%rax)
  200def:	00 d4                	add    %dl,%ah
  200df1:	06                   	(bad)  
  200df2:	00 00                	add    %al,(%rax)
  200df4:	00 00                	add    %al,(%rax)
  200df6:	00 00                	add    %al,(%rax)
  200df8:	19 00                	sbb    %eax,(%rax)
  200dfa:	00 00                	add    %al,(%rax)
  200dfc:	00 00                	add    %al,(%rax)
  200dfe:	00 00                	add    %al,(%rax)
  200e00:	b8 0d 20 00 00       	mov    $0x200d,%eax
  200e05:	00 00                	add    %al,(%rax)
  200e07:	00 1b                	add    %bl,(%rbx)
  200e09:	00 00                	add    %al,(%rax)
  200e0b:	00 00                	add    %al,(%rax)
  200e0d:	00 00                	add    %al,(%rax)
  200e0f:	00 08                	add    %cl,(%rax)
  200e11:	00 00                	add    %al,(%rax)
  200e13:	00 00                	add    %al,(%rax)
  200e15:	00 00                	add    %al,(%rax)
  200e17:	00 1a                	add    %bl,(%rdx)
  200e19:	00 00                	add    %al,(%rax)
  200e1b:	00 00                	add    %al,(%rax)
  200e1d:	00 00                	add    %al,(%rax)
  200e1f:	00 c0                	add    %al,%al
  200e21:	0d 20 00 00 00       	or     $0x20,%eax
  200e26:	00 00                	add    %al,(%rax)
  200e28:	1c 00                	sbb    $0x0,%al
  200e2a:	00 00                	add    %al,(%rax)
  200e2c:	00 00                	add    %al,(%rax)
  200e2e:	00 00                	add    %al,(%rax)
  200e30:	08 00                	or     %al,(%rax)
  200e32:	00 00                	add    %al,(%rax)
  200e34:	00 00                	add    %al,(%rax)
  200e36:	00 00                	add    %al,(%rax)
  200e38:	f5                   	cmc    
  200e39:	fe                   	(bad)  
  200e3a:	ff 6f 00             	ljmp   *0x0(%rdi)
  200e3d:	00 00                	add    %al,(%rax)
  200e3f:	00 98 02 00 00 00    	add    %bl,0x2(%rax)
  200e45:	00 00                	add    %al,(%rax)
  200e47:	00 05 00 00 00 00    	add    %al,0x0(%rip)        # 200e4d <_DYNAMIC+0x85>
  200e4d:	00 00                	add    %al,(%rax)
  200e4f:	00 60 03             	add    %ah,0x3(%rax)
  200e52:	00 00                	add    %al,(%rax)
  200e54:	00 00                	add    %al,(%rax)
  200e56:	00 00                	add    %al,(%rax)
  200e58:	06                   	(bad)  
  200e59:	00 00                	add    %al,(%rax)
  200e5b:	00 00                	add    %al,(%rax)
  200e5d:	00 00                	add    %al,(%rax)
  200e5f:	00 b8 02 00 00 00    	add    %bh,0x2(%rax)
  200e65:	00 00                	add    %al,(%rax)
  200e67:	00 0a                	add    %cl,(%rdx)
  200e69:	00 00                	add    %al,(%rax)
  200e6b:	00 00                	add    %al,(%rax)
  200e6d:	00 00                	add    %al,(%rax)
  200e6f:	00 82 00 00 00 00    	add    %al,0x0(%rdx)
  200e75:	00 00                	add    %al,(%rax)
  200e77:	00 0b                	add    %cl,(%rbx)
  200e79:	00 00                	add    %al,(%rax)
  200e7b:	00 00                	add    %al,(%rax)
  200e7d:	00 00                	add    %al,(%rax)
  200e7f:	00 18                	add    %bl,(%rax)
  200e81:	00 00                	add    %al,(%rax)
  200e83:	00 00                	add    %al,(%rax)
  200e85:	00 00                	add    %al,(%rax)
  200e87:	00 15 00 00 00 00    	add    %dl,0x0(%rip)        # 200e8d <_DYNAMIC+0xc5>
	...
  200e95:	00 00                	add    %al,(%rax)
  200e97:	00 03                	add    %al,(%rbx)
  200e99:	00 00                	add    %al,(%rax)
  200e9b:	00 00                	add    %al,(%rax)
  200e9d:	00 00                	add    %al,(%rax)
  200e9f:	00 b8 0f 20 00 00    	add    %bh,0x200f(%rax)
  200ea5:	00 00                	add    %al,(%rax)
  200ea7:	00 02                	add    %al,(%rdx)
  200ea9:	00 00                	add    %al,(%rax)
  200eab:	00 00                	add    %al,(%rax)
  200ead:	00 00                	add    %al,(%rax)
  200eaf:	00 18                	add    %bl,(%rax)
  200eb1:	00 00                	add    %al,(%rax)
  200eb3:	00 00                	add    %al,(%rax)
  200eb5:	00 00                	add    %al,(%rax)
  200eb7:	00 14 00             	add    %dl,(%rax,%rax,1)
  200eba:	00 00                	add    %al,(%rax)
  200ebc:	00 00                	add    %al,(%rax)
  200ebe:	00 00                	add    %al,(%rax)
  200ec0:	07                   	(bad)  
  200ec1:	00 00                	add    %al,(%rax)
  200ec3:	00 00                	add    %al,(%rax)
  200ec5:	00 00                	add    %al,(%rax)
  200ec7:	00 17                	add    %dl,(%rdi)
  200ec9:	00 00                	add    %al,(%rax)
  200ecb:	00 00                	add    %al,(%rax)
  200ecd:	00 00                	add    %al,(%rax)
  200ecf:	00 d0                	add    %dl,%al
  200ed1:	04 00                	add    $0x0,%al
  200ed3:	00 00                	add    %al,(%rax)
  200ed5:	00 00                	add    %al,(%rax)
  200ed7:	00 07                	add    %al,(%rdi)
  200ed9:	00 00                	add    %al,(%rax)
  200edb:	00 00                	add    %al,(%rax)
  200edd:	00 00                	add    %al,(%rax)
  200edf:	00 10                	add    %dl,(%rax)
  200ee1:	04 00                	add    $0x0,%al
  200ee3:	00 00                	add    %al,(%rax)
  200ee5:	00 00                	add    %al,(%rax)
  200ee7:	00 08                	add    %cl,(%rax)
  200ee9:	00 00                	add    %al,(%rax)
  200eeb:	00 00                	add    %al,(%rax)
  200eed:	00 00                	add    %al,(%rax)
  200eef:	00 c0                	add    %al,%al
  200ef1:	00 00                	add    %al,(%rax)
  200ef3:	00 00                	add    %al,(%rax)
  200ef5:	00 00                	add    %al,(%rax)
  200ef7:	00 09                	add    %cl,(%rcx)
  200ef9:	00 00                	add    %al,(%rax)
  200efb:	00 00                	add    %al,(%rax)
  200efd:	00 00                	add    %al,(%rax)
  200eff:	00 18                	add    %bl,(%rax)
  200f01:	00 00                	add    %al,(%rax)
  200f03:	00 00                	add    %al,(%rax)
  200f05:	00 00                	add    %al,(%rax)
  200f07:	00 1e                	add    %bl,(%rsi)
  200f09:	00 00                	add    %al,(%rax)
  200f0b:	00 00                	add    %al,(%rax)
  200f0d:	00 00                	add    %al,(%rax)
  200f0f:	00 08                	add    %cl,(%rax)
  200f11:	00 00                	add    %al,(%rax)
  200f13:	00 00                	add    %al,(%rax)
  200f15:	00 00                	add    %al,(%rax)
  200f17:	00 fb                	add    %bh,%bl
  200f19:	ff                   	(bad)  
  200f1a:	ff 6f 00             	ljmp   *0x0(%rdi)
  200f1d:	00 00                	add    %al,(%rax)
  200f1f:	00 01                	add    %al,(%rcx)
  200f21:	00 00                	add    %al,(%rax)
  200f23:	08 00                	or     %al,(%rax)
  200f25:	00 00                	add    %al,(%rax)
  200f27:	00 fe                	add    %bh,%dh
  200f29:	ff                   	(bad)  
  200f2a:	ff 6f 00             	ljmp   *0x0(%rdi)
  200f2d:	00 00                	add    %al,(%rax)
  200f2f:	00 f0                	add    %dh,%al
  200f31:	03 00                	add    (%rax),%eax
  200f33:	00 00                	add    %al,(%rax)
  200f35:	00 00                	add    %al,(%rax)
  200f37:	00 ff                	add    %bh,%bh
  200f39:	ff                   	(bad)  
  200f3a:	ff 6f 00             	ljmp   *0x0(%rdi)
  200f3d:	00 00                	add    %al,(%rax)
  200f3f:	00 01                	add    %al,(%rcx)
  200f41:	00 00                	add    %al,(%rax)
  200f43:	00 00                	add    %al,(%rax)
  200f45:	00 00                	add    %al,(%rax)
  200f47:	00 f0                	add    %dh,%al
  200f49:	ff                   	(bad)  
  200f4a:	ff 6f 00             	ljmp   *0x0(%rdi)
  200f4d:	00 00                	add    %al,(%rax)
  200f4f:	00 e2                	add    %ah,%dl
  200f51:	03 00                	add    (%rax),%eax
  200f53:	00 00                	add    %al,(%rax)
  200f55:	00 00                	add    %al,(%rax)
  200f57:	00 f9                	add    %bh,%cl
  200f59:	ff                   	(bad)  
  200f5a:	ff 6f 00             	ljmp   *0x0(%rdi)
  200f5d:	00 00                	add    %al,(%rax)
  200f5f:	00 03                	add    %al,(%rbx)
	...

Disassembly of section .got:

0000000000200fb8 <_GLOBAL_OFFSET_TABLE_>:
  200fb8:	c8 0d 20 00          	enterq $0x200d,$0x0
	...
  200fd0:	16                   	(bad)  
  200fd1:	05 00 00 00 00       	add    $0x0,%eax
	...

Disassembly of section .data:

0000000000201000 <__data_start>:
	...

0000000000201008 <__dso_handle>:
  201008:	08 10                	or     %dl,(%rax)
  20100a:	20 00                	and    %al,(%rax)
  20100c:	00 00                	add    %al,(%rax)
	...

Disassembly of section .bss:

0000000000201010 <__bss_start>:
	...

Disassembly of section .comment:

0000000000000000 <.comment>:
   0:	47                   	rex.RXB
   1:	43                   	rex.XB
   2:	43 3a 20             	rex.XB cmp (%r8),%spl
   5:	28 55 62             	sub    %dl,0x62(%rbp)
   8:	75 6e                	jne    78 <_init-0x470>
   a:	74 75                	je     81 <_init-0x467>
   c:	20 37                	and    %dh,(%rdi)
   e:	2e 34 2e             	cs xor $0x2e,%al
  11:	30 2d 31 75 62 75    	xor    %ch,0x75627531(%rip)        # 75627548 <_end+0x75426530>
  17:	6e                   	outsb  %ds:(%rsi),(%dx)
  18:	74 75                	je     8f <_init-0x459>
  1a:	31 7e 31             	xor    %edi,0x31(%rsi)
  1d:	38 2e                	cmp    %ch,(%rsi)
  1f:	30 34 2e             	xor    %dh,(%rsi,%rbp,1)
  22:	31 29                	xor    %ebp,(%rcx)
  24:	20 37                	and    %dh,(%rdi)
  26:	2e 34 2e             	cs xor $0x2e,%al
  29:	30 00                	xor    %al,(%rax)

Disassembly of section .debug_aranges:

0000000000000000 <.debug_aranges>:
   0:	2c 00                	sub    $0x0,%al
   2:	00 00                	add    %al,(%rax)
   4:	02 00                	add    (%rax),%al
   6:	00 00                	add    %al,(%rax)
   8:	00 00                	add    %al,(%rax)
   a:	08 00                	or     %al,(%rax)
   c:	00 00                	add    %al,(%rax)
   e:	00 00                	add    %al,(%rax)
  10:	3a 06                	cmp    (%rsi),%al
  12:	00 00                	add    %al,(%rax)
  14:	00 00                	add    %al,(%rax)
  16:	00 00                	add    %al,(%rax)
  18:	22 00                	and    (%rax),%al
	...

Disassembly of section .debug_info:

0000000000000000 <.debug_info>:
   0:	40 03 00             	rex add (%rax),%eax
   3:	00 04 00             	add    %al,(%rax,%rax,1)
   6:	00 00                	add    %al,(%rax)
   8:	00 00                	add    %al,(%rax)
   a:	08 01                	or     %al,(%rcx)
   c:	13 02                	adc    (%rdx),%eax
   e:	00 00                	add    %al,(%rax)
  10:	0c 18                	or     $0x18,%al
  12:	00 00                	add    %al,(%rax)
  14:	00 6b 00             	add    %ch,0x0(%rbx)
  17:	00 00                	add    %al,(%rax)
  19:	3a 06                	cmp    (%rsi),%al
  1b:	00 00                	add    %al,(%rax)
  1d:	00 00                	add    %al,(%rax)
  1f:	00 00                	add    %al,(%rax)
  21:	22 00                	and    (%rax),%al
	...
  2b:	00 00                	add    %al,(%rax)
  2d:	02 42 00             	add    0x0(%rdx),%al
  30:	00 00                	add    %al,(%rax)
  32:	02 d8                	add    %al,%bl
  34:	38 00                	cmp    %al,(%rax)
  36:	00 00                	add    %al,(%rax)
  38:	03 08                	add    (%rax),%ecx
  3a:	07                   	(bad)  
  3b:	da 01                	fiaddl (%rcx)
  3d:	00 00                	add    %al,(%rax)
  3f:	03 01                	add    (%rcx),%eax
  41:	08 3d 01 00 00 03    	or     %bh,0x3000001(%rip)        # 3000048 <_end+0x2dff030>
  47:	02 07                	add    (%rdi),%al
  49:	99                   	cltd   
  4a:	01 00                	add    %eax,(%rax)
  4c:	00 03                	add    %al,(%rbx)
  4e:	04 07                	add    $0x7,%al
  50:	df 01                	filds  (%rcx)
  52:	00 00                	add    %al,(%rax)
  54:	03 01                	add    (%rcx),%eax
  56:	06                   	(bad)  
  57:	3f                   	(bad)  
  58:	01 00                	add    %eax,(%rax)
  5a:	00 03                	add    %al,(%rbx)
  5c:	02 05 38 00 00 00    	add    0x38(%rip),%al        # 9a <_init-0x44e>
  62:	04 04                	add    $0x4,%al
  64:	05 69 6e 74 00       	add    $0x746e69,%eax
  69:	03 08                	add    (%rax),%ecx
  6b:	05 f1 00 00 00       	add    $0xf1,%eax
  70:	02 04 02             	add    (%rdx,%rax,1),%al
  73:	00 00                	add    %al,(%rax)
  75:	03 8c 69 00 00 00 02 	add    0x2000000(%rcx,%rbp,2),%ecx
  7c:	fa                   	cli    
  7d:	01 00                	add    %eax,(%rax)
  7f:	00 03                	add    %al,(%rbx)
  81:	8d 69 00             	lea    0x0(%rcx),%ebp
  84:	00 00                	add    %al,(%rax)
  86:	05 08 06 08 8e       	add    $0x8e080608,%eax
  8b:	00 00                	add    %al,(%rax)
  8d:	00 03                	add    %al,(%rbx)
  8f:	01 06                	add    %eax,(%rsi)
  91:	46 01 00             	rex.RX add %r8d,(%rax)
  94:	00 07                	add    %al,(%rdi)
  96:	8e 00                	mov    (%rax),%es
  98:	00 00                	add    %al,(%rax)
  9a:	08 34 01             	or     %dh,(%rcx,%rax,1)
  9d:	00 00                	add    %al,(%rax)
  9f:	d8 04 f5 1a 02 00 00 	fadds  0x21a(,%rsi,8)
  a6:	09 57 00             	or     %edx,0x0(%rdi)
  a9:	00 00                	add    %al,(%rax)
  ab:	04 f6                	add    $0xf6,%al
  ad:	62                   	(bad)  
  ae:	00 00                	add    %al,(%rax)
  b0:	00 00                	add    %al,(%rax)
  b2:	09 8c 01 00 00 04 fb 	or     %ecx,-0x4fc0000(%rcx,%rax,1)
  b9:	88 00                	mov    %al,(%rax)
  bb:	00 00                	add    %al,(%rax)
  bd:	08 09                	or     %cl,(%rcx)
  bf:	d7                   	xlat   %ds:(%rbx)
  c0:	00 00                	add    %al,(%rax)
  c2:	00 04 fc             	add    %al,(%rsp,%rdi,8)
  c5:	88 00                	mov    %al,(%rax)
  c7:	00 00                	add    %al,(%rax)
  c9:	10 09                	adc    %cl,(%rcx)
  cb:	7e 02                	jle    cf <_init-0x419>
  cd:	00 00                	add    %al,(%rax)
  cf:	04 fd                	add    $0xfd,%al
  d1:	88 00                	mov    %al,(%rax)
  d3:	00 00                	add    %al,(%rax)
  d5:	18 09                	sbb    %cl,(%rcx)
  d7:	74 01                	je     da <_init-0x40e>
  d9:	00 00                	add    %al,(%rax)
  db:	04 fe                	add    $0xfe,%al
  dd:	88 00                	mov    %al,(%rax)
  df:	00 00                	add    %al,(%rax)
  e1:	20 09                	and    %cl,(%rcx)
  e3:	49 00 00             	rex.WB add %al,(%r8)
  e6:	00 04 ff             	add    %al,(%rdi,%rdi,8)
  e9:	88 00                	mov    %al,(%rax)
  eb:	00 00                	add    %al,(%rax)
  ed:	28 0a                	sub    %cl,(%rdx)
  ef:	ec                   	in     (%dx),%al
  f0:	01 00                	add    %eax,(%rax)
  f2:	00 04 00             	add    %al,(%rax,%rax,1)
  f5:	01 88 00 00 00 30    	add    %ecx,0x30000000(%rax)
  fb:	0a 5e 00             	or     0x0(%rsi),%bl
  fe:	00 00                	add    %al,(%rax)
 100:	04 01                	add    $0x1,%al
 102:	01 88 00 00 00 38    	add    %ecx,0x38000000(%rax)
 108:	0a 00                	or     (%rax),%al
 10a:	00 00                	add    %al,(%rax)
 10c:	00 04 02             	add    %al,(%rdx,%rax,1)
 10f:	01 88 00 00 00 40    	add    %ecx,0x40000000(%rax)
 115:	0a 9b 02 00 00 04    	or     0x4000002(%rbx),%bl
 11b:	04 01                	add    $0x1,%al
 11d:	88 00                	mov    %al,(%rax)
 11f:	00 00                	add    %al,(%rax)
 121:	48 0a 5a 02          	rex.W or 0x2(%rdx),%bl
 125:	00 00                	add    %al,(%rax)
 127:	04 05                	add    $0x5,%al
 129:	01 88 00 00 00 50    	add    %ecx,0x50000000(%rax)
 12f:	0a 2b                	or     (%rbx),%ch
 131:	00 00                	add    %al,(%rax)
 133:	00 04 06             	add    %al,(%rsi,%rax,1)
 136:	01 88 00 00 00 58    	add    %ecx,0x58000000(%rax)
 13c:	0a ce                	or     %dh,%cl
 13e:	00 00                	add    %al,(%rax)
 140:	00 04 08             	add    %al,(%rax,%rcx,1)
 143:	01 52 02             	add    %edx,0x2(%rdx)
 146:	00 00                	add    %al,(%rax)
 148:	60                   	(bad)  
 149:	0a 0c 02             	or     (%rdx,%rax,1),%cl
 14c:	00 00                	add    %al,(%rax)
 14e:	04 0a                	add    $0xa,%al
 150:	01 58 02             	add    %ebx,0x2(%rax)
 153:	00 00                	add    %al,(%rax)
 155:	68 0a b5 02 00       	pushq  $0x2b50a
 15a:	00 04 0c             	add    %al,(%rsp,%rcx,1)
 15d:	01 62 00             	add    %esp,0x0(%rdx)
 160:	00 00                	add    %al,(%rax)
 162:	70 0a                	jo     16e <_init-0x37a>
 164:	70 02                	jo     168 <_init-0x380>
 166:	00 00                	add    %al,(%rax)
 168:	04 10                	add    $0x10,%al
 16a:	01 62 00             	add    %esp,0x0(%rdx)
 16d:	00 00                	add    %al,(%rax)
 16f:	74 0a                	je     17b <_init-0x36d>
 171:	0c 00                	or     $0x0,%al
 173:	00 00                	add    %al,(%rax)
 175:	04 12                	add    $0x12,%al
 177:	01 70 00             	add    %esi,0x0(%rax)
 17a:	00 00                	add    %al,(%rax)
 17c:	78 0a                	js     188 <_init-0x360>
 17e:	fa                   	cli    
 17f:	00 00                	add    %al,(%rax)
 181:	00 04 16             	add    %al,(%rsi,%rdx,1)
 184:	01 46 00             	add    %eax,0x0(%rsi)
 187:	00 00                	add    %al,(%rax)
 189:	80 0a 8c             	orb    $0x8c,(%rdx)
 18c:	02 00                	add    (%rax),%al
 18e:	00 04 17             	add    %al,(%rdi,%rdx,1)
 191:	01 54 00 00          	add    %edx,0x0(%rax,%rax,1)
 195:	00 82 0a 6a 01 00    	add    %al,0x16a0a(%rdx)
 19b:	00 04 18             	add    %al,(%rax,%rbx,1)
 19e:	01 5e 02             	add    %ebx,0x2(%rsi)
 1a1:	00 00                	add    %al,(%rax)
 1a3:	83 0a eb             	orl    $0xffffffeb,(%rdx)
 1a6:	00 00                	add    %al,(%rax)
 1a8:	00 04 1c             	add    %al,(%rsp,%rbx,1)
 1ab:	01 6e 02             	add    %ebp,0x2(%rsi)
 1ae:	00 00                	add    %al,(%rax)
 1b0:	88 0a                	mov    %cl,(%rdx)
 1b2:	10 00                	adc    %al,(%rax)
 1b4:	00 00                	add    %al,(%rax)
 1b6:	04 25                	add    $0x25,%al
 1b8:	01 7b 00             	add    %edi,0x0(%rbx)
 1bb:	00 00                	add    %al,(%rax)
 1bd:	90                   	nop
 1be:	0a b7 01 00 00 04    	or     0x4000001(%rdi),%dh
 1c4:	2d 01 86 00 00       	sub    $0x8601,%eax
 1c9:	00 98 0a be 01 00    	add    %bl,0x1be0a(%rax)
 1cf:	00 04 2e             	add    %al,(%rsi,%rbp,1)
 1d2:	01 86 00 00 00 a0    	add    %eax,-0x60000000(%rsi)
 1d8:	0a c5                	or     %ch,%al
 1da:	01 00                	add    %eax,(%rax)
 1dc:	00 04 2f             	add    %al,(%rdi,%rbp,1)
 1df:	01 86 00 00 00 a8    	add    %eax,-0x58000000(%rsi)
 1e5:	0a cc                	or     %ah,%cl
 1e7:	01 00                	add    %eax,(%rax)
 1e9:	00 04 30             	add    %al,(%rax,%rsi,1)
 1ec:	01 86 00 00 00 b0    	add    %eax,-0x50000000(%rsi)
 1f2:	0a d3                	or     %bl,%dl
 1f4:	01 00                	add    %eax,(%rax)
 1f6:	00 04 32             	add    %al,(%rdx,%rsi,1)
 1f9:	01 2d 00 00 00 b8    	add    %ebp,-0x48000000(%rip)        # ffffffffb80001ff <_end+0xffffffffb7dff1e7>
 1ff:	0a 78 02             	or     0x2(%rax),%bh
 202:	00 00                	add    %al,(%rax)
 204:	04 33                	add    $0x33,%al
 206:	01 62 00             	add    %esp,0x0(%rdx)
 209:	00 00                	add    %al,(%rax)
 20b:	c0 0a 83             	rorb   $0x83,(%rdx)
 20e:	01 00                	add    %eax,(%rax)
 210:	00 04 35 01 74 02 00 	add    %al,0x27401(,%rsi,1)
 217:	00 c4                	add    %al,%ah
 219:	00 0b                	add    %cl,(%rbx)
 21b:	d4                   	(bad)  
 21c:	02 00                	add    (%rax),%al
 21e:	00 04 9a             	add    %al,(%rdx,%rbx,4)
 221:	08 5f 01             	or     %bl,0x1(%rdi)
 224:	00 00                	add    %al,(%rax)
 226:	18 04 a0             	sbb    %al,(%rax,%riz,4)
 229:	52                   	push   %rdx
 22a:	02 00                	add    (%rax),%al
 22c:	00 09                	add    %cl,(%rcx)
 22e:	b1 01                	mov    $0x1,%cl
 230:	00 00                	add    %al,(%rax)
 232:	04 a1                	add    $0xa1,%al
 234:	52                   	push   %rdx
 235:	02 00                	add    (%rax),%al
 237:	00 00                	add    %al,(%rax)
 239:	09 2e                	or     %ebp,(%rsi)
 23b:	01 00                	add    %eax,(%rax)
 23d:	00 04 a2             	add    %al,(%rdx,%riz,4)
 240:	58                   	pop    %rax
 241:	02 00                	add    (%rax),%al
 243:	00 08                	add    %cl,(%rax)
 245:	09 24 01             	or     %esp,(%rcx,%rax,1)
 248:	00 00                	add    %al,(%rax)
 24a:	04 a6                	add    $0xa6,%al
 24c:	62                   	(bad)  
 24d:	00 00                	add    %al,(%rax)
 24f:	00 10                	add    %dl,(%rax)
 251:	00 06                	add    %al,(%rsi)
 253:	08 21                	or     %ah,(%rcx)
 255:	02 00                	add    (%rax),%al
 257:	00 06                	add    %al,(%rsi)
 259:	08 9a 00 00 00 0c    	or     %bl,0xc000000(%rdx)
 25f:	8e 00                	mov    (%rax),%es
 261:	00 00                	add    %al,(%rax)
 263:	6e                   	outsb  %ds:(%rsi),(%dx)
 264:	02 00                	add    (%rax),%al
 266:	00 0d 38 00 00 00    	add    %cl,0x38(%rip)        # 2a4 <_init-0x244>
 26c:	00 00                	add    %al,(%rax)
 26e:	06                   	(bad)  
 26f:	08 1a                	or     %bl,(%rdx)
 271:	02 00                	add    (%rax),%al
 273:	00 0c 8e             	add    %cl,(%rsi,%rcx,4)
 276:	00 00                	add    %al,(%rax)
 278:	00 84 02 00 00 0d 38 	add    %al,0x380d0000(%rdx,%rax,1)
 27f:	00 00                	add    %al,(%rax)
 281:	00 13                	add    %dl,(%rbx)
 283:	00 0e                	add    %cl,(%rsi)
 285:	16                   	(bad)  
 286:	01 00                	add    %eax,(%rax)
 288:	00 0f                	add    %cl,(%rdi)
 28a:	50                   	push   %rax
 28b:	01 00                	add    %eax,(%rax)
 28d:	00 04 3f             	add    %al,(%rdi,%rdi,1)
 290:	01 84 02 00 00 0f c4 	add    %eax,-0x3bf10000(%rdx,%rax,1)
 297:	02 00                	add    (%rax),%al
 299:	00 04 40             	add    %al,(%rax,%rax,2)
 29c:	01 84 02 00 00 0f 06 	add    %eax,0x60f0000(%rdx,%rax,1)
 2a3:	01 00                	add    %eax,(%rax)
 2a5:	00 04 41             	add    %al,(%rcx,%rax,2)
 2a8:	01 84 02 00 00 06 08 	add    %eax,0x8060000(%rdx,%rax,1)
 2af:	95                   	xchg   %eax,%ebp
 2b0:	00 00                	add    %al,(%rax)
 2b2:	00 07                	add    %al,(%rdi)
 2b4:	ad                   	lods   %ds:(%rsi),%eax
 2b5:	02 00                	add    (%rax),%al
 2b7:	00 10                	add    %dl,(%rax)
 2b9:	6a 02                	pushq  $0x2
 2bb:	00 00                	add    %al,(%rax)
 2bd:	05 87 58 02 00       	add    $0x25887,%eax
 2c2:	00 10                	add    %dl,(%rax)
 2c4:	bd 02 00 00 05       	mov    $0x5000002,%ebp
 2c9:	88 58 02             	mov    %bl,0x2(%rax)
 2cc:	00 00                	add    %al,(%rax)
 2ce:	10 e4                	adc    %ah,%ah
 2d0:	00 00                	add    %al,(%rax)
 2d2:	00 05 89 58 02 00    	add    %al,0x25889(%rip)        # 25b61 <__FRAME_END__+0x2532d>
 2d8:	00 10                	add    %dl,(%rax)
 2da:	22 00                	and    (%rax),%al
 2dc:	00 00                	add    %al,(%rax)
 2de:	06                   	(bad)  
 2df:	1a 62 00             	sbb    0x0(%rdx),%ah
 2e2:	00 00                	add    %al,(%rax)
 2e4:	0c b3                	or     $0xb3,%al
 2e6:	02 00                	add    (%rax),%al
 2e8:	00 ef                	add    %ch,%bh
 2ea:	02 00                	add    (%rax),%al
 2ec:	00 11                	add    %dl,(%rcx)
 2ee:	00 07                	add    %al,(%rdi)
 2f0:	e4 02                	in     $0x2,%al
 2f2:	00 00                	add    %al,(%rax)
 2f4:	10 a9 02 00 00 06    	adc    %ch,0x6000002(%rcx)
 2fa:	1b ef                	sbb    %edi,%ebp
 2fc:	02 00                	add    (%rax),%al
 2fe:	00 12                	add    %dl,(%rdx)
 300:	ac                   	lods   %ds:(%rsi),%al
 301:	01 00                	add    %eax,(%rax)
 303:	00 01                	add    %al,(%rcx)
 305:	03 62 00             	add    0x0(%rdx),%esp
 308:	00 00                	add    %al,(%rax)
 30a:	3a 06                	cmp    (%rsi),%al
 30c:	00 00                	add    %al,(%rax)
 30e:	00 00                	add    %al,(%rax)
 310:	00 00                	add    %al,(%rax)
 312:	22 00                	and    (%rax),%al
 314:	00 00                	add    %al,(%rax)
 316:	00 00                	add    %al,(%rax)
 318:	00 00                	add    %al,(%rax)
 31a:	01 9c 3d 03 00 00 13 	add    %ebx,0x13000003(%rbp,%rdi,1)
 321:	4b 01 00             	rex.WXB add %rax,(%r8)
 324:	00 01                	add    %al,(%rcx)
 326:	03 62 00             	add    0x0(%rdx),%esp
 329:	00 00                	add    %al,(%rax)
 32b:	02 91 6c 13 29 01    	add    0x129136c(%rcx),%dl
 331:	00 00                	add    %al,(%rax)
 333:	01 03                	add    %eax,(%rbx)
 335:	3d 03 00 00 02       	cmp    $0x2000003,%eax
 33a:	91                   	xchg   %eax,%ecx
 33b:	60                   	(bad)  
 33c:	00 06                	add    %al,(%rsi)
 33e:	08 88 00 00 00 00    	or     %cl,0x0(%rax)

Disassembly of section .debug_abbrev:

0000000000000000 <.debug_abbrev>:
   0:	01 11                	add    %edx,(%rcx)
   2:	01 25 0e 13 0b 03    	add    %esp,0x30b130e(%rip)        # 30b1316 <_end+0x2eb02fe>
   8:	0e                   	(bad)  
   9:	1b 0e                	sbb    (%rsi),%ecx
   b:	11 01                	adc    %eax,(%rcx)
   d:	12 07                	adc    (%rdi),%al
   f:	10 17                	adc    %dl,(%rdi)
  11:	00 00                	add    %al,(%rax)
  13:	02 16                	add    (%rsi),%dl
  15:	00 03                	add    %al,(%rbx)
  17:	0e                   	(bad)  
  18:	3a 0b                	cmp    (%rbx),%cl
  1a:	3b 0b                	cmp    (%rbx),%ecx
  1c:	49 13 00             	adc    (%r8),%rax
  1f:	00 03                	add    %al,(%rbx)
  21:	24 00                	and    $0x0,%al
  23:	0b 0b                	or     (%rbx),%ecx
  25:	3e 0b 03             	or     %ds:(%rbx),%eax
  28:	0e                   	(bad)  
  29:	00 00                	add    %al,(%rax)
  2b:	04 24                	add    $0x24,%al
  2d:	00 0b                	add    %cl,(%rbx)
  2f:	0b 3e                	or     (%rsi),%edi
  31:	0b 03                	or     (%rbx),%eax
  33:	08 00                	or     %al,(%rax)
  35:	00 05 0f 00 0b 0b    	add    %al,0xb0b000f(%rip)        # b0b004a <_end+0xaeaf032>
  3b:	00 00                	add    %al,(%rax)
  3d:	06                   	(bad)  
  3e:	0f 00 0b             	str    (%rbx)
  41:	0b 49 13             	or     0x13(%rcx),%ecx
  44:	00 00                	add    %al,(%rax)
  46:	07                   	(bad)  
  47:	26 00 49 13          	add    %cl,%es:0x13(%rcx)
  4b:	00 00                	add    %al,(%rax)
  4d:	08 13                	or     %dl,(%rbx)
  4f:	01 03                	add    %eax,(%rbx)
  51:	0e                   	(bad)  
  52:	0b 0b                	or     (%rbx),%ecx
  54:	3a 0b                	cmp    (%rbx),%cl
  56:	3b 0b                	cmp    (%rbx),%ecx
  58:	01 13                	add    %edx,(%rbx)
  5a:	00 00                	add    %al,(%rax)
  5c:	09 0d 00 03 0e 3a    	or     %ecx,0x3a0e0300(%rip)        # 3a0e0362 <_end+0x39edf34a>
  62:	0b 3b                	or     (%rbx),%edi
  64:	0b 49 13             	or     0x13(%rcx),%ecx
  67:	38 0b                	cmp    %cl,(%rbx)
  69:	00 00                	add    %al,(%rax)
  6b:	0a 0d 00 03 0e 3a    	or     0x3a0e0300(%rip),%cl        # 3a0e0371 <_end+0x39edf359>
  71:	0b 3b                	or     (%rbx),%edi
  73:	05 49 13 38 0b       	add    $0xb381349,%eax
  78:	00 00                	add    %al,(%rax)
  7a:	0b 16                	or     (%rsi),%edx
  7c:	00 03                	add    %al,(%rbx)
  7e:	0e                   	(bad)  
  7f:	3a 0b                	cmp    (%rbx),%cl
  81:	3b 0b                	cmp    (%rbx),%ecx
  83:	00 00                	add    %al,(%rax)
  85:	0c 01                	or     $0x1,%al
  87:	01 49 13             	add    %ecx,0x13(%rcx)
  8a:	01 13                	add    %edx,(%rbx)
  8c:	00 00                	add    %al,(%rax)
  8e:	0d 21 00 49 13       	or     $0x13490021,%eax
  93:	2f                   	(bad)  
  94:	0b 00                	or     (%rax),%eax
  96:	00 0e                	add    %cl,(%rsi)
  98:	13 00                	adc    (%rax),%eax
  9a:	03 0e                	add    (%rsi),%ecx
  9c:	3c 19                	cmp    $0x19,%al
  9e:	00 00                	add    %al,(%rax)
  a0:	0f 34                	sysenter 
  a2:	00 03                	add    %al,(%rbx)
  a4:	0e                   	(bad)  
  a5:	3a 0b                	cmp    (%rbx),%cl
  a7:	3b 05 49 13 3f 19    	cmp    0x193f1349(%rip),%eax        # 193f13f6 <_end+0x191f03de>
  ad:	3c 19                	cmp    $0x19,%al
  af:	00 00                	add    %al,(%rax)
  b1:	10 34 00             	adc    %dh,(%rax,%rax,1)
  b4:	03 0e                	add    (%rsi),%ecx
  b6:	3a 0b                	cmp    (%rbx),%cl
  b8:	3b 0b                	cmp    (%rbx),%ecx
  ba:	49 13 3f             	adc    (%r15),%rdi
  bd:	19 3c 19             	sbb    %edi,(%rcx,%rbx,1)
  c0:	00 00                	add    %al,(%rax)
  c2:	11 21                	adc    %esp,(%rcx)
  c4:	00 00                	add    %al,(%rax)
  c6:	00 12                	add    %dl,(%rdx)
  c8:	2e 01 3f             	add    %edi,%cs:(%rdi)
  cb:	19 03                	sbb    %eax,(%rbx)
  cd:	0e                   	(bad)  
  ce:	3a 0b                	cmp    (%rbx),%cl
  d0:	3b 0b                	cmp    (%rbx),%ecx
  d2:	27                   	(bad)  
  d3:	19 49 13             	sbb    %ecx,0x13(%rcx)
  d6:	11 01                	adc    %eax,(%rcx)
  d8:	12 07                	adc    (%rdi),%al
  da:	40 18 96 42 19 01 13 	sbb    %dl,0x13011942(%rsi)
  e1:	00 00                	add    %al,(%rax)
  e3:	13 05 00 03 0e 3a    	adc    0x3a0e0300(%rip),%eax        # 3a0e03e9 <_end+0x39edf3d1>
  e9:	0b 3b                	or     (%rbx),%edi
  eb:	0b 49 13             	or     0x13(%rcx),%ecx
  ee:	02 18                	add    (%rax),%bl
  f0:	00 00                	add    %al,(%rax)
	...

Disassembly of section .debug_line:

0000000000000000 <.debug_line>:
   0:	d0 00                	rolb   (%rax)
   2:	00 00                	add    %al,(%rax)
   4:	02 00                	add    (%rax),%al
   6:	b6 00                	mov    $0x0,%dh
   8:	00 00                	add    %al,(%rax)
   a:	01 01                	add    %eax,(%rcx)
   c:	fb                   	sti    
   d:	0e                   	(bad)  
   e:	0d 00 01 01 01       	or     $0x1010100,%eax
  13:	01 00                	add    %eax,(%rax)
  15:	00 00                	add    %al,(%rax)
  17:	01 00                	add    %eax,(%rax)
  19:	00 01                	add    %al,(%rcx)
  1b:	2f                   	(bad)  
  1c:	75 73                	jne    91 <_init-0x457>
  1e:	72 2f                	jb     4f <_init-0x499>
  20:	6c                   	insb   (%dx),%es:(%rdi)
  21:	69 62 2f 67 63 63 2f 	imul   $0x2f636367,0x2f(%rdx),%esp
  28:	78 38                	js     62 <_init-0x486>
  2a:	36 5f                	ss pop %rdi
  2c:	36 34 2d             	ss xor $0x2d,%al
  2f:	6c                   	insb   (%dx),%es:(%rdi)
  30:	69 6e 75 78 2d 67 6e 	imul   $0x6e672d78,0x75(%rsi),%ebp
  37:	75 2f                	jne    68 <_init-0x480>
  39:	37                   	(bad)  
  3a:	2f                   	(bad)  
  3b:	69 6e 63 6c 75 64 65 	imul   $0x6564756c,0x63(%rsi),%ebp
  42:	00 2f                	add    %ch,(%rdi)
  44:	75 73                	jne    b9 <_init-0x42f>
  46:	72 2f                	jb     77 <_init-0x471>
  48:	69 6e 63 6c 75 64 65 	imul   $0x6564756c,0x63(%rsi),%ebp
  4f:	2f                   	(bad)  
  50:	78 38                	js     8a <_init-0x45e>
  52:	36 5f                	ss pop %rdi
  54:	36 34 2d             	ss xor $0x2d,%al
  57:	6c                   	insb   (%dx),%es:(%rdi)
  58:	69 6e 75 78 2d 67 6e 	imul   $0x6e672d78,0x75(%rsi),%ebp
  5f:	75 2f                	jne    90 <_init-0x458>
  61:	62                   	(bad)  
  62:	69 74 73 00 2f 75 73 	imul   $0x7273752f,0x0(%rbx,%rsi,2),%esi
  69:	72 
  6a:	2f                   	(bad)  
  6b:	69 6e 63 6c 75 64 65 	imul   $0x6564756c,0x63(%rsi),%ebp
  72:	00 00                	add    %al,(%rax)
  74:	30 31                	xor    %dh,(%rcx)
  76:	5f                   	pop    %rdi
  77:	74 61                	je     da <_init-0x40e>
  79:	73 6b                	jae    e6 <_init-0x402>
  7b:	2e 63 00             	movslq %cs:(%rax),%eax
  7e:	00 00                	add    %al,(%rax)
  80:	00 73 74             	add    %dh,0x74(%rbx)
  83:	64 64 65 66 2e 68 00 	fs fs gs cs pushw $0x100
  8a:	01 
  8b:	00 00                	add    %al,(%rax)
  8d:	74 79                	je     108 <_init-0x3e0>
  8f:	70 65                	jo     f6 <_init-0x3f2>
  91:	73 2e                	jae    c1 <_init-0x427>
  93:	68 00 02 00 00       	pushq  $0x200
  98:	6c                   	insb   (%dx),%es:(%rdi)
  99:	69 62 69 6f 2e 68 00 	imul   $0x682e6f,0x69(%rdx),%esp
  a0:	02 00                	add    (%rax),%al
  a2:	00 73 74             	add    %dh,0x74(%rbx)
  a5:	64 69 6f 2e 68 00 03 	imul   $0x30068,%fs:0x2e(%rdi),%ebp
  ac:	00 
  ad:	00 73 79             	add    %dh,0x79(%rbx)
  b0:	73 5f                	jae    111 <_init-0x3d7>
  b2:	65 72 72             	gs jb  127 <_init-0x3c1>
  b5:	6c                   	insb   (%dx),%es:(%rdi)
  b6:	69 73 74 2e 68 00 02 	imul   $0x200682e,0x74(%rbx),%esi
  bd:	00 00                	add    %al,(%rax)
  bf:	00 00                	add    %al,(%rax)
  c1:	09 02                	or     %eax,(%rdx)
  c3:	3a 06                	cmp    (%rsi),%al
  c5:	00 00                	add    %al,(%rax)
  c7:	00 00                	add    %al,(%rax)
  c9:	00 00                	add    %al,(%rax)
  cb:	14 e6                	adc    $0xe6,%al
  cd:	bc 59 02 02 00       	mov    $0x20259,%esp
  d2:	01 01                	add    %eax,(%rcx)

Disassembly of section .debug_str:

0000000000000000 <.debug_str>:
   0:	5f                   	pop    %rdi
   1:	49                   	rex.WB
   2:	4f 5f                	rex.WRXB pop %r15
   4:	62                   	(bad)  
   5:	75 66                	jne    6d <_init-0x47b>
   7:	5f                   	pop    %rdi
   8:	65 6e                	outsb  %gs:(%rsi),(%dx)
   a:	64 00 5f 6f          	add    %bl,%fs:0x6f(%rdi)
   e:	6c                   	insb   (%dx),%es:(%rdi)
   f:	64 5f                	fs pop %rdi
  11:	6f                   	outsl  %ds:(%rsi),(%dx)
  12:	66 66 73 65          	data16 data16 jae 7b <_init-0x46d>
  16:	74 00                	je     18 <_init-0x4d0>
  18:	30 31                	xor    %dh,(%rcx)
  1a:	5f                   	pop    %rdi
  1b:	74 61                	je     7e <_init-0x46a>
  1d:	73 6b                	jae    8a <_init-0x45e>
  1f:	2e 63 00             	movslq %cs:(%rax),%eax
  22:	73 79                	jae    9d <_init-0x44b>
  24:	73 5f                	jae    85 <_init-0x463>
  26:	6e                   	outsb  %ds:(%rsi),(%dx)
  27:	65 72 72             	gs jb  9c <_init-0x44c>
  2a:	00 5f 49             	add    %bl,0x49(%rdi)
  2d:	4f 5f                	rex.WRXB pop %r15
  2f:	73 61                	jae    92 <_init-0x456>
  31:	76 65                	jbe    98 <_init-0x450>
  33:	5f                   	pop    %rdi
  34:	65 6e                	outsb  %gs:(%rsi),(%dx)
  36:	64 00 73 68          	add    %dh,%fs:0x68(%rbx)
  3a:	6f                   	outsl  %ds:(%rsi),(%dx)
  3b:	72 74                	jb     b1 <_init-0x437>
  3d:	20 69 6e             	and    %ch,0x6e(%rcx)
  40:	74 00                	je     42 <_init-0x4a6>
  42:	73 69                	jae    ad <_init-0x43b>
  44:	7a 65                	jp     ab <_init-0x43d>
  46:	5f                   	pop    %rdi
  47:	74 00                	je     49 <_init-0x49f>
  49:	5f                   	pop    %rdi
  4a:	49                   	rex.WB
  4b:	4f 5f                	rex.WRXB pop %r15
  4d:	77 72                	ja     c1 <_init-0x427>
  4f:	69 74 65 5f 70 74 72 	imul   $0x727470,0x5f(%rbp,%riz,2),%esi
  56:	00 
  57:	5f                   	pop    %rdi
  58:	66 6c                	data16 insb (%dx),%es:(%rdi)
  5a:	61                   	(bad)  
  5b:	67 73 00             	addr32 jae 5e <_init-0x48a>
  5e:	5f                   	pop    %rdi
  5f:	49                   	rex.WB
  60:	4f 5f                	rex.WRXB pop %r15
  62:	62                   	(bad)  
  63:	75 66                	jne    cb <_init-0x41d>
  65:	5f                   	pop    %rdi
  66:	62 61                	(bad)  
  68:	73 65                	jae    cf <_init-0x419>
  6a:	00 2f                	add    %ch,(%rdi)
  6c:	68 6f 6d 65 2f       	pushq  $0x2f656d6f
  71:	6d                   	insl   (%dx),%es:(%rdi)
  72:	6f                   	outsl  %ds:(%rsi),(%dx)
  73:	72 69                	jb     de <_init-0x40a>
  75:	74 7a                	je     f1 <_init-0x3f7>
  77:	2f                   	(bad)  
  78:	44 6f                	rex.R outsl %ds:(%rsi),(%dx)
  7a:	63 75 6d             	movslq 0x6d(%rbp),%esi
  7d:	65 6e                	outsb  %gs:(%rsi),(%dx)
  7f:	74 73                	je     f4 <_init-0x3f4>
  81:	2f                   	(bad)  
  82:	61                   	(bad)  
  83:	75 63                	jne    e8 <_init-0x400>
  85:	61                   	(bad)  
  86:	2f                   	(bad)  
  87:	63 6f 6d             	movslq 0x6d(%rdi),%ebp
  8a:	70 5f                	jo     eb <_init-0x3fd>
  8c:	73 63                	jae    f1 <_init-0x3f7>
  8e:	69 2f 43 6f 6d 70    	imul   $0x706d6f43,(%rdi),%ebp
  94:	75 74                	jne    10a <_init-0x3de>
  96:	65 72 5f             	gs jb  f8 <_init-0x3f0>
  99:	41 72 63             	rex.B jb ff <_init-0x3e9>
  9c:	68 69 74 65 63       	pushq  $0x63657469
  a1:	74 75                	je     118 <_init-0x3d0>
  a3:	72 65                	jb     10a <_init-0x3de>
  a5:	5f                   	pop    %rdi
  a6:	61                   	(bad)  
  a7:	6e                   	outsb  %ds:(%rsi),(%dx)
  a8:	64 5f                	fs pop %rdi
  aa:	4f 72 67             	rex.WRXB jb 114 <_init-0x3d4>
  ad:	61                   	(bad)  
  ae:	6e                   	outsb  %ds:(%rsi),(%dx)
  af:	69 7a 61 74 69 6f 6e 	imul   $0x6e6f6974,0x61(%rdx),%edi
  b6:	5f                   	pop    %rdi
  b7:	43                   	rex.XB
  b8:	4f                   	rex.WRXB
  b9:	4d 2d 34 31 30 2e    	rex.WRB sub $0x2e303134,%rax
  bf:	31 2f                	xor    %ebp,(%rdi)
  c1:	6c                   	insb   (%dx),%es:(%rdi)
  c2:	61                   	(bad)  
  c3:	62 73 2f 30 31       	(bad)  
  c8:	5f                   	pop    %rdi
  c9:	74 61                	je     12c <_init-0x3bc>
  cb:	73 6b                	jae    138 <_init-0x3b0>
  cd:	00 5f 6d             	add    %bl,0x6d(%rdi)
  d0:	61                   	(bad)  
  d1:	72 6b                	jb     13e <_init-0x3aa>
  d3:	65 72 73             	gs jb  149 <_init-0x39f>
  d6:	00 5f 49             	add    %bl,0x49(%rdi)
  d9:	4f 5f                	rex.WRXB pop %r15
  db:	72 65                	jb     142 <_init-0x3a6>
  dd:	61                   	(bad)  
  de:	64 5f                	fs pop %rdi
  e0:	65 6e                	outsb  %gs:(%rsi),(%dx)
  e2:	64 00 73 74          	add    %dh,%fs:0x74(%rbx)
  e6:	64 65 72 72          	fs gs jb 15c <_init-0x38c>
  ea:	00 5f 6c             	add    %bl,0x6c(%rdi)
  ed:	6f                   	outsl  %ds:(%rsi),(%dx)
  ee:	63 6b 00             	movslq 0x0(%rbx),%ebp
  f1:	6c                   	insb   (%dx),%es:(%rdi)
  f2:	6f                   	outsl  %ds:(%rsi),(%dx)
  f3:	6e                   	outsb  %ds:(%rsi),(%dx)
  f4:	67 20 69 6e          	and    %ch,0x6e(%ecx)
  f8:	74 00                	je     fa <_init-0x3ee>
  fa:	5f                   	pop    %rdi
  fb:	63 75 72             	movslq 0x72(%rbp),%esi
  fe:	5f                   	pop    %rdi
  ff:	63 6f 6c             	movslq 0x6c(%rdi),%ebp
 102:	75 6d                	jne    171 <_init-0x377>
 104:	6e                   	outsb  %ds:(%rsi),(%dx)
 105:	00 5f 49             	add    %bl,0x49(%rdi)
 108:	4f 5f                	rex.WRXB pop %r15
 10a:	32 5f 31             	xor    0x31(%rdi),%bl
 10d:	5f                   	pop    %rdi
 10e:	73 74                	jae    184 <_init-0x364>
 110:	64 65 72 72          	fs gs jb 186 <_init-0x362>
 114:	5f                   	pop    %rdi
 115:	00 5f 49             	add    %bl,0x49(%rdi)
 118:	4f 5f                	rex.WRXB pop %r15
 11a:	46                   	rex.RX
 11b:	49                   	rex.WB
 11c:	4c                   	rex.WR
 11d:	45 5f                	rex.RB pop %r15
 11f:	70 6c                	jo     18d <_init-0x35b>
 121:	75 73                	jne    196 <_init-0x352>
 123:	00 5f 70             	add    %bl,0x70(%rdi)
 126:	6f                   	outsl  %ds:(%rsi),(%dx)
 127:	73 00                	jae    129 <_init-0x3bf>
 129:	61                   	(bad)  
 12a:	72 67                	jb     193 <_init-0x355>
 12c:	76 00                	jbe    12e <_init-0x3ba>
 12e:	5f                   	pop    %rdi
 12f:	73 62                	jae    193 <_init-0x355>
 131:	75 66                	jne    199 <_init-0x34f>
 133:	00 5f 49             	add    %bl,0x49(%rdi)
 136:	4f 5f                	rex.WRXB pop %r15
 138:	46                   	rex.RX
 139:	49                   	rex.WB
 13a:	4c                   	rex.WR
 13b:	45 00 75 6e          	add    %r14b,0x6e(%r13)
 13f:	73 69                	jae    1aa <_init-0x33e>
 141:	67 6e                	outsb  %ds:(%esi),(%dx)
 143:	65 64 20 63 68       	gs and %ah,%fs:0x68(%rbx)
 148:	61                   	(bad)  
 149:	72 00                	jb     14b <_init-0x39d>
 14b:	61                   	(bad)  
 14c:	72 67                	jb     1b5 <_init-0x333>
 14e:	63 00                	movslq (%rax),%eax
 150:	5f                   	pop    %rdi
 151:	49                   	rex.WB
 152:	4f 5f                	rex.WRXB pop %r15
 154:	32 5f 31             	xor    0x31(%rdi),%bl
 157:	5f                   	pop    %rdi
 158:	73 74                	jae    1ce <_init-0x31a>
 15a:	64 69 6e 5f 00 5f 49 	imul   $0x4f495f00,%fs:0x5f(%rsi),%ebp
 161:	4f 
 162:	5f                   	pop    %rdi
 163:	6d                   	insl   (%dx),%es:(%rdi)
 164:	61                   	(bad)  
 165:	72 6b                	jb     1d2 <_init-0x316>
 167:	65 72 00             	gs jb  16a <_init-0x37e>
 16a:	5f                   	pop    %rdi
 16b:	73 68                	jae    1d5 <_init-0x313>
 16d:	6f                   	outsl  %ds:(%rsi),(%dx)
 16e:	72 74                	jb     1e4 <_init-0x304>
 170:	62                   	(bad)  
 171:	75 66                	jne    1d9 <_init-0x30f>
 173:	00 5f 49             	add    %bl,0x49(%rdi)
 176:	4f 5f                	rex.WRXB pop %r15
 178:	77 72                	ja     1ec <_init-0x2fc>
 17a:	69 74 65 5f 62 61 73 	imul   $0x65736162,0x5f(%rbp,%riz,2),%esi
 181:	65 
 182:	00 5f 75             	add    %bl,0x75(%rdi)
 185:	6e                   	outsb  %ds:(%rsi),(%dx)
 186:	75 73                	jne    1fb <_init-0x2ed>
 188:	65 64 32 00          	gs xor %fs:(%rax),%al
 18c:	5f                   	pop    %rdi
 18d:	49                   	rex.WB
 18e:	4f 5f                	rex.WRXB pop %r15
 190:	72 65                	jb     1f7 <_init-0x2f1>
 192:	61                   	(bad)  
 193:	64 5f                	fs pop %rdi
 195:	70 74                	jo     20b <_init-0x2dd>
 197:	72 00                	jb     199 <_init-0x34f>
 199:	73 68                	jae    203 <_init-0x2e5>
 19b:	6f                   	outsl  %ds:(%rsi),(%dx)
 19c:	72 74                	jb     212 <_init-0x2d6>
 19e:	20 75 6e             	and    %dh,0x6e(%rbp)
 1a1:	73 69                	jae    20c <_init-0x2dc>
 1a3:	67 6e                	outsb  %ds:(%esi),(%dx)
 1a5:	65 64 20 69 6e       	gs and %ch,%fs:0x6e(%rcx)
 1aa:	74 00                	je     1ac <_init-0x33c>
 1ac:	6d                   	insl   (%dx),%es:(%rdi)
 1ad:	61                   	(bad)  
 1ae:	69 6e 00 5f 6e 65 78 	imul   $0x78656e5f,0x0(%rsi),%ebp
 1b5:	74 00                	je     1b7 <_init-0x331>
 1b7:	5f                   	pop    %rdi
 1b8:	5f                   	pop    %rdi
 1b9:	70 61                	jo     21c <_init-0x2cc>
 1bb:	64 31 00             	xor    %eax,%fs:(%rax)
 1be:	5f                   	pop    %rdi
 1bf:	5f                   	pop    %rdi
 1c0:	70 61                	jo     223 <_init-0x2c5>
 1c2:	64 32 00             	xor    %fs:(%rax),%al
 1c5:	5f                   	pop    %rdi
 1c6:	5f                   	pop    %rdi
 1c7:	70 61                	jo     22a <_init-0x2be>
 1c9:	64 33 00             	xor    %fs:(%rax),%eax
 1cc:	5f                   	pop    %rdi
 1cd:	5f                   	pop    %rdi
 1ce:	70 61                	jo     231 <_init-0x2b7>
 1d0:	64 34 00             	fs xor $0x0,%al
 1d3:	5f                   	pop    %rdi
 1d4:	5f                   	pop    %rdi
 1d5:	70 61                	jo     238 <_init-0x2b0>
 1d7:	64 35 00 6c 6f 6e    	fs xor $0x6e6f6c00,%eax
 1dd:	67 20 75 6e          	and    %dh,0x6e(%ebp)
 1e1:	73 69                	jae    24c <_init-0x29c>
 1e3:	67 6e                	outsb  %ds:(%esi),(%dx)
 1e5:	65 64 20 69 6e       	gs and %ch,%fs:0x6e(%rcx)
 1ea:	74 00                	je     1ec <_init-0x2fc>
 1ec:	5f                   	pop    %rdi
 1ed:	49                   	rex.WB
 1ee:	4f 5f                	rex.WRXB pop %r15
 1f0:	77 72                	ja     264 <_init-0x284>
 1f2:	69 74 65 5f 65 6e 64 	imul   $0x646e65,0x5f(%rbp,%riz,2),%esi
 1f9:	00 
 1fa:	5f                   	pop    %rdi
 1fb:	5f                   	pop    %rdi
 1fc:	6f                   	outsl  %ds:(%rsi),(%dx)
 1fd:	66 66 36 34 5f       	data16 data16 ss xor $0x5f,%al
 202:	74 00                	je     204 <_init-0x2e4>
 204:	5f                   	pop    %rdi
 205:	5f                   	pop    %rdi
 206:	6f                   	outsl  %ds:(%rsi),(%dx)
 207:	66 66 5f             	data16 pop %di
 20a:	74 00                	je     20c <_init-0x2dc>
 20c:	5f                   	pop    %rdi
 20d:	63 68 61             	movslq 0x61(%rax),%ebp
 210:	69 6e 00 47 4e 55 20 	imul   $0x20554e47,0x0(%rsi),%ebp
 217:	43 31 31             	rex.XB xor %esi,(%r9)
 21a:	20 37                	and    %dh,(%rdi)
 21c:	2e 34 2e             	cs xor $0x2e,%al
 21f:	30 20                	xor    %ah,(%rax)
 221:	2d 6d 74 75 6e       	sub    $0x6e75746d,%eax
 226:	65 3d 67 65 6e 65    	gs cmp $0x656e6567,%eax
 22c:	72 69                	jb     297 <_init-0x251>
 22e:	63 20                	movslq (%rax),%esp
 230:	2d 6d 61 72 63       	sub    $0x6372616d,%eax
 235:	68 3d 78 38 36       	pushq  $0x3638783d
 23a:	2d 36 34 20 2d       	sub    $0x2d203436,%eax
 23f:	67 20 2d 66 73 74 61 	and    %ch,0x61747366(%eip)        # 617475ac <_end+0x61546594>
 246:	63 6b 2d             	movslq 0x2d(%rbx),%ebp
 249:	70 72                	jo     2bd <_init-0x22b>
 24b:	6f                   	outsl  %ds:(%rsi),(%dx)
 24c:	74 65                	je     2b3 <_init-0x235>
 24e:	63 74 6f 72          	movslq 0x72(%rdi,%rbp,2),%esi
 252:	2d 73 74 72 6f       	sub    $0x6f727473,%eax
 257:	6e                   	outsb  %ds:(%rsi),(%dx)
 258:	67 00 5f 49          	add    %bl,0x49(%edi)
 25c:	4f 5f                	rex.WRXB pop %r15
 25e:	62 61                	(bad)  
 260:	63 6b 75             	movslq 0x75(%rbx),%ebp
 263:	70 5f                	jo     2c4 <_init-0x224>
 265:	62 61                	(bad)  
 267:	73 65                	jae    2ce <_init-0x21a>
 269:	00 73 74             	add    %dh,0x74(%rbx)
 26c:	64 69 6e 00 5f 66 6c 	imul   $0x616c665f,%fs:0x0(%rsi),%ebp
 273:	61 
 274:	67 73 32             	addr32 jae 2a9 <_init-0x23f>
 277:	00 5f 6d             	add    %bl,0x6d(%rdi)
 27a:	6f                   	outsl  %ds:(%rsi),(%dx)
 27b:	64 65 00 5f 49       	fs add %bl,%gs:0x49(%rdi)
 280:	4f 5f                	rex.WRXB pop %r15
 282:	72 65                	jb     2e9 <_init-0x1ff>
 284:	61                   	(bad)  
 285:	64 5f                	fs pop %rdi
 287:	62 61                	(bad)  
 289:	73 65                	jae    2f0 <_init-0x1f8>
 28b:	00 5f 76             	add    %bl,0x76(%rdi)
 28e:	74 61                	je     2f1 <_init-0x1f7>
 290:	62                   	(bad)  
 291:	6c                   	insb   (%dx),%es:(%rdi)
 292:	65 5f                	gs pop %rdi
 294:	6f                   	outsl  %ds:(%rsi),(%dx)
 295:	66 66 73 65          	data16 data16 jae 2fe <_init-0x1ea>
 299:	74 00                	je     29b <_init-0x24d>
 29b:	5f                   	pop    %rdi
 29c:	49                   	rex.WB
 29d:	4f 5f                	rex.WRXB pop %r15
 29f:	73 61                	jae    302 <_init-0x1e6>
 2a1:	76 65                	jbe    308 <_init-0x1e0>
 2a3:	5f                   	pop    %rdi
 2a4:	62 61                	(bad)  
 2a6:	73 65                	jae    30d <_init-0x1db>
 2a8:	00 73 79             	add    %dh,0x79(%rbx)
 2ab:	73 5f                	jae    30c <_init-0x1dc>
 2ad:	65 72 72             	gs jb  322 <_init-0x1c6>
 2b0:	6c                   	insb   (%dx),%es:(%rdi)
 2b1:	69 73 74 00 5f 66 69 	imul   $0x69665f00,0x74(%rbx),%esi
 2b8:	6c                   	insb   (%dx),%es:(%rdi)
 2b9:	65 6e                	outsb  %gs:(%rsi),(%dx)
 2bb:	6f                   	outsl  %ds:(%rsi),(%dx)
 2bc:	00 73 74             	add    %dh,0x74(%rbx)
 2bf:	64 6f                	outsl  %fs:(%rsi),(%dx)
 2c1:	75 74                	jne    337 <_init-0x1b1>
 2c3:	00 5f 49             	add    %bl,0x49(%rdi)
 2c6:	4f 5f                	rex.WRXB pop %r15
 2c8:	32 5f 31             	xor    0x31(%rdi),%bl
 2cb:	5f                   	pop    %rdi
 2cc:	73 74                	jae    342 <_init-0x1a6>
 2ce:	64 6f                	outsl  %fs:(%rsi),(%dx)
 2d0:	75 74                	jne    346 <_init-0x1a2>
 2d2:	5f                   	pop    %rdi
 2d3:	00 5f 49             	add    %bl,0x49(%rdi)
 2d6:	4f 5f                	rex.WRXB pop %r15
 2d8:	6c                   	insb   (%dx),%es:(%rdi)
 2d9:	6f                   	outsl  %ds:(%rsi),(%dx)
 2da:	63 6b 5f             	movslq 0x5f(%rbx),%ebp
 2dd:	74 00                	je     2df <_init-0x209>
