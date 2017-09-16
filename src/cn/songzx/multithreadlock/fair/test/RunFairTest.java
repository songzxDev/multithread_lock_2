/**   
F* @Title: RunFairTest.java 
* @Package cn.songzx.multithreadlock.fair.test 
* @Description: TODO(用一句话描述该文件做什么) 
* @author Songzx songzx_2326@163.com   
* @date 2017年9月16日 下午2:41:19 
* @version V1.0   
*/
package cn.songzx.multithreadlock.fair.test;

import cn.songzx.multithreadlock.fair.service.MyFairService;

/**
 * @ClassName: RunFairTest
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Songzx songzx_2326@163.com
 * @date 2017年9月16日 下午2:41:19
 * 
 */
public class RunFairTest {

	/**
	 * @Date: 2017年9月16日下午2:41:19
	 * @Title: main
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param args
	 * @return void 返回值类型
	 */
	public static void main(String[] args) {
		final MyFairService service = new MyFairService(true);
		Runnable runnable = new Runnable() {
			public void run() {
				System.out.println("★线程" + Thread.currentThread().getName() + " 运行了！");
				service.serviceMethod();
			}
		};
		Thread[] threadArray = new Thread[10];
		for (int i = 0; i < threadArray.length; i++) {
			threadArray[i] = new Thread(runnable);
		}
		for (int i = 0; i < threadArray.length; i++) {
			threadArray[i].start();
		}

	}

}
