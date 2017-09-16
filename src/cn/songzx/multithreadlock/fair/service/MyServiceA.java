/**   
* @Title: MyServiceA.java 
* @Package cn.songzx.multithreadlock.fair.service 
* @Description: TODO(用一句话描述该文件做什么) 
* @author Songzx songzx_2326@163.com   
* @date 2017年9月16日 下午5:31:42 
* @version V1.0   
*/
package cn.songzx.multithreadlock.fair.service;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName: MyServiceA
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Songzx songzx_2326@163.com
 * @date 2017年9月16日 下午5:31:42
 * 
 */
public class MyServiceA {

	private ReentrantLock lock = new ReentrantLock();

	public void serviceMethodA() {
		try {
			lock.lock();
			System.out.print("当前线程的名字是：" + Thread.currentThread().getName()+"，");
			System.out.println("serviceMethodA getHoldCount=" + lock.getHoldCount());
			serviceMethodB();
		} finally {
			lock.unlock();
		}
	}

	public void serviceMethodB() {
		try {
			lock.lock();
			// getHoldCount()的作用是查询当前线程保持此锁定的个数，也就是调用lock()方法的次数
			System.out.print("当前线程的名字是：" + Thread.currentThread().getName()+"，");
			System.out.println("serviceMethodB getHoldCount=" + lock.getHoldCount());
			serviceMethodC();
		} finally {
			lock.unlock();
		}
	}
	
	public void serviceMethodC() {
		try {
			lock.lock();
			// getHoldCount()的作用是查询当前线程保持此锁定的个数，也就是调用lock()方法的次数
			System.out.print("当前线程的名字是：" + Thread.currentThread().getName()+"，");
			System.out.println("serviceMethodC getHoldCount=" + lock.getHoldCount());
		} finally {
			lock.unlock();
		}
	}
}
