
//Write a program that counts the number of 1 bits in an int32_t. 

// int32_t is an integer type that's precisely 32 bits long.

public class Q4 {

	public int numberOfBits(int i){

    	i = i - ((i >>> 1) & 0x55555555);
    	i = (i & 0x33333333) + ((i >>> 2) & 0x33333333);
    	return (((i + (i >>> 4)) & 0x0F0F0F0F) * 0x01010101) >>> 24;

    }

}