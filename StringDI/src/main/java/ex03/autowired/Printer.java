package ex03.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Printer {
	/*
	 * Autowired
	 * 빈객체를 자동으로 주입하게 되는데 ,먼저 타입으로 찾아서 주입 , 이름으로 찾아서 주입
	 * 
	 * 생성자 , 메서드 , 멤버변수에 모두 사용 가능함.
	 * 
	 * @Autowired(required = false): 이 속성을 사용하면 해당 의존성이 선택적이 됩니다. 
	 * 즉, @Autowired가 붙은 빈이 없으면 빈을 생성하지 않고 에러가 발생하지 않습니다.
	 * 멤버변수에 autowired 사용할 때는 기본 생성자가 반드시 필요함
	 * 
	 * required =false 옵션은
	 * 스프링이 주입할 빈이 없으면 에러를 발생시키는데 , 이거를 무시하고 지나가주세요. 라는 속성입니다.
	 * Qualifier - 빈 강제 연결
	 * 컨테이너에 동일 객체가 여러개 있을 때 , 이름으로 강제 주입을 넣어주는 어노테이션
	 *
	 */


	@Autowired //(required = false)
	@Qualifier("doc1")
	private Document document;
	
	public Printer() {//기본 생성자
		
	}
	

	//생성자 주입
	public Printer(Document document) {
		this.document=document;
	}

	
	public Document getDocument() {
		return document;
	}
	//세터 주입
	public void setDocument(Document document) {
		this.document = document;
	}
	
	
	
	
	
}
