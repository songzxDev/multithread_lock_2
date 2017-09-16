/**   
* @Title: MyServiceC.java 
* @Package cn.songzx.multithreadlock.fair.methodtest.service 
* @Description: TODO(用一句话描述该文件做什么) 
* @author Songzx songzx_2326@163.com   
* @date 2017年9月16日 下午7:15:28 
* @version V1.0   
*/
package cn.songzx.multithreadlock.fair.methodtest.service;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName: MyServiceC
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Songzx songzx_2326@163.com
 * @date 2017年9月16日 下午7:15:28
 * 
 */
public class MyServiceC {
	/**
	 * 默认情况下ReentrantLock类使用的是非公平锁
	 */
	private ReentrantLock lock;

	/**
	 * @Date: 2017年9月16日下午7:16:01
	 * @Title: MyServiceC.java
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param lock
	 */
	public MyServiceC(boolean isFair) {
		super();
		lock = new ReentrantLock(isFair);
	}

	public void serviceMethod() {
		try {
			/*
			 * isHeldByCurrentThread()的作用是查询当前线程是否保持锁定
			 */
			System.out.println("线程【" + Thread.currentThread().getName() + "】的锁定状态为：" + lock.isHeldByCurrentThread());
			/*
			 * isLocked()的作用是查询此锁定是否由任意线程保持
			 */
			System.out.println("线程【" + Thread.currentThread().getName() + "】此锁定是否由任意线程保持：" + lock.isLocked());
			lock.lock();
			System.out.println("线程【" + Thread.currentThread().getName() + "】的锁定状态为：" + lock.isHeldByCurrentThread());
			System.out.println("线程【" + Thread.currentThread().getName() + "】此锁定是否由任意线程保持：" + lock.isLocked());
			System.out.println("公平锁情况：" + lock.isFair());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}

	}

}
