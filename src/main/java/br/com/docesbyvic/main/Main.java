package br.com.docesbyvic.main;

import br.com.docesbyvic.telas.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Main {

    @Autowired
    private Menu menu; // Spring vai injetar

    public void display() {
        menu.displayMenu();
    }
}
