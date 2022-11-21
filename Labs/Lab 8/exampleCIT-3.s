#  exampleCIT-3.s
#  data movement instruction

	.data
val1:	.word 42		# data variable and value
val2:	.word 43
	.text
	.globl main
main:	
	addi $v0, $v0, 32767
	addi $v0, $v0, 65538
	lw $t0, val1		# load contents of memory location val1 into register t0
	lw $t1, val2		# load contents of memory location val2 into register t1
	
	li $v0, 10		# syscall to exit
	syscall   		# execute syscall	
