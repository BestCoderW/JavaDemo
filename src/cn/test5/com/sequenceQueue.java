package cn.test5.com;

public class sequenceQueue <T>{
    final int MaxSize=10;
    private T queueArray[];
    private int front,rear;
    //����ն���
    @SuppressWarnings("unchecked")
	public sequenceQueue() {
    	front = rear=0;
    	queueArray=(T[])new Object[MaxSize];
    }
    
    //��β����Ԫ��
    @SuppressWarnings("unchecked")
	public void EnQueue(T obj)
    {
    	if((rear+1)%queueArray.length==front) {
    		T[] p=(T[])new Object[queueArray.length*2];
    		if(rear==((T[])queueArray).length-1) {
    			for(int i=1;i<=rear;i++) {
    				p[i]=queueArray[i];
    			}
    		}
    		else {
    		int i,j=1;
    		for(i=front+1;i<queueArray.length;i++) {
    			p[j]=queueArray[i];
    		}
    		for(i=0;i<=rear;i++)
    			p[j]=queueArray[i];
    		front=0;
    		rear=queueArray.length-1;
    	    }
    		queueArray=p;
    	}
    	rear=(rear+1)%queueArray.length;
    	queueArray[rear]=obj;
    }
    
    //ɾ����ͷԪ��
    public T DeQueue() {
    	if(isEmpty()) {
   		 System.out.println("�����ѿգ��޷�����");
   		 return null;
   	    }
    	front=(front+1)%queueArray.length;
    	return queueArray[front];
    }
    
    //ȡ���ж�ͷԪ��
    public T getHead() {
    	if(isEmpty()) {
      		 System.out.println("�����ѿգ��޷���ȡԪ��");
      		 return null;
        }
    	return queueArray[(front+1)%queueArray.length];
    }
    
    //�����Ԫ�ظ���
    public int size() {
    	return (rear-front+queueArray.length)%queueArray.length;
    }
    
    //�п�
    public boolean isEmpty() {
    	return rear==front;
    }
    
    //����
    public void nextOrder() {
    	int i,j=front;
    	for(i=1;i<=size();i++) {
    		j=(j+1)%queueArray.length;
    		System.out.println(queueArray[j]);
    	}
    }
    
    //����
    public void clear() {
    	front=rear=0;
    }
}
