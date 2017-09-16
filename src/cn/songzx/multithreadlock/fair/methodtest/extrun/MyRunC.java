/**   
* @Title: MyRunC.java 
* @Package cn.songzx.multithreadlock.fair.methodtest.extrun 
* @Description: TODO(用一句话描述该文件做什么) 
* @author Songzx songzx_2326@163.com   
* @date 2017年9月16日 下午7:18:01 
* @version V1.0   
*/
package cn.songzx.multithreadlock.fair.methodtest.extrun;

import cn.songzx.multithreadlock.fair.methodtest.service.MyServiceC;

/**
 * @ClassName: MyRunC
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Songzx songzx_2326@163.com
 * @date 2017年9月16日 下午7:18:01
 * 
 */
public class MyRunC {

	/**
	 * @Date: 2017年9月16日下午7:18:01
	 * @Title: main
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param args
	 * @return void 返回值类型
	 */
	public static void main(String[] args) {
		final MyServiceC serviceA = new MyServiceC(true);
		Runnable runnableA = new Runnable() {
			public void run() {
				serviceA.serviceMethod();
			}
		};
		Thread threadA = new Thread(runnableA);
		threadA.start();

		final MyServiceC serviceB = new MyServiceC(false);
		Runnable runnableB = new Runnable() {
			public void run() {
				serviceB.serviceMethod();
			}
		};
		Thread threadB = new Thread(runnableB);
		threadB.start();
	}

}
