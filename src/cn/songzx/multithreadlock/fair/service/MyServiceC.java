/**   
* @Title: MyServiceC.java 
* @Package cn.songzx.multithreadlock.fair.service 
* @Description: TODO(用一句话描述该文件做什么) 
* @author Songzx songzx_2326@163.com   
* @date 2017年9月16日 下午6:13:17 
* @version V1.0   
*/
package cn.songzx.multithreadlock.fair.service;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName: MyServiceC
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Songzx songzx_2326@163.com
 * @date 2017年9月16日 下午6:13:17
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
			 * getWaitQueueLength(condition)方法的作用是返回等待与此锁定相关的给定条件condition线程估计数，
			 * 比如有5个线程，每个线程都执行了同一个condition对象的await()方法，则调用getWaitQueueLength(
			 * condition)方法时返回的int值是5
			 */
			System.out.println("有【" + lock.getWaitQueueLength(newCondition) + "】个线程正在等待newCondition！");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
}
