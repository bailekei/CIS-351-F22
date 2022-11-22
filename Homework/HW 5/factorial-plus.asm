.globl factorialPlus

.text

factorialPlus:

	addi $sp, $sp, -12 # prepare
	
	sw $ra, 0($sp)
	sw $s0, 4($sp)
	sw $s1, 8($sp)
	
	move $s1, $a0 # save a
	
	jal factorial # call factorial
	move $s0, $v0 # move results of fac(a) to s0
	
	add $t0, $s0, $s1 # fac = fac(a) + a
	
	lw $s1, 8($sp)
	lw $s0, 4($sp)
	lw $ra, 0($sp)
	
	addi $sp, $sp, 12 # restore 
	
	add $v0, $t0, $0 # v0 = fac(a) + a
	
	jr $ra
	
	
