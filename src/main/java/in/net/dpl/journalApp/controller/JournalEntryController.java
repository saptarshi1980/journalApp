package in.net.dpl.journalApp.controller;


import in.net.dpl.journalApp.entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {

    private Map<Long, JournalEntry> journalEntry= new HashMap<>();

    @GetMapping("/getall")
    public List<JournalEntry> listAll(){
        return new ArrayList<>(journalEntry.values());
    }

    @PostMapping("/create")
    public boolean createEntry(@RequestBody JournalEntry myEntry){

        journalEntry.put(myEntry.getId(),myEntry);
        return true;


    }

    @GetMapping("/get/{id}")
    public JournalEntry getJournalByid(@PathVariable Long id){

        return journalEntry.get(id);



    }

    @GetMapping("/delete/{id}")
    public JournalEntry deleteJournalByid(@PathVariable Long id){

        return journalEntry.remove(id);

    }

    @PutMapping("/id/{id}")
    public JournalEntry update(@PathVariable Long id,@RequestBody JournalEntry myEntry){

        return journalEntry.put(id,myEntry);
    }

}
