# 스프링

[start.spring.io](http://start.spring.io) 를 통해 프로젝트를 자동생성

SpringBoot 애플리케이션은 자체적으로 톰캣 웹서버를 내장하고 있다

따라서 build된 jar을 실행하기만 하면 알아서 서버 설치까지 다 된다

---

> @GetMapping

@GetMapping 을 통해 URL 뒤에 ‘/’ Path를 잘라 함수랑 매핑한다

---

```java
//Controller
@GetMapping("hello")
public String hello(Model model) {
		model.addAttribute("data", "hello!!");
		return "hello";
}

//resources/templates/hello.html
<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head>
		<title>Hello</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
<p th:text="'안녕하세요. ' + ${data}" >안녕하세요. 손님</p>
</body>
</html>
```

- 컨트롤러에서 반환한 리턴 값으로 viewReslover 가 화면을 찾아서 처리한다
- 스프링 부트 템플릿엔진 기본 viewName 매핑
- resources:templates/+{ViewName}+.html
- 리턴 값 ‘hello’가 ViewName에 매핑되어 hello.html 로 전달

---

> **@ResponseBody**


**@ResponseBody 를 통해 http body 의 문자값을 그대로 반환한다**

viewResolver 가 쓰이지 않고 HttpMessageConverter 로 변환 후 http body로 보내게 된다

- 기본 문자처리 : StringHttpMessageconverter
- 기본 객체처리 : MappingJackson2HttpMessageConverter → Json 으로 반환

---

> **@Test**
>
- @Test 를 통해 테스트케이스 작성

> **@AfterEach**
>
- @AfterEach 를 통해 각 테스트가 종료될 때마다 @AfterEach의 메소드를 실행시킨다
- 테스트는 순서가 없이 실행되기 때문에, 각각 독립성을 가지고 있어야 한다

> **@BeforeEach**
>
- 각 테스트 전에 호출된다

---

```java
MemoryMemberRepository memberRepository = new MemoryMemberRepository();
MemberService memberService = new MemberService();
//이렇게 만든다면 MemberService 에서 생성한 MemoryMemberRepository와 테스트케이스의 MemoryMemberRepository는 다른 객체가 된다. 따라서 같은 인스턴스를 쓰게 만들기 위해 MemberService 생성자에 MemoryMemberRespository 를 넣어준다.

public class MemberService {
	private final MemberRepository memberRepository;
	public MemberService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}
...
}
```

이처럼 외부에서 정보를 넣어주는 것을 DI (의존성 주입)이라고 한다