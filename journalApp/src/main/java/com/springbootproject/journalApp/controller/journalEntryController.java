package com.springbootproject.journalApp.controller;

import com.springbootproject.journalApp.entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.*;
@RestController
@RequestMapping("/journal")
public class journalEntryController {

private Map<Long, JournalEntry> journalEntries=new HashMap<>();
    @GetMapping
    public List<JournalEntry> getAll(){ //localhost:8080/journal GET
        return new ArrayList<>(journalEntries.values());
    }

    @GetMapping("/{myid}")  //to find the data
    public JournalEntry getJournalEntryById(@PathVariable Long myid){ //localhost:8080/journal GET
        return journalEntries.get(myid);
    }

    @PostMapping  ////localhost:8080/journal POST   // for create data
    public boolean createEntry(@RequestBody JournalEntry myEntry){
journalEntries.put(myEntry.getId(),myEntry);
return true;
    }

    @PutMapping("/{id}")  //For update
    public JournalEntry updateJournalById(@PathVariable Long id,@RequestBody JournalEntry myEntry){
        return journalEntries.put(id,myEntry);
    }
}
