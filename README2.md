@Service
public class ClientServiceDelegate {
	@Autowired
	RestTemplate restTemplate;
	
	
	public void testmessage(String msg) {
		String response = restTemplate.exchange("http://message-service/produce?msg={msg}", HttpMethod.GET, null, new ParameterizedTypeReference<String>() {
		}, msg).getBody();
		

		System.out.println("Response Received as " + response + " -  " + new Date());
	}
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
to run activemq in docker 
sudo docker run -p 61616:61616 -p 8161:8161 webcenter/activemq

access urls 
producer :	http://localhost:8080/produce?msg=hello%20shabarish
consumer : http://localhost:8080/receive

client : http://localhost:8098/produce/hello-volvo (what ever message is sent through this path param will internally call producer call and when we eventually call consumer call same mess will be displayed)

Controller code:
@RequestMapping(value="/produce/{msg}", method = RequestMethod.GET)
	public void produce(@PathVariable String msg) {
		System.out.println("testing-----");
		studentServiceDelegate.testmessage(msg);
	}
