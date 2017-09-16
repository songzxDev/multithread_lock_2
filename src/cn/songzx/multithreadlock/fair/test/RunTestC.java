/**   
* @Title: RunTestC.java 
* @Package cn.songzx.multithreadlock.fair.test 
* @Description: TODO(用一句话描述该文件做什么) 
* @author Songzx songzx_2326@163.com   
* @date 2017年9月16日 下午6:16:55 
* @version V1.0   
*/
package cn.songzx.multithreadlock.fair.test;

import cn.songzx.multithreadlock.fair.service.MyServiceC;

/**
 * @ClassName: RunTestC
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Songzx songzx_2326@163.com
 * @date 2017年9月16日 下午6:16:55
 * 
 */
public class RunTestC {

	/**
	 * @Date: 2017年9月16日下午6:16:55
	 * @Title: main
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param args
	 * @return void 返回值类型
	 */
	public static void main(String[] args) throws Exception {
		final MyServiceC service = new MyServiceC();

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
