package cl.ml.ceppi.test;

import java.util.Set;

import org.reflections.Reflections;
import org.reflections.scanners.ResourcesScanner;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.reflections.util.FilterBuilder;

public class Test {
	
	public static void main(String[] args) {
	
		String pkg = "cl.ml.ceppi.core";
		StringBuffer sb;
        Set<Class<? extends Object>> clazzSet = getClazzSet(pkg);
        for (Class<? extends Object> clazz : clazzSet) 
        {
        	sb = new StringBuffer();
        	sb.append("<value>");
            sb.append(clazz.getName());
            sb.append("</value>");
            System.out.println(sb.toString());
        }
		
		
	}
	
	public static Set<Class<? extends Object>> getClazzSet(String pkg) {
        // prepare reflection, include direct subclass of Object.class
        Reflections reflections = new Reflections(new ConfigurationBuilder().setScanners(new SubTypesScanner(false), new ResourcesScanner())
                .setUrls(ClasspathHelper.forClassLoader(ClasspathHelper.classLoaders(new ClassLoader[0])))
                .filterInputsBy(new FilterBuilder().includePackage(pkg)));

        return reflections.getSubTypesOf(Object.class);
    }

}
