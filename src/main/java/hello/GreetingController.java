package hello;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping
    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
    	System.out.println("Name: -> "+name);
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
    
    @PutMapping("/greeting_put")
    public Greeting greeting_put(@RequestParam(value="name", defaultValue="PUT") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
}
