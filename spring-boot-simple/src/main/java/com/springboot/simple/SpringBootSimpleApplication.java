package com.springboot.simple;

import java.io.PrintStream;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.Banner;
import org.springframework.boot.Banner.Mode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class SpringBootSimpleApplication 
{
	//private static final Logger log = LoggerFactory.getLogger(SpringBootSimpleApplication.class);
	
	public static void main(String[] args) throws Exception {
		/* V.1
		SpringApplication.run(SpringBootSimpleApplication.class, args); */
		/* V.2
		SpringApplication app = new SpringApplication(SpringBootSimpleApplication.class);
		app.run(args); */
		
		/* V.3
		SpringApplication app = new SpringApplication(SpringBootSimpleApplication.class);
		app.setBanner(new Banner() {			
			@Override
			public void printBanner(Environment env, Class<?> srcClass, PrintStream out) {
				// TODO Auto-generated method stub
				out.print("\n\n\tAwsome my new banner!\n\n".toUpperCase());
			}
		});
		app.run(args); */
				
		/* V.4
		SpringApplication app = new SpringApplication(SpringBootSimpleApplication.class);
		app.setBannerMode(Mode.LOG);		
		app.run(args); */
		
		/* V.5
		new SpringApplicationBuilder()
		.bannerMode(Banner.Mode.OFF)
		.sources(SpringBootSimpleApplication.class)
		.run(args); */
		
		/* V.6
		new SpringApplicationBuilder(SpringBootSimpleApplication.class)
		.logStartupInfo(false)
		.run(args); */
		
		/* V.7
		new SpringApplicationBuilder(SpringBootSimpleApplication.class)
		.profiles("prod", "cloud")
		.run(args); */
		
		/* V.8
		Logger log = LoggerFactory.getLogger(SpringBootSimpleApplication.class);
		new SpringApplicationBuilder(SpringBootSimpleApplication.class)
		.listeners(new ApplicationListener<ApplicationEvent>() {
			@Override
			public void onApplicationEvent(ApplicationEvent evt) {
				// TODO Auto-generated method stub
				log.info("#### > " + evt.getClass().getCanonicalName());
			}			
		})
		.run(args); */
		
		/* V.9
		new SpringApplicationBuilder(SpringBootSimpleApplication.class)
        .web(false)
        .run(args); */
		
		SpringApplication.run(SpringBootSimpleApplication.class, args);
	}
	
	@Component
	class MyComponent 
	{
		private final Logger log = LoggerFactory.getLogger(MyComponent.class);
		
		@Autowired
		public MyComponent(ApplicationArguments args) {
			// TODO Auto-generated constructor stub
			//--enable 또는 -enable=true 형태로 enable 인자가 전달된 경우,
			boolean enable = args.containsOption("enable");
			
			if (enable) {
				log.info("## > enable 옵션 활성중...");
			}
			
			//myfile.txt 또는 files=["myfile.txt"], 아니면 enable=true, files=["myfile.txt"] 형태로 인자 파일을 가져온다.
			log.info("## > 다른 인자...");
			List<String> _args = args.getNonOptionArgs();
			
			if (!_args.isEmpty()) {
				_args.forEach(file -> log.info(file));
			}
		}
	}
}
