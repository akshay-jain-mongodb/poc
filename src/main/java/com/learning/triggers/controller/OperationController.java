package com.learning.triggers.controller;

import com.learning.triggers.registry.CollectionOperationRegistry;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class OperationController {

//    private final ObjectProvider<CollectionOperationRegistry> registryProvider;
//
//    @PostMapping("/{collection}/{operation}")
//    public ResponseEntity<String> performOperation(
//            @PathVariable String collection,
//            @PathVariable String operation,
//            @RequestBody Map<String, Object> payload
//    ) {
//        registryProvider.getObject().invokeHandler(collection, operation, payload);
//        return ResponseEntity.ok("Operation executed");
//    }
}
