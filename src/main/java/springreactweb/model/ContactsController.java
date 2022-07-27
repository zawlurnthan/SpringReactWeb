package springreactweb.model;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.Collection;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class ContactsController {
    private final ContactRepository contactRepository;

    public ContactsController(ContactRepository contactRepository){
        this.contactRepository = contactRepository;
    }


    @GetMapping("/contacts")
    Collection<Contact> contacts(){
        return (Collection<Contact>) contactRepository.findAll();
    }

    @PostMapping("/contacts")  //
    ResponseEntity<Contact> createContact(@Valid @RequestBody Contact contact) throws URISyntaxException {
        Contact result = contactRepository.save(contact);
        return ResponseEntity.ok().body(result);
    }
}
