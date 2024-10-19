package org.example.test_spring.ws;

import jakarta.transaction.Transactional;
import org.example.test_spring.Bean.Commande;
import org.example.test_spring.Service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("gestion-commande/commands")
public class CommandeProvider {

    @PostMapping("/add")
    public int save(@RequestBody Commande commande) {
        return commandeService.save(commande);
    }

    @GetMapping("/count")
    public long count() {
        return commandeService.count();
    }

    @PostMapping("/payer/ref/{ref}/montant/{montant}")
    public int payer(@PathVariable String ref, @PathVariable double montant) {
        return commandeService.payer(ref, montant);
    }

    @GetMapping("/ref/{ref}")
    public Commande findByRef(@PathVariable String ref) {
        return commandeService.findByRef(ref);
    }
    @Transactional
    @DeleteMapping("/del/{ref}")
    public void deleteByRef(@PathVariable String ref) {
        commandeService.deleteByRef(ref);
    }

    @GetMapping("/showall")
    public List<Commande> showAll() {
        return commandeService.findAll();
    }

    @Autowired
    private CommandeService commandeService;
}
