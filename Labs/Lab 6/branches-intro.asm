	.globl makes10 intMax close10 dateFashion
	.text

# Keilani Bailey and Sebastian Torrejon Alonzo
# ----------------------------------------------------------------------------
	addi $a0, $0, 1		
	addi $a1, $0, 1
	jal makes10	

	addi $a0, $0, 1
	addi $a1, $0, 1
	jal intMax

	addi $a0, $0, 1
	addi $a1, $0, 1
	jal close10
	
	addi $a0, $0, 1
	addi $a1, $0, 1
	jal dateFashion

	addi $v0, $0, 10	
	syscall			
# ----------------------------------------------------------------------------


makes10:
# a==10 or b==10 or a+b==10
	beq $a0, 10, is_ten
	
	beq $a1, 10, is_ten
	
	add $s0, $a0, $a1
	beq $s0, 10, is_ten
	
	addi $v0, $zero, 0
	jr $ra
	
is_ten:
	addi   $v0, $zero, 1
	jr $ra
	
# ----------------------------------------------------------------------------

intMax:
	slt $t0, $a0, $a1
	bnez $t0, else
	add $v0, $zero, $a0 
	j L2
else:
	add $v0, $zero, $a1
L2:
	slt $t1, $v0, $a2
	bnez $t1, else2
	add $v0, $zero, $v0
	jr $ra
else2:
	add $v0, $zero, $a2
	jr $ra
	
# ----------------------------------------------------------------------------

close10:
	subi $t4, $a0, 10
	subi $t5, $a1, 10
	abs $t0, $t4
	abs $t1, $t5
	
	slt $t2, $t0, $t1
	slt $t3, $t1, $t0
	bnez $t2, else3
	bnez $t3, else4
	addi $v0, $zero, 0
	jr $ra
else3:
	add $v0, $zero, $a0
	jr $ra
else4:
	add $v0, $zero, $a1
	jr $ra
	#
	#if $a0 < 3 or $a1 < 3
	#  return 0
	#
	#if 7 < $a0 or 7 < $a1
	#  return 2
	#
	#return 1
	#
# ----------------------------------------------------------------------------
	#if (you<=2 || date<=2) 
        #	return 0;
 	#else if (you>=8 || date>=8) 
	#	return 2;
 	#else 
  	#	return 1;

dateFashion:
	slti $t0, $a0, 3
	slti $t1, $a1, 3
	
	or $s0, $t0, $t1
	bnez, $s0, bad_fashion
	
	addi $t3, $zero, 7
	slt $t4, $t3, $a0
	slt $t5, $t3, $a1
	
	or $s1, $t4, $t5
	bnez $s1, great_fashion
	
	addi $v0, $zero, 1
	jr $ra
	
	bad_fashion:
		addi $v0, $zero, 0
		jr $ra
		
	great_fashion:
		addi $v0, $zero, 2
		jr $ra
	
	








