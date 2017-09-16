/**   
* @Title: RunTestB.java 
* @Package cn.songzx.multithreadlock.fair.test 
* @Description: TODO(��һ�仰�������ļ���ʲô) 
* @author Songzx songzx_2326@163.com   
* @date 2017��9��16�� ����5:46:02 
* @version V1.0   
*/
package cn.songzx.multithreadlock.fair.test;

import cn.songzx.multithreadlock.fair.service.MyServiceB;

/**
 * @ClassName: RunTestB
 * @Description: TODO(������һ�仰��������������)
 * @author Songzx songzx_2326@163.com
 * @date 2017��9��16�� ����5:46:02
 * 
 */
public class RunTestB {

	/**
	 * @Date: 2017��9��16������5:46:02
	 * @Title: main
	 * @Description: TODO(������һ�仰�����������������)
	 * @param args
	 * @return void ����ֵ����
	 */
	public static void main(String[] args) throws Exception {
		final MyServiceB service = new MyServiceB();

		Runnable runnable = new Runnable() {
			public void run() {
				service.serviceMethodA();
			}
		};

		Thread[] threadArray = new Thread[10];

		for (int i = 0; i < threadArray.length; i++) {
			threadArray[i] = new Thread(runnable);
		}
		for (int i = 0; i < threadArray.length; i++) {
			threadArray[i].start();
		}

		Thread.sleep(3000L);
		/*
		 * getQueueLength()�������Ƿ������ڵȴ���ȡ���������̹߳�����Ŀ��������5���̣߳�1���߳�����ִ����await()��������ô��
		 * ����getQueueLength()�����󷵻�ֵ��4��˵����4���߳�ͬʱ�ڵȴ�lock���ͷš�
		 */
		System.out.println("���߳�����" + service.lock.getQueueLength() + "�ڵȺ��ȡ����");
	}

}
