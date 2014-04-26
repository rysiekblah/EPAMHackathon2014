package com.realcoders.bot.test;

import com.realcoders.bot.network.Message;
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

}
