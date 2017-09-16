/**   
* @Title: MyRunB.java 
* @Package cn.songzx.multithreadlock.fair.methodtest.extrun 
* @Description: TODO(用一句话描述该文件做什么) 
* @author Songzx songzx_2326@163.com   
* @date 2017年9月16日 下午6:47:20 
* @version V1.0   
*/
package cn.songzx.multithreadlock.fair.methodtest.extrun;

import cn.songzx.multithreadlock.fair.methodtest.service.MyServiceB;

/**
 * @ClassName: MyRunB
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Songzx songzx_2326@163.com
 * @date 2017年9月16日 下午6:47:20
 * 
 */
public class MyRunB {

	/**
	 * @Date: 2017年9月16日下午6:47:20
	 * @Title: main
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param args
	 * @return void 返回值类型
	 */
	public static void main(String[] args) throws Exception {
		final MyServiceB service = new MyServiceB();
		Runnable runnable = new Runnable() {
			public void run() {
				service.waitMethod();
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
		service.notifyMethod();
	}

}
