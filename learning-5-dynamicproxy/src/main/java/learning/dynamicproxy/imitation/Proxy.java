package learning.dynamicproxy.imitation;

import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

public class Proxy {
	public static Object newProxyInstance(Class infce, InvocationHandler h) throws Exception {
		String methodStr = "";
		String rt = "\r\n";
		
		Method[] methods = infce.getMethods();
		/*
		for(Method m : methods) {
			methodStr += "@Override" + rt + 
						 "public void " + m.getName() + "() {" + rt +
						 	"   long start = System.currentTimeMillis();" + rt +
							"   System.out.println(\"starttime:\" + start);" + rt +
							"   t." + m.getName() + "();" + rt +
							"   long end = System.currentTimeMillis();" + rt +
							"   System.out.println(\"time:\" + (end-start));" + rt +
						 "}";
		}
		*/
		for(Method m : methods) {
			methodStr += "@Override" + rt + 
						 "public void " + m.getName() + "() {" + rt +
						 "    try {" + rt +
						 "    Method md = " + infce.getName() + ".class.getMethod(\"" + m.getName() + "\");" + rt +
						 "    h.invoke(this, md);" + rt +
						 "    }catch(Exception e) {e.printStackTrace();}" + rt +
						
						 "}";
		}
		
		String src = 
			"package com.mbs.proxy;" +  rt +
			"import java.lang.reflect.Method;" + rt +
			"import learning.dynamicproxy.imitation.InvocationHandler;" + rt +
			"public class $Proxy1 implements " + infce.getName() + "{" + rt +
			"    public $Proxy1(InvocationHandler h) {" + rt +
			"        this.h = h;" + rt +
			"    }" + rt +
			
			
			"    learning.dynamicproxy.imitation.InvocationHandler h;" + rt +
							
			methodStr +
			"}";
		String fileName = "D:/workspace-dfh5/java-learning-example/learning-5-dynamicproxy/src/main/java/com/mbs/proxy/$Proxy1.java";
		File f = new File(fileName);
		FileWriter fw = new FileWriter(f);
		fw.write(src);
		fw.flush();
		fw.close();
		
		//compile
		// 通过ToolProvider类的静态方法getSystemJavaCompiler来得到一个JavaCompiler接口的实例。
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		// 获取一个文件管理器StandardJavaFileManage
		StandardJavaFileManager fileMgr = compiler.getStandardFileManager(null, null, null);
		// 文件管理器根与文件连接起来
		Iterable units = fileMgr.getJavaFileObjects(fileName);
		// 创建编译的任务
		CompilationTask t = compiler.getTask(null, fileMgr, null, null, null, units);
		// 执行编译
		t.call();
		fileMgr.close();
		
		//load into memory and create an instance
		URL[] urls = new URL[] {new URL("file:/" + "D:/workspace-dfh5/java-learning-example/learning-5-dynamicproxy/src/main/java/com/mbs/proxy/")};
		URLClassLoader ul = new URLClassLoader(urls);
		Class c = ul.loadClass("com.mbs.proxy.$Proxy1");
		System.out.println(c);
		
		Constructor ctr = c.getConstructor(InvocationHandler.class);
		Object m = ctr.newInstance(h);
		//m.move();
		return m;
	}
}
