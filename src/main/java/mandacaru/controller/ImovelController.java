package mandacaru.controller;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import mandacaru.model.Imovel;
import mandacaru.service.ImovelService;
 
@RestController
@RequestMapping(path = "/api") 
public class ImovelController {
 
    @Autowired
    ImovelService service;
    
    @GetMapping(path = "/usuarios/{id}/imoveis")
    public ResponseEntity<List<Imovel>> findallofuser(@PathVariable(value = "id") int id) {
        return new ResponseEntity<List<Imovel>>(service.findAllOfUser(id), HttpStatus.OK);
    }
    
    @GetMapping(path = "/imoveis")
    public ResponseEntity<List<Imovel>> findall() {
        return new ResponseEntity<List<Imovel>>(service.findAll(), HttpStatus.OK);
    }
 
    @GetMapping(path = "/imoveis/{id}")
    public ResponseEntity<Imovel> find(@PathVariable("id") int id) {
        return new ResponseEntity<Imovel>(service.find(id), HttpStatus.OK);
    }
    
    @GetMapping(path = "/teste")
    public String teste() {
    	RestTemplate restTemplate = new RestTemplate();
    	String url = "https://reqres.in/api/users?page=2";
    	String result = restTemplate.getForObject(url, String.class);
    	
        return result;
    }
    
    //
    
    @PostMapping(path = "/usuarios/{id}/imoveis")
    public void save(@PathVariable("id") int usuario_id,@RequestBody Imovel imovel) {
    		
        service.save(usuario_id, imovel);
    }
 
    //
    
    @PutMapping(path = "/imoveis/{id}")
    public void update(@PathVariable("id") int id, @RequestBody Imovel imovel) {
        service.update(id, imovel);
    }
 
    //
    
    @DeleteMapping(path = "/imoveis/{id}")
    public void delete(@PathVariable("id") int id) {
        service.delete(id);
    }
}