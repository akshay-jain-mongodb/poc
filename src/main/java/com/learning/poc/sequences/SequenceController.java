package com.learning.poc.sequences;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sequence")
public class SequenceController {
//
//    @Autowired
//    private SequenceGeneratorService sequenceService;
//
//    @GetMapping("/{name}")
//    public ResponseEntity<SequenceBlock> getSequenceBlock(
//            @PathVariable String name,
//            @RequestParam(defaultValue = "100") int blockSize) {
//        return ResponseEntity.ok(sequenceService.getNextSequenceBlock(name, blockSize));
//    }
}