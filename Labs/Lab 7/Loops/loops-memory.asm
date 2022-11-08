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
max: 
	ja $ra
	


# public int sum13(int[] nums) {
#    int sum = 0;
#    int i = 0;
#      
#    while(i < nums.length) {
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
	ja $ra