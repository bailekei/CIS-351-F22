.globl log_two
.text
# Keilani Bailey and Sebastian Torrejon Alonzo
# ----------------------------------------------------------------------------

	#addi $a0, $0, 1
	#jal log_two:

	#addi $v0, $0, 10	
	#syscall		
# if (x < 2)
#    return 0;
#  return 1 + logCalculator(x / 2);


log_two: 
	addi $sp, $sp, -4 #make room in sp
	sw $ra, 0($sp) #store ra in stack
	
	slti $t0, $a0, 2 #set t0 to x < 2
	beqz $t0, else #if x < 2: go to else
	
	slti $t0, $a0, 1 #set t0 to x < 1
	beqz $t0, else2	#if x < 1: go to else2
	
	addi $v0, $0, -1 #return -1
	addi $sp, $sp, 4 #restore sp
   	jr $ra
   	
   else2:
   	addi $v0, $0 0 #return 0
   	addi $sp, $sp, 4 #restore sp
   	jr $ra
   
   else:
   	srl $a0, $a0, 1 #make x = x/2
   	jal log_two #recursive call
   	lw $ra, 0($sp) #restore ra
   	addi $sp, $sp, 4 #restore sp
   	addi $v0, $v0, 1 # 1 + log_two(x/2)
   	jr $ra
