package com.Lect.week04;

@Component
@PropertySource("classpath:static/extrenal.properties")
@ConfigurationProperties(prefix = "spring.datasource")
@Getter
@Setter
public class ExternalConfigComponent {
	@Value("${server.port}")
	private String serverPort;

	@Value("${server.address}")
	private String serverAddress;
	
	@Value("${message.greeting}")
	private String greeting;
	
	private String url;
	private String username;
	private String password;
	
}
