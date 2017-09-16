/**   
F* @Title: RunFairTest.java 
* @Package cn.songzx.multithreadlock.fair.test 
* @Description: TODO(��һ�仰�������ļ���ʲô) 
* @author Songzx songzx_2326@163.com   
* @date 2017��9��16�� ����2:41:19 
* @version V1.0   
*/
package cn.songzx.multithreadlock.fair.test;

import cn.songzx.multithreadlock.fair.service.MyFairService;

/**
 * @ClassName: RunFairTest
 * @Description: TODO(������һ�仰��������������)
 * @author Songzx songzx_2326@163.com
 * @date 2017��9��16�� ����2:41:19
 * 
 */
public class RunFairTest {

	/**
	 * @Date: 2017��9��16������2:41:19
	 * @Title: main
	 * @Description: TODO(������һ�仰�����������������)
	 * @param args
	 * @return void ����ֵ����
	 */
	public static void main(String[] args) {
		final MyFairService service = new MyFairService(true);
		Runnable runnable = new Runnable() {
			public void run() {
				System.out.println("���߳�" + Thread.currentThread().getName() + " �����ˣ�");
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
