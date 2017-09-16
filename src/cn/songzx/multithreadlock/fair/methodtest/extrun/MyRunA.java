/**   
* @Title: MyRunA.java 
* @Package cn.songzx.multithreadlock.fair.methodtest.extrun 
* @Description: TODO(用一句话描述该文件做什么) 
* @author Songzx songzx_2326@163.com   
* @date 2017年9月16日 下午6:30:17 
* @version V1.0   
*/
package cn.songzx.multithreadlock.fair.methodtest.extrun;

import cn.songzx.multithreadlock.fair.methodtest.service.MyServiceA;

/**
 * @ClassName: MyRunA
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Songzx songzx_2326@163.com
 * @date 2017年9月16日 下午6:30:17
 * 
 */
public class MyRunA {

	/**
	 * @Date: 2017年9月16日下午6:30:17
	 * @Title: main
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param args
	 * @return void 返回值类型
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
		 * 方法hasQueueThread(thread)的作用是查询制定的线程是否正在等待获取此锁定
		 */
		System.out.println(service.lock.hasQueuedThread(threadA));
		System.out.println(service.lock.hasQueuedThread(threadB));
		/*
		 * 方法hasQueueThreads()的作用是查询是否有线程正在等待获取此锁定
		 */
		System.out.println(service.lock.hasQueuedThreads());
	}

}
