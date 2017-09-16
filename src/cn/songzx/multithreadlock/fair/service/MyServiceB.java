/**   
* @Title: MyServiceB.java 
* @Package cn.songzx.multithreadlock.fair.service 
* @Description: TODO(��һ�仰�������ļ���ʲô) 
* @author Songzx songzx_2326@163.com   
* @date 2017��9��16�� ����5:43:14 
* @version V1.0   
*/
package cn.songzx.multithreadlock.fair.service;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName: MyServiceB
 * @Description: TODO(������һ�仰��������������)
 * @author Songzx songzx_2326@163.com
 * @date 2017��9��16�� ����5:43:14
 * 
 */
public class MyServiceB {
	public ReentrantLock lock = new ReentrantLock();

	public void serviceMethodA() {
		try {
			lock.lock();
			System.out.println("ThreadName=" + Thread.currentThread().getName() + "�����뷽����");
			Thread.sleep(Integer.MAX_VALUE);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}

	}
}
