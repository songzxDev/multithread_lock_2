/**   
* @Title: MyServiceB.java 
* @Package cn.songzx.multithreadlock.fair.methodtest.service 
* @Description: TODO(用一句话描述该文件做什么) 
* @author Songzx songzx_2326@163.com   
* @date 2017年9月16日 下午6:42:53 
* @version V1.0   
*/
package cn.songzx.multithreadlock.fair.methodtest.service;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName: MyServiceB
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Songzx songzx_2326@163.com
 * @date 2017年9月16日 下午6:42:53
 * 
 */
public class MyServiceB {

	public ReentrantLock lock = new ReentrantLock();

	public Condition newCondition = lock.newCondition();

	public void waitMethod() {
		try {
			lock.lock();
			newCondition.await();
			System.out.println("◆◆◆◆◆◆◆◆◆◆" + Thread.currentThread().getName() + "◆◆◆◆◆◆◆◆◆◆" + System.currentTimeMillis());
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
			 * hasWaiters(condition)的作用是查询是否有线程正在等待与此锁定有关的condition条件
			 */
			System.out.println(Thread.currentThread().getName());
			System.out.println("有没有线程正在等待newCondition？" + lock.hasWaiters(newCondition) + " 线程数目是多少？" + lock.getWaitQueueLength(newCondition));
			newCondition.signal();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
}
