.globl max sum13
.data 
	example_arr: .word 2 4 6 8 10
.text
# Keilani Bailey and Sebastian Torrejon Alonzo
# ----------------------------------------------------------------------------
.text

# la $a0, example_arr
# addi $a1, $0, 5
# jal sum13
# addi $v0, $0, 10
# syscall

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
# ----------------------------------------------------------------------------	
max: 
	addi $t0, $0, 1 # i = 1
	addi $t1, $0, 0 # max = 0
	
	la $t3, ($a0) # load address of array
	lw $t2, 0($t3) # a[0]
	add $t1, $t1, $t2
	
	
	for_loop:
		slt $t4, $t0, $a1 # i < n
		beq $t4, $0, exit
		sll $t4, $t0, 2 # t4 = i*4
		add $t4, $t4, $t3 # t4 = (i*4) + array address
		lw $t5, 0($t4) # a[i]
		bgt $t5, $t1, if_state
		
		addi $t0, $t0, 1 # increment i
		j for_loop
		
	if_state:
		add $t1, $0, $t5 # max = arr[i]
		j for_loop
		
	exit:
		add $v0, $0, $t1 # v0 = max
		jr $ra

# ----------------------------------------------------------------------------		
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
#    return sum;
# }
# ----------------------------------------------------------------------------	

sum13:
	addi $t0, $0, 0 # sum = 0
	addi $t1, $0, 0 # i = 0
	la $t2, ($a0) # address of array
	j while_loop
	
	while_loop:
		bge $t1, $a1, leave # i < 0
		sll $t3, $t1, 2 # t3 = i*4
		add $t3, $t3, $t2 # t3 = (i*4) + array address
		lw $t4, 0($t3) # a[i]
		beq $t4, 13, if_13
		
		add $t0, $t0, $t4 # sum += arr[i]
		addi $t1, $t1, 1 # increment i
		j while_loop
	
	if_13:
		addi $t1, $t1, 2 # i+=2
		j while_loop
	leave:
		add $v0, $0, $t0
		jr $ra
	
