/**   
* @Title: MyFairService.java 
* @Package cn.songzx.multithreadlock.fair.service 
* @Description: TODO(用一句话描述该文件做什么) 
* @author Songzx songzx_2326@163.com   
* @date 2017年9月16日 下午2:33:08 
* @version V1.0   
*/
package cn.songzx.multithreadlock.fair.service;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName: MyFairService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Songzx songzx_2326@163.com
 * @date 2017年9月16日 下午2:33:08
 * 
 */
public class MyFairService {

	private ReentrantLock lock;

	/**
	 * @Date: 2017年9月16日下午2:33:38
	 * @Title: MyFairService.java
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param lock
	 */
	public MyFairService(boolean isFair) {
		super();
		lock = new ReentrantLock(isFair);
	}

	public void serviceMethod() {
		try {
			lock.lock();
			System.out.println("ThreadName=" + Thread.currentThread().getName() + " 获得锁定！");
		} finally {
			lock.unlock();
		}
	}

}
