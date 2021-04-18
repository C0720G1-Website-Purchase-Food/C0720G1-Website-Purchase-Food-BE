package com.codegym.controller;

import com.codegym.entity.Store;
import com.codegym.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/public/store")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class StoreController {

    @Autowired
    StoreService storeService;

    @RequestMapping(value = "/store", method = RequestMethod.GET, params = {"page", "size"})
    public ResponseEntity<Page<Store>> pageTopic(@RequestParam("page") int page,
                                                 @RequestParam("size") int size) {
        Page<Store> topics = storeService.findAllStore(PageRequest.of(page, size));
        if (topics.isEmpty()) {
            return new ResponseEntity<Page<Store>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Page<Store>>(topics, HttpStatus.OK);
    }

    @RequestMapping(value = "/store/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Store> findByIdStore(@PathVariable("id") Integer id){
        Store store = storeService.findById(id);
        if (store == null){
            return new ResponseEntity<Store>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Store>(store, HttpStatus.OK);
    }
}
