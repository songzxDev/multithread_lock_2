/**   
* @Title: RunTestC.java 
* @Package cn.songzx.multithreadlock.fair.test 
* @Description: TODO(��һ�仰�������ļ���ʲô) 
* @author Songzx songzx_2326@163.com   
* @date 2017��9��16�� ����6:16:55 
* @version V1.0   
*/
package cn.songzx.multithreadlock.fair.test;

import cn.songzx.multithreadlock.fair.service.MyServiceC;

/**
 * @ClassName: RunTestC
 * @Description: TODO(������һ�仰��������������)
 * @author Songzx songzx_2326@163.com
 * @date 2017��9��16�� ����6:16:55
 * 
 */
public class RunTestC {

	/**
	 * @Date: 2017��9��16������6:16:55
	 * @Title: main
	 * @Description: TODO(������һ�仰�����������������)
	 * @param args
	 * @return void ����ֵ����
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
