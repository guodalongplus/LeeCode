#include<stdio.h> 

int numWaterBottles(int numBottles, int numExchange){
	if(numBottles<numExchange){
		return numBottles;
	}
        //总共能喝瓶数
        int sum=numBottles;
        //目前空瓶数量
        int empties=numBottles;
        
        //只要空瓶数量大于所需交换瓶子数量就可以换酒
        while(empties>=numExchange){
            //交换的瓶数
            int ex=empties/numExchange;
            //交换后的空瓶数量剩余量
            empties=empties%numExchange+ex; //or empties=empties-ex*numExchange+ex;
            //总瓶数加上换的瓶数
            sum+=ex;
        }
        return sum;
    }
int main(){
	
	printf("能喝%d瓶酒",numWaterBottles(3,3));
}
