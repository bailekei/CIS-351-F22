.globl addArray
.data 
	# example_arr: .word 2 4 6 8 10
.text

 # la $a0, example_arr
 # addi $a1, $0, 5
 # jal addArray
 # addi $v0, $0, 10
 # syscall

addArray:
	addi $t0, $zero, 0 #sum = 0
	addi $t4, $zero, 0 # i = 0
	la $t1, ($a0) # address of array
	j while
	
	
	while:
		slt $t2, $t4, $a1 # i < arr.len
		beq $t2, $0, done
		sll $t2, $t4, 2
		add $t2, $t2, $t1
		lw $t3, 0($t2) #a[i]
		add $t0, $t0, $t3
		addi $t4, $t4, 1
		
		j while
		
	done:
		add $v0, $zero, $t0
		jr $ra

			
		
	
