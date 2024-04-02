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
