/**   
* @Title: MyFairService.java 
* @Package cn.songzx.multithreadlock.fair.service 
* @Description: TODO(��һ�仰�������ļ���ʲô) 
* @author Songzx songzx_2326@163.com   
* @date 2017��9��16�� ����2:33:08 
* @version V1.0   
*/
package cn.songzx.multithreadlock.fair.service;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName: MyFairService
 * @Description: TODO(������һ�仰��������������)
 * @author Songzx songzx_2326@163.com
 * @date 2017��9��16�� ����2:33:08
 * 
 */
public class MyFairService {

	private ReentrantLock lock;

	/**
	 * @Date: 2017��9��16������2:33:38
	 * @Title: MyFairService.java
	 * @Description: TODO(������һ�仰�����������������)
	 * @param lock
	 */
	public MyFairService(boolean isFair) {
		super();
		lock = new ReentrantLock(isFair);
	}

	public void serviceMethod() {
		try {
			lock.lock();
			System.out.println("ThreadName=" + Thread.currentThread().getName() + " ���������");
		} finally {
			lock.unlock();
		}
	}

}
