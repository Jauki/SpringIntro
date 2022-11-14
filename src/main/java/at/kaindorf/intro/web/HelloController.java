package at.kaindorf.intro.web;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.awt.geom.Point2D;

// markiert für den IoC Container
@RestController
@RequestMapping("/service")
public class HelloController {

    // @RequestMapping(method = RequestMethod.GET, path = "/hello")
    @GetMapping("/hello")
    public String sayHello(@RequestParam(name = "to", defaultValue = "5CHIF") String to) {
        return "Hello " + to;
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Point2D getPoint(@PathVariable(name = "id") int id) {
        return switch (id) {
            case 1 -> new Point2D.Float(1.0f, 5.0f);
            default -> new Point2D.Float(20.0f, 0.0f);
        };
    }

}
