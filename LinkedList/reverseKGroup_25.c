/**
25. K ��һ�鷭ת����
����һ������ÿ k ���ڵ�һ����з�ת�����㷵�ط�ת�������
k ��һ��������������ֵС�ڻ��������ĳ��ȡ�
����ڵ��������� k ������������ô�뽫���ʣ��Ľڵ㱣��ԭ��˳��


 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
  
struct ListNode* reverseNode(struct ListNode* head){
    //����㡢�ս�㲻��ת
    if(!head || !head->next) return head;
    struct ListNode* pre=NULL;
    struct ListNode* next=NULL;
    struct ListNode* cur=head;
    while(cur){
        next=cur->next;    //���浱ǰ�ڵ���¸�������ں����ķ�ת
        cur->next=pre;     //����ǰ������ӵ�ǰ�����
        pre=cur;           //����ǰ�����Ϊ��ǰ�ڵ�
        cur=next;          //�ƶ�ָ��ǰ�ڵ��ָ�룬������ת
    }
    return pre;

}

struct ListNode* reverseKGroup(struct ListNode* head, int k){
    if(!head || !head->next) return head;
    struct ListNode *dummy=(struct ListNode*)malloc(sizeof(struct ListNode));
    struct ListNode *pre=dummy;
    struct ListNode *end=dummy;
    dummy->next=head;

    while(end->next){
        for(int i=1;i<=k && end;i++){
            end=end->next;               //�ҵ�k�����β���
        }
        if(!end) break;                  //����k������ת
        struct ListNode* next=end->next; //����Ҫ��ת�������β�����¸��ڵ����ڴ�������  
        end->next=NULL;
        struct ListNode* start=pre->next;
        pre->next=reverseNode(start);    //�������ѷ�ת�Ĳ���
        start->next=next;                //ͷ�ڵ㷴ת��䵽��β�������������Ǳ����ļ�����ת���¸��ڵ�
        pre=start;                       //���Ӳ��ָ���Ϊ��ת������β��
        end=start;                       //���·�ת��ʼ��
    }
    return dummy->next;                  //��󷵻�ѽ�ڵ���¸����
}
