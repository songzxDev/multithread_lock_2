/**   
* @Title: RunTestA.java 
* @Package cn.songzx.multithreadlock.fair.test 
* @Description: TODO(��һ�仰�������ļ���ʲô) 
* @author Songzx songzx_2326@163.com   
* @date 2017��9��16�� ����5:35:34 
* @version V1.0   
*/
package cn.songzx.multithreadlock.fair.test;

import cn.songzx.multithreadlock.fair.service.MyServiceA;

/**
 * @ClassName: RunTestA
 * @Description: TODO(������һ�仰��������������)
 * @author Songzx songzx_2326@163.com
 * @date 2017��9��16�� ����5:35:34
 * 
 */
public class RunTestA {

	/**
	 * @Date: 2017��9��16������5:35:34
	 * @Title: main
	 * @Description: TODO(������һ�仰�����������������)
	 * @param args
	 * @return void ����ֵ����
	 */
	public static void main(String[] args) {
		MyServiceA service = new MyServiceA();
		service.serviceMethodA();
	}

}
