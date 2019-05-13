package hello;

import hello.model.Band;
import hello.repo.BandRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloControllerTest {

    @MockBean
    private BandRepository bandRepository;

    @Autowired
    private HelloController helloController;

    private List<Band> bands = new ArrayList<>();
    private String testString = "Test";

    @Before
    public void before() {
        bands.add(Mockito.mock(Band.class));
        bands.add(Mockito.mock(Band.class));
    }


    @Test
    public void testGetBandsByBandName() {
        Mockito
                .when(bandRepository.findByBandNameRegex(Mockito.anyString()))
                .thenReturn(bands);

        List<Band> bandList = helloController.getBands(testString);
        Assert.assertEquals(bands, bandList);
    }

}
