package ex04.quiz;

import org.springframework.context.support.GenericXmlApplicationContext;

import ex03.autowired.Printer;

public class MainClass {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("computerInfo.xml");
		
		Computer pt=ctx.getBean("computer",Computer.class);
		pt.computerInfo();
		
	}

}
