/**   
* @Title: MyServiceB.java 
* @Package cn.songzx.multithreadlock.fair.methodtest.service 
* @Description: TODO(��һ�仰�������ļ���ʲô) 
* @author Songzx songzx_2326@163.com   
* @date 2017��9��16�� ����6:42:53 
* @version V1.0   
*/
package cn.songzx.multithreadlock.fair.methodtest.service;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName: MyServiceB
 * @Description: TODO(������һ�仰��������������)
 * @author Songzx songzx_2326@163.com
 * @date 2017��9��16�� ����6:42:53
 * 
 */
public class MyServiceB {

	public ReentrantLock lock = new ReentrantLock();

	public Condition newCondition = lock.newCondition();

	public void waitMethod() {
		try {
			lock.lock();
			newCondition.await();
			System.out.println("��������������������" + Thread.currentThread().getName() + "��������������������" + System.currentTimeMillis());
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
			 * hasWaiters(condition)�������ǲ�ѯ�Ƿ����߳����ڵȴ���������йص�condition����
			 */
			System.out.println(Thread.currentThread().getName());
			System.out.println("��û���߳����ڵȴ�newCondition��" + lock.hasWaiters(newCondition) + " �߳���Ŀ�Ƕ��٣�" + lock.getWaitQueueLength(newCondition));
			newCondition.signal();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
}
