package mars.robot.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.context.WebApplicationContext;
import java.nio.charset.Charset;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

/**
 * Created by Renato Rosseti on 24/01/17.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.MOCK)
@WebAppConfiguration
public class MarsControllerTest {

    private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setup() throws Exception {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void motionRobotSucceed_whenRobotRotatesToRight() throws Exception {
        MvcResult result = mockMvc.perform(post("/rest/mars/MMRMMRMM")
                .content("")
                .contentType(contentType))
                .andExpect(status().isOk())
                .andReturn();

        String content = result.getResponse().getContentAsString();
        Assert.assertEquals("(2, 0, S)",content);
    }

    @Test
    public void motionRobotSucceed_whenRobotMoveToLeftInTwoRequests() throws Exception {
        MvcResult result = mockMvc.perform(post("/rest/mars/MML")
                .content("")
                .contentType(contentType))
                .andExpect(status().isOk())
                .andReturn();

        String response1 = result.getResponse().getContentAsString();
        Assert.assertEquals("(0, 2, W)",response1);

        result = mockMvc.perform(post("/rest/mars/MML")
                .content("")
                .contentType(contentType))
                .andExpect(status().isOk())
                .andReturn();

        String response2 = result.getResponse().getContentAsString();
        Assert.assertEquals("(0, 2, W)",response2);
    }

    @Test
    public void motionRobotSucceed_whenRobotMovesRightAlongTheLimitedBordersToTheTheInitialPosition() throws Exception {
        MvcResult result = mockMvc.perform(post("/rest/mars/MMMMRMMMMRMMMMRMMMMR")
                .content("")
                .contentType(contentType))
                .andExpect(status().isOk())
                .andReturn();

        String content = result.getResponse().getContentAsString();
        Assert.assertEquals("(0, 0, N)",content);
    }

    @Test
    public void robotExceptionHandled_whenCommandIsInvalid() throws Exception {
        MvcResult result = mockMvc.perform(post("/rest/mars/AAA")
                .content("")
                .contentType(contentType))
                .andExpect(status().isBadRequest())
                .andReturn();

        String content = result.getResponse().getContentAsString();
        Assert.assertEquals("400 Bad Request",content);
    }

    @Test
    public void robotExceptionHandled_whenFinalPositionIsInvalid() throws Exception {
        MvcResult result = mockMvc.perform(post("/rest/mars/MMMMMMMMMMMMMMMMMMMMMMMM")
                .content("")
                .contentType(contentType))
                .andExpect(status().isBadRequest())
                .andReturn();

        String content = result.getResponse().getContentAsString();
        Assert.assertEquals("400 Bad Request",content);
    }

    /**
     * When robot crosses the limited space and tries to move back to a valid position:
     * The final position is valid, but first the robot had crossed the limited space and then an exception was thrown.
     */
    @Test
    public void robotExceptionHandled_whenRobotCrossesTheLimitedSpaceAndTriesToMoveBack() throws Exception {

        MvcResult result = mockMvc.perform(post("/rest/mars/MMMMMRRMM")
                .content("")
                .contentType(contentType))
                .andExpect(status().isBadRequest())
                .andReturn();

        String content = result.getResponse().getContentAsString();
        Assert.assertEquals("400 Bad Request",content);
    }

}
