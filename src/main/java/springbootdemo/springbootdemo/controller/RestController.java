package springbootdemo.springbootdemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMethod;
import springbootdemo.springbootdemo.service.DataService;

@Controller
public class RestController {

    @Autowired
    DataService dataService;

    @RequestMapping(value = "/getStudentData", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Object> getStudentData() {

        // how you return different status codes
        // if all goes well it will be a 200 and if not it will return a 500 error
        try {
            return ResponseEntity.status(HttpStatus.OK).body(dataService.getData());
        } catch (Exception e) {
            // this error is 500 if there is something wrong
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Server Internal Error");
        }
    }
}

// you need try catches
// condition statements
// and logging for software engineering/programming