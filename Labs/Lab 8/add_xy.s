#  add_xy.s
#  Sample program that asks the user for two integers and prints their sum.

	.data
string1:	.asciiz "Please enter an integer (or -433 to quit): "
string2:	.asciiz "Please enter a second integer: "	
string3:	.asciiz "The sum is: "
quitVal:	.word -433		
ret:		.asciiz "\n"
string4:	.asciiz "Let's add again! Please enter an integer (or -433 to quit): "
	.text
	.globl main 
main:
	#
	# Get first integer
	#
	la $a0, string1     #* Put the address at which string1 begins into $a0
	li $v0, 4           #* Load print_string system call into $v0
	syscall             #  Execute system call

top:
	li $v0, 5           # Load read_int syscall into v0
	syscall             # exectute
	move $s0, $v0       # Move answer to s0.

	#
	# exit if reqested by the user
	#
	lw $s2, quitVal	    #* load the sentinel value for quitting into $s1
	beq $s0, $s2, exit  #* branch to the exit, if desired.
	

	#
	# Get second integer
	#
	la $a0, string2     # Put the address at which string2 begins into $a0
	li $v0, 4           # Load print_string system call into $v0
	syscall             # Execute system call

	li $v0, 5           # Load read_int syscall into v0
	syscall             #* exectute
	move $s1, $v0       #* Move answer to s1.	

	#
	# Add
	#
	add $s2, $s0, $s1   # Add s0 to s1 and put the result in s2


	#
	# Print the answer
	#
	la $a0, string3     # Put the address of string3 in a0
	li $v0, 4           # Load the print_string system call.
	syscall             # Execute

	move $a0, $s2       # Put the answer in a0
	li $v0, 1           # Load the print_int system call.
	syscall             # execute

	la $a0, ret         # Put the address of ret in a0
	li $v0, 4           # Load the print_string system call.
	syscall             # Execute
	
	#
	# Do it again
	#

	la $a0, string4     # Put the address at which string1 begins into $a0
	li $v0, 4           # Load print_string system call into $v0
	syscall             #  Execute system call
	j top		           #* Jump up to the top and do it again

exit:		
	#
	# Exit
	#
	li $v0, 10          # syscall to exit
	syscall             # execute syscall
	
