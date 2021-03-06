package br.com.saltopetmanager.matheustirabassi.saltopetmanager.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.saltopetmanager.matheustirabassi.saltopetmanager.domain.Login;
import br.com.saltopetmanager.matheustirabassi.saltopetmanager.services.LoginService;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping(value = "/logins")
public class LoginResource {
    @Autowired
    private LoginService service;
    

    @GetMapping(value = "{id}")
    public ResponseEntity<Login> find(@PathVariable String id) {
	Login obj = service.findByLogin(id);

	return ResponseEntity.ok().body(obj);
    }

    @GetMapping
    public ResponseEntity<List<Login>> findAll() {
	List<Login> list = service.findAll();
	return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<Login> insert(@RequestBody Login obj) {
	obj.setPassword(getPasswordEncoder().encode(obj.getPassword()));
	obj = service.save(obj);
	return ResponseEntity.ok(obj);
    }

    @GetMapping("/passwordValidate")
    public ResponseEntity<Boolean> passwordValidate(@RequestParam String user, @RequestParam String password){

        Optional <Login> obj = Optional.ofNullable(service.findByLogin(user));
        if(obj.isEmpty()){
            log.error("User UNAUTHORIZED!!!");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false);
        }
        boolean valid = false;
        valid = getPasswordEncoder().matches(password, obj.get().getPassword());

	    HttpStatus status = (valid) ? HttpStatus.OK: HttpStatus.UNAUTHORIZED;
        return ResponseEntity.status(status).body(valid);

    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
	return new BCryptPasswordEncoder();
    }
}
