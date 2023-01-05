package org.greenGroup.commands;

import javax.servlet.ServletException;
import java.io.IOException;

public class AddCommand extends FrontCommand{
    @Override
    public void process() throws ServletException, IOException {
        forward("add");
    }
}
