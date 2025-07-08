package com.example.demo.endpoint.rest.controller.health;

import com.example.demo.service.StoredIntService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class StoredIntController {
    private StoredIntService storedIntService;

    @GetMapping("/stored-int")
    public int getStoredInt() {
        return storedIntService.getStoredInt();
    }
}