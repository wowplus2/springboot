package com.springboot.myjurnal;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.activemq.ActiveMQAutoConfiguration;
import org.springframework.context.annotation.Bean;

import com.springboot.myjurnal.domain.Journal;
import com.springboot.myjurnal.repository.JournalRepository;

/* @Configuration + @EnableAutoConfiguration + @ComponentScan + 그외 어노테이션 들의 묶음 어노테이션이다.
 * org.springframework.boot.autoconfigure.SpringBootApplication 인터페이스 참고. */
/* @EnableAutoConfiguration: 앱에서 필요한 빈을 유추해서 구성하는 클래스 */
@SpringBootApplication(exclude= {ActiveMQAutoConfiguration.class})
public class SpringBootJournalApplication 
{
	@Bean
	/* InitializingBean은 스프링 엔진이 인스턴스 생성 후 초기화할 때 항상 호출하는 특수 클래스이다. */
	InitializingBean saveData(JournalRepository repo) {
		return () -> {
			repo.save(new Journal("스프링부트", "이제부터 스프링부트를 R&D 하기로 했다.", "2018.03.14"));
			repo.save(new Journal("JavaNetty", "이제부터 Java Netty R&D 하기로 했다.", "2018.02.14"));
			repo.save(new Journal("Golang", "고언어 고수가 되고싶다.ㅜㅜ", "2017.01.06"));
		};
	}
	
	public static void main(String[] args) {
		/* main 메서드에서 실행할 스프링 부트앱의 부트스트랩 역할을 한다. 실행 클래스로 인자를 넘긴다. */
		SpringApplication.run(SpringBootJournalApplication.class, args);
	}
}
