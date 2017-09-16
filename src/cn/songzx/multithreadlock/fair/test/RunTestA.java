/**   
* @Title: RunTestA.java 
* @Package cn.songzx.multithreadlock.fair.test 
* @Description: TODO(用一句话描述该文件做什么) 
* @author Songzx songzx_2326@163.com   
* @date 2017年9月16日 下午5:35:34 
* @version V1.0   
*/
package cn.songzx.multithreadlock.fair.test;

import cn.songzx.multithreadlock.fair.service.MyServiceA;

/**
 * @ClassName: RunTestA
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Songzx songzx_2326@163.com
 * @date 2017年9月16日 下午5:35:34
 * 
 */
public class RunTestA {

	/**
	 * @Date: 2017年9月16日下午5:35:34
	 * @Title: main
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param args
	 * @return void 返回值类型
	 */
	public static void main(String[] args) {
		MyServiceA service = new MyServiceA();
		service.serviceMethodA();
	}

}
