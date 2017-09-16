/**   
* @Title: MyServiceC.java 
* @Package cn.songzx.multithreadlock.fair.methodtest.service 
* @Description: TODO(��һ�仰�������ļ���ʲô) 
* @author Songzx songzx_2326@163.com   
* @date 2017��9��16�� ����7:15:28 
* @version V1.0   
*/
package cn.songzx.multithreadlock.fair.methodtest.service;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName: MyServiceC
 * @Description: TODO(������һ�仰��������������)
 * @author Songzx songzx_2326@163.com
 * @date 2017��9��16�� ����7:15:28
 * 
 */
public class MyServiceC {
	/**
	 * Ĭ�������ReentrantLock��ʹ�õ��Ƿǹ�ƽ��
	 */
	private ReentrantLock lock;

	/**
	 * @Date: 2017��9��16������7:16:01
	 * @Title: MyServiceC.java
	 * @Description: TODO(������һ�仰�����������������)
	 * @param lock
	 */
	public MyServiceC(boolean isFair) {
		super();
		lock = new ReentrantLock(isFair);
	}

	public void serviceMethod() {
		try {
			/*
			 * isHeldByCurrentThread()�������ǲ�ѯ��ǰ�߳��Ƿ񱣳�����
			 */
			System.out.println("�̡߳�" + Thread.currentThread().getName() + "��������״̬Ϊ��" + lock.isHeldByCurrentThread());
			/*
			 * isLocked()�������ǲ�ѯ�������Ƿ��������̱߳���
			 */
			System.out.println("�̡߳�" + Thread.currentThread().getName() + "���������Ƿ��������̱߳��֣�" + lock.isLocked());
			lock.lock();
			System.out.println("�̡߳�" + Thread.currentThread().getName() + "��������״̬Ϊ��" + lock.isHeldByCurrentThread());
			System.out.println("�̡߳�" + Thread.currentThread().getName() + "���������Ƿ��������̱߳��֣�" + lock.isLocked());
			System.out.println("��ƽ�������" + lock.isFair());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}

	}

}
