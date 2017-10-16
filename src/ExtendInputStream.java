//OS Ass 2 - Q1 - Server
//Alana Staszczyszyn & Elijah Tavenor
//October 19, 2017

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Alana on 2017-10-15.
 */
public class ExtendInputStream extends InputStream {

    InputStream input;

    public ExtendInputStream(InputStream stream){
        this.input = stream;
    }

    @Override
    public int read() throws IOException {
        return this.input.read();
    }

}
