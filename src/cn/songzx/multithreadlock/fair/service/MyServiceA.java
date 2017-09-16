/**   
* @Title: MyServiceA.java 
* @Package cn.songzx.multithreadlock.fair.service 
* @Description: TODO(��һ�仰�������ļ���ʲô) 
* @author Songzx songzx_2326@163.com   
* @date 2017��9��16�� ����5:31:42 
* @version V1.0   
*/
package cn.songzx.multithreadlock.fair.service;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName: MyServiceA
 * @Description: TODO(������һ�仰��������������)
 * @author Songzx songzx_2326@163.com
 * @date 2017��9��16�� ����5:31:42
 * 
 */
public class MyServiceA {

	private ReentrantLock lock = new ReentrantLock();

	public void serviceMethodA() {
		try {
			lock.lock();
			System.out.print("��ǰ�̵߳������ǣ�" + Thread.currentThread().getName()+"��");
			System.out.println("serviceMethodA getHoldCount=" + lock.getHoldCount());
			serviceMethodB();
		} finally {
			lock.unlock();
		}
	}

	public void serviceMethodB() {
		try {
			lock.lock();
			// getHoldCount()�������ǲ�ѯ��ǰ�̱߳��ִ������ĸ�����Ҳ���ǵ���lock()�����Ĵ���
			System.out.print("��ǰ�̵߳������ǣ�" + Thread.currentThread().getName()+"��");
			System.out.println("serviceMethodB getHoldCount=" + lock.getHoldCount());
			serviceMethodC();
		} finally {
			lock.unlock();
		}
	}
	
	public void serviceMethodC() {
		try {
			lock.lock();
			// getHoldCount()�������ǲ�ѯ��ǰ�̱߳��ִ������ĸ�����Ҳ���ǵ���lock()�����Ĵ���
			System.out.print("��ǰ�̵߳������ǣ�" + Thread.currentThread().getName()+"��");
			System.out.println("serviceMethodC getHoldCount=" + lock.getHoldCount());
		} finally {
			lock.unlock();
		}
	}
}
