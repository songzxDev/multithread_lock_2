/**   
* @Title: MyRunA.java 
* @Package cn.songzx.multithreadlock.fair.methodtest.extrun 
* @Description: TODO(��һ�仰�������ļ���ʲô) 
* @author Songzx songzx_2326@163.com   
* @date 2017��9��16�� ����6:30:17 
* @version V1.0   
*/
package cn.songzx.multithreadlock.fair.methodtest.extrun;

import cn.songzx.multithreadlock.fair.methodtest.service.MyServiceA;

/**
 * @ClassName: MyRunA
 * @Description: TODO(������һ�仰��������������)
 * @author Songzx songzx_2326@163.com
 * @date 2017��9��16�� ����6:30:17
 * 
 */
public class MyRunA {

	/**
	 * @Date: 2017��9��16������6:30:17
	 * @Title: main
	 * @Description: TODO(������һ�仰�����������������)
	 * @param args
	 * @return void ����ֵ����
	 */
	public static void main(String[] args) throws Exception {
		final MyServiceA service = new MyServiceA();
		Runnable runnable = new Runnable() {
			public void run() {
				service.waitMethod();
			}
		};
		Thread threadA = new Thread(runnable);
		threadA.start();
		Thread.sleep(3000L);
		Thread threadB = new Thread(runnable);
		threadB.start();
		Thread.sleep(3000L);
		/*
		 * ����hasQueueThread(thread)�������ǲ�ѯ�ƶ����߳��Ƿ����ڵȴ���ȡ������
		 */
		System.out.println(service.lock.hasQueuedThread(threadA));
		System.out.println(service.lock.hasQueuedThread(threadB));
		/*
		 * ����hasQueueThreads()�������ǲ�ѯ�Ƿ����߳����ڵȴ���ȡ������
		 */
		System.out.println(service.lock.hasQueuedThreads());
	}

}
