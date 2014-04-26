package com.realcoders.bot.test;

import com.realcoders.bot.message.PlayersHandler;
import com.realcoders.bot.network.MessageMapper;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by tomek on 4/26/14.
 */
public class MessageOpCodeTest {

    private MessageMapper mapper = new MessageMapper();

    @Test
    public void testObtainOpCode() {
        String message = "TheMessage something value";
        assertEquals("TheMessage", mapper.obtainOpCode(message));
    }

    @Test
    public void testObtainOpCodeOnly() {
        String message = "TheMessage2";
        String obcode = mapper.obtainOpCode(message);
        assertEquals("OPCODE: " + obcode, message, obcode);
    }

//    @Test
//    public void testPlayersList() {
//
//
//        String[] message = new String[]{"Players [\n", "MyBot\n", "TestBot\n", "]"};
//
//        PlayersHandler handler = new PlayersHandler();
//
//        handler.handle(message, null);
//        for (String item : handler.getPlayers()) {
//            System.out.print("TEST: " + item + "\n");
//        }
//
//    }
}
