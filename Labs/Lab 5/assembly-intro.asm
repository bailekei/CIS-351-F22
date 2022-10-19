	.globl monkeyTrouble sleepIn posNeg
	.text

# You can use these lines to run your program directly in MARS for
# troubleshooting. Change the values of $a0 and $a1 to try out your
# function with different arguments.
# As the code is written now, it will run all three functions. You can
# comment out a `jal` call if you do not want the function to run.
# ----------------------------------------------------------------------------
	addi $a0, $0, 1		# $a0 and $a1 are used to store function arguments
	addi $a1, $0, 1
	jal monkeyTrouble	# functions are called using `jal`

	addi $a0, $0, 1
	addi $a1, $0, 1
	jal sleepIn

	addi $a0, $0, 1
	addi $a1, $0, 1
	jal posNeg

	addi $v0, $0, 10	# syscall calls the operating system to perform various tasks
	syscall			# It looks in $v0 to determine what to do
				# In the case of $v0 == 10, syscall exits the program
				# Without this, MARS would keep running with the next line
				# of code
# ----------------------------------------------------------------------------
#
# Lines below here are where you will write your functions.
#
monkeyTrouble:
	xor $v0, $a0, $a1
	not $v0, $v0
	andi $v0, $v0, 1
	jr $ra

sleepIn:
	not $t0, $a0
	andi $t0, $t0, 1
	or $v0, $t0, $a1
	jr $ra

posNeg:
	slt $a0, $zero, $a0
	slt $a1, $zero, $a1
	not $t0, $a0
	andi $t0, $t0, 1
	not $t1, $a1
	andi $t1, $t1, 1
	not $t2, $a2
	andi $t2, $t2, 1
	and $t3, $t0, $t1
	and $t3, $t3, $a2
	and $t4, $t0, $a1
	and $t4, $t4, $t2
	and $t5, $a0, $t1
	and $t5, $t5, $t2
	or $t6, $t3, $t4
	or $v0, $t6, $t5
	jr $ra
