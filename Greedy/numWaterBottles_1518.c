#include<stdio.h> 

int numWaterBottles(int numBottles, int numExchange){
	if(numBottles<numExchange){
		return numBottles;
	}
        //�ܹ��ܺ�ƿ��
        int sum=numBottles;
        //Ŀǰ��ƿ����
        int empties=numBottles;
        
        //ֻҪ��ƿ�����������轻��ƿ�������Ϳ��Ի���
        while(empties>=numExchange){
            //������ƿ��
            int ex=empties/numExchange;
            //������Ŀ�ƿ����ʣ����
            empties=empties%numExchange+ex; //or empties=empties-ex*numExchange+ex;
            //��ƿ�����ϻ���ƿ��
            sum+=ex;
        }
        return sum;
    }
int main(){
	
	printf("�ܺ�%dƿ��",numWaterBottles(3,3));
}
