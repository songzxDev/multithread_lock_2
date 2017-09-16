/**   
* @Title: MyRunB.java 
* @Package cn.songzx.multithreadlock.fair.methodtest.extrun 
* @Description: TODO(��һ�仰�������ļ���ʲô) 
* @author Songzx songzx_2326@163.com   
* @date 2017��9��16�� ����6:47:20 
* @version V1.0   
*/
package cn.songzx.multithreadlock.fair.methodtest.extrun;

import cn.songzx.multithreadlock.fair.methodtest.service.MyServiceB;

/**
 * @ClassName: MyRunB
 * @Description: TODO(������һ�仰��������������)
 * @author Songzx songzx_2326@163.com
 * @date 2017��9��16�� ����6:47:20
 * 
 */
public class MyRunB {

	/**
	 * @Date: 2017��9��16������6:47:20
	 * @Title: main
	 * @Description: TODO(������һ�仰�����������������)
	 * @param args
	 * @return void ����ֵ����
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
