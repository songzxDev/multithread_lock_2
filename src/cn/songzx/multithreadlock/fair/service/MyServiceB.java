/**   
* @Title: MyServiceB.java 
* @Package cn.songzx.multithreadlock.fair.service 
* @Description: TODO(用一句话描述该文件做什么) 
* @author Songzx songzx_2326@163.com   
* @date 2017年9月16日 下午5:43:14 
* @version V1.0   
*/
package cn.songzx.multithreadlock.fair.service;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName: MyServiceB
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Songzx songzx_2326@163.com
 * @date 2017年9月16日 下午5:43:14
 * 
 */
public class MyServiceB {
	public ReentrantLock lock = new ReentrantLock();

	public void serviceMethodA() {
		try {
			lock.lock();
			System.out.println("ThreadName=" + Thread.currentThread().getName() + "，进入方法！");
			Thread.sleep(Integer.MAX_VALUE);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}

	}
}
