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
	
	is_ten:
		andi $t0, 1, 1
		jr $ra

intMax:
	jr $ra

close10:
	jr $ra
	
dateFashion:
	jr $ra
