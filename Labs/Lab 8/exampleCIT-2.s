#  exampleCIT-2.s
#  data storage

	.data
val:	.word 42		# data variable and value

	.text
	.globl main
main:	
	li $v0, 10		# syscall to exit
	syscall   		# execute syscall