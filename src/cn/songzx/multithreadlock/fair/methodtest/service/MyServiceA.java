/**   
* @Title: MyServiceA.java 
* @Package cn.songzx.multithreadlock.fair.methodtest.service 
* @Description: TODO(��һ�仰�������ļ���ʲô) 
* @author Songzx songzx_2326@163.com   
* @date 2017��9��16�� ����6:27:16 
* @version V1.0   
*/
package cn.songzx.multithreadlock.fair.methodtest.service;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName: MyServiceA
 * @Description: TODO(������һ�仰��������������)
 * @author Songzx songzx_2326@163.com
 * @date 2017��9��16�� ����6:27:16
 * 
 */
public class MyServiceA {

	public ReentrantLock lock = new ReentrantLock();
	public Condition newCondition = lock.newCondition();

	public void waitMethod() {
		try {
			lock.lock();
			Thread.sleep(50000L);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
}
