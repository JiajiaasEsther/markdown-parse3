import static org.junit.Assert.*;
import org.junit.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class MarkdownParseTest {
    @Test
    public void testSnippet1(){
        try {
    assertEquals(List.of("[a link](url.com)", "another link`", "cod[e", "code]"),
    MarkdownParse.getLinks(Files.readString(Path.of("Snippet1.md"))));
     } catch (IOException e) {
        // TODO Auto-generated catch blocksd
        e.printStackTrace();
        }
    }

    @Test
    public void testSnippet2(){
        try {
    assertEquals(List.of("[a nested link](b.com)", "a nested parenthesized url", 
        "some escaped [ brackets ]"),
    MarkdownParse.getLinks(Files.readString(Path.of("Snippet2.md"))));
    } catch (IOException e) {
        // TODO Auto-generated catch blocksd
        e.printStackTrace();
        }
    }

    @Test
    public void testSnippet3(){
        try {
    assertEquals(List.of("this title text is really long and takes up more than one line and has some line breaks]( https://www.twitter.com )", 
        "this title text is really long and takes up more than one line",
        "[this link doesn't have a closing parenthesis](github.com And there's still some more text after that.", 
        "[this link doesn't have a closing parenthesis for a while](https://cse.ucsd.edu/)",
        "And then there's more text"),
    MarkdownParse.getLinks(Files.readString(Path.of("Snippet3.md"))));
    } catch (IOException e) {
        // TODO Auto-generated catch blocksd
        e.printStackTrace();
        }
    }      
}


