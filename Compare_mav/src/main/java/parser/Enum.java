package parser;

import com.github.javaparser.ast.Modifier;
import com.github.javaparser.ast.body.EnumDeclaration;
import io.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chris Cavazos on 10/29/2017.
 */
public class Enum {

    private String name;
    private EnumDeclaration dec;

    Enum(EnumDeclaration dec) {
        this.name = dec.getNameAsString();
        this.dec = dec;
    }

    public void print(String tab) {
        StringBuilder mod = new StringBuilder();
        for (Modifier m : dec.getModifiers()) {
            mod.append(m.asString()).append(" ");
        }
        Logger.out(tab + mod + name + ":");
    }


    /** Setters And Getters */
    public List<String> getTypes() {
        List<String> e = new ArrayList<>();
        dec.getEntries().forEach(x -> e.add(x.getName().asString()));
        return e;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EnumDeclaration getDec() {
        return dec;
    }

    public void setDec(EnumDeclaration dec) {
        this.dec = dec;
    }

}
