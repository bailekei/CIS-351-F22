.globl max sum13
.text
# Keilani Bailey and Sebastian Torrejon Alonzo
# ----------------------------------------------------------------------------
	addi $a0, $0, 1		
	addi $a1, $0, 1
	jal max	

	addi $a0, $0, 1
	addi $a1, $0, 1
	jal sum13

	addi $v0, $0, 10	
	syscall			
# ----------------------------------------------------------------------------
# Return the largest value in array
#    int i;
#     
#    int max = arr[0];
#
#    for (i = 1; i < n; i++)
#        if (arr[i] > max)
#            max = arr[i];
#  
#    return max;

max: 
	addi $s0, $zero, 0 #i = 1
	add $t0, $t0, $a0 # address of array
	lw $t1, 0($t0) # t1 = array[0]
	add $t2, $t1, $zero # max = arr[0]
	sw $t1, 0($t0)
	
	jr $ra
	
	loop:
		beq $s0, $a1, exit
		slt $t3, $zero, $t2 # arr[i] > max
		
		addi $s0, $s0, 1
	
	exit:
		# leave loop


# public int sum13(int[] nums, int size) {
#    int sum = 0;
#    int i = 0;
#      
#    while(i < size) {
#        if(nums[i] == 13) {
#            i += 2;
#        } else {
#            sum += nums[i];
#            i++;
#        }
#    }
#    
#    return sum;
# }
sum13:
	addi $t0, $zero, 0 # sum = 0
	addi $t1, $zero, 0 # i = 0
	jr $ra
	
	while:
		beq $t1, $a1, exit # i < num.length
		beq $t3, 13, if_13 # if nums[i] == 13
		
		# else
		add $t0, $t0, $zero # sum = sum + nums[i]
		addi $t1, $t1, 1
		
		j while
		
		
	if_13:
		addi $t1, $t1, 2
		j while
	
	exit:
	
