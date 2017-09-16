/**   
* @Title: MyRunC.java 
* @Package cn.songzx.multithreadlock.fair.methodtest.extrun 
* @Description: TODO(��һ�仰�������ļ���ʲô) 
* @author Songzx songzx_2326@163.com   
* @date 2017��9��16�� ����7:18:01 
* @version V1.0   
*/
package cn.songzx.multithreadlock.fair.methodtest.extrun;

import cn.songzx.multithreadlock.fair.methodtest.service.MyServiceC;

/**
 * @ClassName: MyRunC
 * @Description: TODO(������һ�仰��������������)
 * @author Songzx songzx_2326@163.com
 * @date 2017��9��16�� ����7:18:01
 * 
 */
public class MyRunC {

	/**
	 * @Date: 2017��9��16������7:18:01
	 * @Title: main
	 * @Description: TODO(������һ�仰�����������������)
	 * @param args
	 * @return void ����ֵ����
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
