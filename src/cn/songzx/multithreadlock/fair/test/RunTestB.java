/**   
* @Title: RunTestB.java 
* @Package cn.songzx.multithreadlock.fair.test 
* @Description: TODO(用一句话描述该文件做什么) 
* @author Songzx songzx_2326@163.com   
* @date 2017年9月16日 下午5:46:02 
* @version V1.0   
*/
package cn.songzx.multithreadlock.fair.test;

import cn.songzx.multithreadlock.fair.service.MyServiceB;

/**
 * @ClassName: RunTestB
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Songzx songzx_2326@163.com
 * @date 2017年9月16日 下午5:46:02
 * 
 */
public class RunTestB {

	/**
	 * @Date: 2017年9月16日下午5:46:02
	 * @Title: main
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param args
	 * @return void 返回值类型
	 */
	public static void main(String[] args) throws Exception {
		final MyServiceB service = new MyServiceB();

		Runnable runnable = new Runnable() {
			public void run() {
				service.serviceMethodA();
			}
		};

		Thread[] threadArray = new Thread[10];

		for (int i = 0; i < threadArray.length; i++) {
			threadArray[i] = new Thread(runnable);
		}
		for (int i = 0; i < threadArray.length; i++) {
			threadArray[i].start();
		}

		Thread.sleep(3000L);
		/*
		 * getQueueLength()的作用是返回正在等待获取此锁定的线程估计数目，比如有5个线程，1个线程首先执行了await()方法，那么在
		 * 调用getQueueLength()方法后返回值是4，说明有4个线程同时在等待lock的释放。
		 */
		System.out.println("有线程数：" + service.lock.getQueueLength() + "在等候获取锁！");
	}

}
