/**   
* @Title: MyServiceC.java 
* @Package cn.songzx.multithreadlock.fair.service 
* @Description: TODO(��һ�仰�������ļ���ʲô) 
* @author Songzx songzx_2326@163.com   
* @date 2017��9��16�� ����6:13:17 
* @version V1.0   
*/
package cn.songzx.multithreadlock.fair.service;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName: MyServiceC
 * @Description: TODO(������һ�仰��������������)
 * @author Songzx songzx_2326@163.com
 * @date 2017��9��16�� ����6:13:17
 * 
 */
public class MyServiceC {
	private ReentrantLock lock = new ReentrantLock();
	private Condition newCondition = lock.newCondition();

	public void waitMethod() {
		try {
			lock.lock();
			newCondition.await();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public void notifyMethod() {
		try {
			lock.lock();
			/*
			 * getWaitQueueLength(condition)�����������Ƿ��صȴ����������صĸ�������condition�̹߳�������
			 * ������5���̣߳�ÿ���̶߳�ִ����ͬһ��condition�����await()�����������getWaitQueueLength(
			 * condition)����ʱ���ص�intֵ��5
			 */
			System.out.println("�С�" + lock.getWaitQueueLength(newCondition) + "�����߳����ڵȴ�newCondition��");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
}
